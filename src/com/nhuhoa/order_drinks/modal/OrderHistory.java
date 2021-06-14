package com.nhuhoa.order_drinks.modal;

import java.time.LocalDateTime;

public class OrderHistory {
	private String drink_name;
	private String image;
	private double price;
	private int quantity;
	private double total;
	private LocalDateTime order_date;
	public String getDrink_name() {
		return drink_name;
	}
	public void setDrink_name(String drink_name) {
		this.drink_name = drink_name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getOrder_date() {
		return order_date;
	}
	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}
	
}
