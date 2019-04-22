package com.java.fx_controlers;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;

public class ShoppingBasket {
	
	private long idProduct;
	private String nameProduct;
	private Double pvp;
	private Spinner spinnerQuantity = new Spinner();
	private Double totalAmount;
	private static FormMainControler frmParent;
	
	final int initialValue = 1;
	SpinnerValueFactory<Integer> valueFactory;
	
	
	public ShoppingBasket(long idProduct, String nameProduct, Double pvp, Spinner spinnerQuantity, int maxValueStock) {
		super();
		this.idProduct = idProduct;
		this.nameProduct = nameProduct;
		this.pvp = pvp;
		this.spinnerQuantity = spinnerQuantity;
		this.totalAmount = pvp;
						
		valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, maxValueStock, initialValue);
		spinnerQuantity.setValueFactory(valueFactory);
		
		spinnerQuantity.setOnMouseReleased((MouseEvent event) -> {
			totalAmount = pvp * (int) spinnerQuantity.getValue();
			frmParent.fx_tabViewCarrito.refresh();
			frmParent.actualizarTotalCesta();
		});
		
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
