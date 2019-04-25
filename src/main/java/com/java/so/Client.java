package com.java.so;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.java.fx_controlers.ShoppingBasket;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	@Basic(optional = false)
	private String nombre;	
	@Basic(optional = false)
	private String user;
	@Basic(optional = false)
	private String password;
	
	@OneToMany(mappedBy="client",cascade=CascadeType.ALL, orphanRemoval=true)
	private List <ShoppingBasket> basketClient = new ArrayList<ShoppingBasket>();
	

	
	public Client(String nombre, String user, String password) {
		super();
		this.nombre = nombre;
		this.user = user;
		this.password = password;
		this.basketClient = null;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void sendItemsPurchased() {
		basketClient.clear(); 
	}
	public void addBasketItem(ShoppingBasket item) {
		basketClient.add(item);
	}
	public List <ShoppingBasket> getBasketItems(){
		return basketClient;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getIdCliente() {
		return idCliente;
	}
	

}
