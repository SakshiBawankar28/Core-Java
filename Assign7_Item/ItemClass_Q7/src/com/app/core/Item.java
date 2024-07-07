package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable {
	
	private int item_code;
	private String description;
	private double price;
	private LocalDate shipment_date;
	private static int id_Generated;
	
	public Item(String description, double price, LocalDate shipment_date) {
		super();
		this.item_code = ++id_Generated;
		this.description = description;
		this.price = price;
		this.shipment_date = shipment_date;
	}

	public int getItem_code() {
		return item_code;
	}

	public void setItem_code(int item_code) {
		this.item_code = item_code;
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

	public LocalDate getShipment_date() {
		return shipment_date;
	}

	public void setShipment_date(LocalDate shipment_date) {
		this.shipment_date = shipment_date;
	}

	@Override
	public String toString() {
		return "Item [item_code=" + item_code + ", description=" + description + ", price=" + price + ", shipment_date="
				+ shipment_date + "]";
	}
	
	
	
	

}
