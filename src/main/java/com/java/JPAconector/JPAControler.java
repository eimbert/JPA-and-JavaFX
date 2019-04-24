package com.java.JPAconector;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.java.so.Client;
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
		List<Product> productList = em.createQuery("Select a From Product a", Product.class).getResultList();
		return productList;
	}
	
	public void persitObjProduct(Long idProducto, int newStock) {		 
		Product reg = em.find(Product.class, idProducto);
		reg.setStock(newStock);
		em.persist(reg);

	}
	public void persitObj(Object obj) {
		em.persist(obj);
	}
	
	public Client buscarUsuario(String usuario, String contrasenya) {	
		TypedQuery <Client> cl = em.createQuery("SELECT c FROM Client c WHERE c.user = :custUser", Client.class);
		return cl.setParameter("custUser", usuario).getSingleResult();
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
