package com.java.fx_controlers;

import javafx.beans.property.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.java.JPAconector.JPAControler;
import com.java.fx_message_manager.ControlMensajes;
import com.java.so.Client;
import com.java.so.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FormMainControler implements Initializable{
	JPAControler jpaControler = new JPAControler("cestaCompra");
	Client usuarioActivo = null;
	ObservableList<ShoppingBasket> dataBasket = FXCollections.observableArrayList();
	ObservableList<Product> dataProducts = FXCollections.observableArrayList();

	/**
	 *  CONTROLES PRODUCTOS
	 */
	@FXML
	protected TableView<Product> fx_tableView_Productos;
	@FXML
	protected TableColumn<Product, Long> fx_tableView_Productos_idProducto;
    @FXML
    protected TableColumn<Product, String> fx_tableView_Productos_descripcion;
    @FXML
    protected TableColumn<Product, Integer> fx_tableView_Productos_stock;
    @FXML
    protected TableColumn<Product, Double> fx_tableView_Productos_pvp;
    @FXML
    protected TableColumn<Product, String> fx_tableView_Productos_producto;
    @FXML
    /**
     *  CONTROLES LISTVIEW CARRITO
     */
    protected TableView<ShoppingBasket> fx_tabViewCarrito;
    @FXML
    protected TableColumn<ShoppingBasket, String> fx_tabViewCarrito_producto;
    @FXML
    protected TableColumn<ShoppingBasket, Integer> fx_tabViewCarrito_cantidad;
    
    @FXML
    protected TableColumn<ShoppingBasket, Double> fx_tabViewCarrito_pvp;
    @FXML
    protected TableColumn<ShoppingBasket, Long> fx_tabViewCarrito_idProducto;
    @FXML
    protected TableColumn<ShoppingBasket, Double> fx_tabViewCarrito_total;
    /**
     *  CONTROLES GENERALES
     */
    @FXML
    private PasswordField fx_contrasenya;
    @FXML
    private Button fx_btn_iniciar;
    @FXML
    private TextField fx_usuario;
    @FXML
    private Label fx_totalCompra;
    @FXML
    private Button fx_btnRealizarPedido;
    @FXML
    private MenuItem fx_menuTabViewProductos;
    @FXML
    private Label fx_nombreDeUsuarioActivo;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dataProducts.addAll(jpaControler.cargarProductos());
		listeners();
		
		ControlerTabViewProductos.cargarProductos(this, dataProducts);
		jpaControler.beginTransaction();
	}
	
	
	public void listeners() { 
		fx_tableView_Productos.setOnMouseClicked(( MouseEvent mouseEvent) ->{
			if(mouseEvent.getClickCount()==2) {
				if(usuarioActivo == null) {
					ControlMensajes.mostrarAlerta("Es necesario identificarse antes de iniciar la compra.");
				}else {
					//Añadir poroducto a la cesta de la compra
					jpaControler.persitObj(ControlerTabViewBasket.addProductToBasket(this, dataBasket));
					ControlerTabViewBasket.cargarProductos(this, dataBasket);
					actualizarTotalCesta();
					actualizarStock();
					
					jpaControler.persitObjProduct(fx_tableView_Productos.getSelectionModel().getSelectedItem().getIdProduct(),
												  fx_tableView_Productos.getSelectionModel().getSelectedItem().getStock());
				}
			}
		});
		
		fx_btnRealizarPedido.setOnMouseClicked((MouseEvent mouseEvent) ->{
			//commit del carrito, de los productos y del cliente
			jpaControler.commit();
			jpaControler.closeEm();
			//Borrar cesta compra
		});
		
		fx_btn_iniciar.setOnMouseClicked((MouseEvent mouseEvent) -> {
			if("".equals(fx_contrasenya.getText()) || "".equals(fx_usuario.getText())){
				ControlMensajes.mostrarAlerta("Es necesario introducir un usuario y contraseña validos.");
			}else {
				usuarioActivo = jpaControler.buscarUsuario(this.fx_usuario.getText(), this.fx_contrasenya.getText());
				fx_nombreDeUsuarioActivo.setText(usuarioActivo.getNombre());
			}
				
		});
	}
	
	public void actualizarTotalCesta() {
		double totalCompra = 0.0;
		for(ShoppingBasket reg: dataBasket) 
			totalCompra+=reg.getTotalAmount();
		fx_totalCompra.setText(Double.toString(totalCompra));
	}
	
	public void actualizarStock() {
		for(Product p: dataProducts) {
			if(p.getIdProduct() == fx_tableView_Productos.getSelectionModel().getSelectedItem().getIdProduct()) 
				if(p.getStock() > 0) p.setStock(p.getStock() - 1);
		}
		this.fx_tableView_Productos.refresh();
	}
}
