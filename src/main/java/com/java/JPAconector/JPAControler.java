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

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void persitObj(Object obj) {
		em.persist(obj);
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
