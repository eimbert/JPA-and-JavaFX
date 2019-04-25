package com.java.JPAconector;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.TypedQuery;

import com.java.so.Client;
import com.java.so.Product;

public class JPAProductControler {

	public static void persitObjProduct(Long idProducto, int newStock, EntityManager em ) {		 
		Product reg = em.find(Product.class, idProducto);
		reg.setStock(newStock);
		em.persist(reg);

	}

	public static List<Product> cargarProductos(EntityManager em ) {
		List<Product> productList = em.createQuery("Select a From Product a", Product.class).getResultList();
		return productList;
	}
	
}
