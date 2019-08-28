package com.henry.grocery.model;

import java.util.List;

public class Input {

	private Long days;
	private List<ProductDetails> productDetails;
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}
	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}
	@Override
	public String toString() {
		return "Input [days=" + days + ", productDetails=" + productDetails + "]";
	}

	
}
