package com.app.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Pen 
{
	private int id;
	private static int idGenerator;
	private  Brand brand ;
	private String color;
	private String inkColor;
	private Material material;
	private int stock;
	private LocalDate updateDate;
	private LocalDate listingDate;
	private double price;
	private double discount;
	
//	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//	public Pen(String brand, String color, String inkColor, int stoke, String material, String updateDate, String listingDate,
//			double price, double discount) throws ParseException {
//		super();
//		this.id = ++idGenerator;
//		this.brand =Brand.valueOf(brand.toUpperCase());
//		this.color = color;
//		this.inkColor = inkColor;
//		this.material = Material.valueOf(material.toUpperCase());
//		this.stoke = stoke;
//		this.updateDate = sdf.parse(updateDate);
//		this.listingDate = sdf.parse(listingDate);
//		this.price = price;
//		this.discount = discount;
//	}
	
	public Pen(Brand brand, String color, String inkColor, Material material, int stock, LocalDate updateDate,
			LocalDate listingDate, double price, double discount) {
		super();
		this.id = ++idGenerator;
		this.brand = brand;
		this.color = color;
		this.inkColor = inkColor;
		this.material = material;
		this.stock = stock;
		this.updateDate = updateDate;
		this.listingDate = listingDate;
		this.price = price;
		this.discount = discount;
	}
	public Pen(int stock)
	{
		this.stock = stock;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getInkColor() {
		return inkColor;
	}
	public void setInkColor(String inkColor) {
		this.inkColor = inkColor;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public LocalDate getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
	}
	public LocalDate getListingDate() {
		return listingDate;
	}
	public void setListingDate(LocalDate listingDate) {
		this.listingDate = listingDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Pen [id=" + id + ", brand=" + brand + ", color=" + color + ", inkColor=" + inkColor + ", material="
				+ material + ", stoke=" + stock + ", updateDate=" + updateDate + ", listingDate=" + listingDate
				+ ", price=" + price + ", discount=" + discount + "]";
	}
	
}
