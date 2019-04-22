package com.java.JPAconector;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.java.so.Product;

import javafx.collections.ObservableList;

public class JPAControler {
	private EntityManagerFactory emf;
	private EntityManager em;
	private String conectionEmf;
	
	
	
	public JPAControler(String conectionEmf ) {
		super();
		this.conectionEmf = conectionEmf;
		emf = Persistence.createEntityManagerFactory(conectionEmf);
		em = emf.createEntityManager();
	}

	public List<Product> cargarProductos() {
		
		
		//em = emf.createEntityManager();
		
		List<Product> productList = em.createQuery("Select a From Product a", Product.class).getResultList();
		
		
		//em.clear(); 
		//em.close(); 
		//emf.close();
		 
		
		return productList;
	}
	
	public void persitObjProduct(Long idProducto, int newStock) {		 
		Product reg = em.find(Product.class, idProducto);
		reg.setStock(newStock);
		em.persist(reg);

	}
	
	public void commit() {
		em.getTransaction().commit();
	}
	
	public void closeEm() {
		em.close();
	}
	
	public void beginTransaction() {
		em.getTransaction().begin();
	}
	
	public void quitarPersistencia() {
		//***************
	}
}