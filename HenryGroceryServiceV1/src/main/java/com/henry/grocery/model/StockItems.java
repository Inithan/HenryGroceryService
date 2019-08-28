package com.henry.grocery.model;

public class StockItems {

	private String product;
	private String unit;
	private Double cost;
	
	public StockItems() {}
	public StockItems(String product, String unit, Double cost) {
		super();
		this.product = product;
		this.unit = unit;
		this.cost = cost;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "StockItems [product=" + product + ", unit=" + unit + ", cost=" + cost + "]";
	}
	
}
