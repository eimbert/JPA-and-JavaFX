package com.java.fx_controlers;

import java.util.ArrayList;
import java.util.List;

import com.java.so.Product;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Spinner;
import javafx.scene.control.cell.PropertyValueFactory;
import com.java.so.Client;
public class ControlerTabViewBasket {

	public static void cargarProductos(FormMainControler parentForm, ObservableList<ShoppingBasket> data) {
				
		parentForm.fx_tabViewCarrito.setItems(data); 
		parentForm.fx_tabViewCarrito.refresh();
		parentForm.fx_tabViewCarrito_idProducto.setCellValueFactory(new  PropertyValueFactory<ShoppingBasket,Long>("idProduct"));
		parentForm.fx_tabViewCarrito_producto.setCellValueFactory(new  PropertyValueFactory<ShoppingBasket,String>("nameProduct"));		
		parentForm.fx_tabViewCarrito_pvp.setCellValueFactory(new PropertyValueFactory<ShoppingBasket,Double>("pvp"));
		parentForm.fx_tabViewCarrito_cantidad.setCellValueFactory(new PropertyValueFactory<ShoppingBasket,Integer>("spinnerQuantity"));
		parentForm.fx_tabViewCarrito_total.setCellValueFactory(new PropertyValueFactory<ShoppingBasket,Double>("totalAmount"));
		
	}
	public static void deleteBasket(FormMainControler parentForm, ObservableList<ShoppingBasket> data) {
		data.clear();
		cargarProductos(parentForm, data);
	}
	
	public static ShoppingBasket addProductToBasket(FormMainControler parentForm, ObservableList<ShoppingBasket> data, Client client) {
		Product product = parentForm.fx_tableView_Productos.getSelectionModel().getSelectedItem();
		
		for(ShoppingBasket b: data) {
			if(b.getIdProduct() == product.getIdProduct()) {
				b.getSpinnerQuantity().increment();
				b.setCantidad(b.getCantidad() + 1);
				int xx = (int) b.getSpinnerQuantity().getValue();
				b.setTotalAmount(b.getPvp() * xx);
				return b;
			}
		}
		ShoppingBasket basket = new ShoppingBasket(product.getIdProduct(),  product.getNameProduct(),  product.getPrice(), new Spinner(), product.getStock(), client);
		basket.setFrmParent(parentForm);
		data.add(basket);
		return basket;
	}
}
