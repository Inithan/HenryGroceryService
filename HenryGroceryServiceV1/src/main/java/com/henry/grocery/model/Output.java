package com.henry.grocery.model;

import java.util.List;

public class Output {

	private Long days;
	private List<ProductDetails> productDetails;
	private Double discount_price;
	private Double total_price;
	private Double final_price;
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
	public Double getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(Double discount_price) {
		this.discount_price = discount_price;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	public Double getFinal_price() {
		return final_price;
	}
	public void setFinal_price(Double final_price) {
		this.final_price = final_price;
	}
	@Override
	public String toString() {
		return "Output [days=" + days + ", productDetails=" + productDetails + ", discount_price=" + discount_price
				+ ", total_price=" + total_price + ", final_price=" + final_price + "]";
	}
	
}
