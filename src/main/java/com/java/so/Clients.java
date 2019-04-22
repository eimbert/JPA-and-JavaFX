package com.java.so;

import javax.persistence.*;

import com.java.fx_controlers.ShoppingBasket;

@Entity
public class Clients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCliente;
	private String nombre;	
	private String user;
	private String password;
	
	@OneToOne
	private ShoppingBasket idBasket;
	
	
	
}
