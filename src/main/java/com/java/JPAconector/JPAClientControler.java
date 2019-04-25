package com.java.JPAconector;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.java.so.Client;

public class JPAClientControler {

	public static Client buscarUsuario(String usuario, String contrasenya, EntityManager em) {	
		TypedQuery <Client> cl = em.createQuery("SELECT c FROM Client c WHERE c.user = :custUser", Client.class);
		return cl.setParameter("custUser", usuario).getSingleResult();
	}
}
