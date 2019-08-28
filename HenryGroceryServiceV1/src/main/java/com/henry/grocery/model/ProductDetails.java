package com.henry.grocery.model;

public class ProductDetails {

	private String product;
	private Long count;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Product [product=" + product + ", count=" + count + "]";
	}
	
}
