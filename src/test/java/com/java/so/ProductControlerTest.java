package com.java.so;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ProductControlerTest extends ProductControler {
	List <Product> p = new ArrayList<Product>();
	
	@Before
	public void CrearDatos() {
		
		p.add(new Product("Producto A", "A", 2, 2.5));
		p.add(new Product("Producto B", "B", 3, 3.5));
		p.add(new Product("Producto C", "C", 4, 4.5));
		p.add(new Product("Producto D", "D", 5, 5.5));
		p.add(new Product("Producto E", "E", 6, 6.5));
		p.add(new Product("Producto F", "F", 7, 7.5));	
	}
	
	@Test
	public void testCargarProductos() {
		this.cargarProductos(p);
		System.out.println(this.toString());
	}
		

}
