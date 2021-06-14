package com.nhuhoa.order_drinks.bo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Orders {
	private int order_id;
	private int user_id;
	private int drink_id;
	private int quantity;
	private double total;
	private LocalDateTime order_date;
	private String comment;
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getDrink_id() {
		return drink_id;
	}
	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}
	
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public LocalDateTime getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		DateTimeFormatter myFormat =DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		this.order_date = LocalDateTime.parse(order_date, myFormat);
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
