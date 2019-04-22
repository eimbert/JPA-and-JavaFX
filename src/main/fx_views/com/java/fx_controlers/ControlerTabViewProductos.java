package com.java.fx_controlers;

import com.java.so.Product;

import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControlerTabViewProductos {
	
	public static void cargarProductos(FormMainControler parentForm, ObservableList<Product> data) {
	
		parentForm.fx_tableView_Productos.setItems(data); 
		parentForm.fx_tableView_Productos_idProducto.setCellValueFactory(new  PropertyValueFactory<Product,Long>("idProduct"));
		parentForm.fx_tableView_Productos_producto.setCellValueFactory(new  PropertyValueFactory<Product,String>("nameProduct"));		
		parentForm.fx_tableView_Productos_descripcion.setCellValueFactory(new PropertyValueFactory<Product,String>("description"));
		parentForm.fx_tableView_Productos_pvp.setCellValueFactory(new PropertyValueFactory<Product,Double>("price"));
		parentForm.fx_tableView_Productos_stock.setCellValueFactory(new PropertyValueFactory<Product,Integer>("stock"));
	
	}
	
}
