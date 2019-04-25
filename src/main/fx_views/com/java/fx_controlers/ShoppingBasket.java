package com.java.fx_controlers;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.java.so.Client;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;

@Entity
public class ShoppingBasket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idBasket;
	@Basic(optional = false)
	private long idProduct;
	@Basic(optional = false)
	private String nameProduct;
	@Basic(optional = false)
	private Double pvp;
	@Basic(optional = false)
	private Double totalAmount;
	@Basic(optional = false)
	private int cantidad;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private Client client;
	
	@Transient
	private Spinner spinnerQuantity = new Spinner();
	@Transient
	private static FormMainControler frmParent;
	@Transient
	final int initialValue = 1;
	@Transient
	SpinnerValueFactory<Integer> valueFactory;
	
	
	
	public ShoppingBasket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShoppingBasket(long idProduct, String nameProduct, Double pvp, Spinner spinnerQuantity, int maxValueStock, Client client) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.pvp = pvp;
		this.spinnerQuantity = spinnerQuantity;
		this.totalAmount = pvp;
		this.cantidad = 1;
		this.client = client;
						
		valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxValueStock, initialValue);
		spinnerQuantity.setValueFactory(valueFactory);
		
		spinnerQuantity.setOnMouseReleased((MouseEvent event) -> {
			totalAmount = pvp * (int) spinnerQuantity.getValue();
			frmParent.fx_tabViewCarrito.refresh();
			frmParent.actualizarTotalCesta();
		});
		
	}
 
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public long getIdBasket() {
		return idBasket;
	}

	public void setIdBasket(long idBasket) {
		this.idBasket = idBasket;
	}

	public FormMainControler getFrmParent() {
		return frmParent;
	}

	public void setFrmParent(FormMainControler frmParent) {
		this.frmParent = frmParent;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public Double getPvp() {
		return pvp;
	}

	public void setPvp(Double pvp) {
		this.pvp = pvp;
	}

	public Spinner getSpinnerQuantity() {
		return spinnerQuantity;
	}

	public void setSpinnerQuantity(Spinner spinnerQuantity) {
		this.spinnerQuantity = spinnerQuantity;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
