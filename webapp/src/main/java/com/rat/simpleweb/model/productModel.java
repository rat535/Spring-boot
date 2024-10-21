package com.rat.simpleweb.model;

public class productModel {

	private int ProdId;
	private String prodName;
	private int price;
	
	public productModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public productModel(int prodId, String prodName, int price) {
		super();
		ProdId = prodId;
		this.prodName = prodName;
		this.price = price;
	}
	
	
	public int getProdId() {
		return ProdId;
	}
	public void setProdId(int prodId) {
		ProdId = prodId;
	}
	
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	



	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
