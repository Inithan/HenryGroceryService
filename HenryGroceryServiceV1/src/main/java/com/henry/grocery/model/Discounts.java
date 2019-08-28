package com.henry.grocery.model;

public class Discounts {

	private String offer;
	private Long valid_from;
	private Long valid_to;
	private String product;
	private String discount_product;
	private Double discount_percentage;
	
	public Discounts() {}
	public Discounts(String offer, Long valid_from, Long valid_to, String product, String discount_product,
			Double discount_percentage) {
		super();
		this.offer = offer;
		this.valid_from = valid_from;
		this.valid_to = valid_to;
		this.product = product;
		this.discount_product = discount_product;
		this.discount_percentage = discount_percentage;
	}
	public String getOffer() {
		return offer;
	}
	public void setOffer(String offer) {
		this.offer = offer;
	}
	public Long getValid_from() {
		return valid_from;
	}
	public void setValid_from(Long valid_from) {
		this.valid_from = valid_from;
	}
	public Long getValid_to() {
		return valid_to;
	}
	public void setValid_to(Long valid_to) {
		this.valid_to = valid_to;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getDiscount_product() {
		return discount_product;
	}
	public void setDiscount_product(String discount_product) {
		this.discount_product = discount_product;
	}
	public Double getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(Double discount_percentage) {
		this.discount_percentage = discount_percentage;
	}
	@Override
	public String toString() {
		return "Discounts [offer=" + offer + ", valid_from=" + valid_from + ", valid_to=" + valid_to + ", product="
				+ product + ", discount_product=" + discount_product + ", discount_percentage=" + discount_percentage
				+ "]";
	}
	
}
