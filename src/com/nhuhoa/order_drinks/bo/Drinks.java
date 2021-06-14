package com.nhuhoa.order_drinks.bo;

public class Drinks {
	private int drink_id;
	private String drink_name;
	private String type;
	private String description;
	private double price;
	private String image;
	public int getDrink_id() {
		return drink_id;
	}
	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}
	public String getDrink_name() {
		return drink_name;
	}
	public void setDrink_name(String drink_name) {
		this.drink_name = drink_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
