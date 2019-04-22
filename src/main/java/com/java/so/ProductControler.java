package com.java.so;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductControler {
	
	
	Map<String, Double> productos = new HashMap<String, Double>();
	Map<String, Integer> stockProductos = new HashMap<String, Integer>();
		
	public void cargarProductos(List<Product> listProducts) {
		listProducts.stream().forEach(a -> productos.put(a.getNameProduct(), a.getPrice()));
	}
	
	public void cargarStock(List<Product> listProducts) {
		listProducts.stream().forEach(a -> stockProductos.put(a.getNameProduct(), a.getStock()));
	}

	
	@Override
	public String toString() {
		return "ProductControler [productos=" + productos + "]";
	}
	
}
