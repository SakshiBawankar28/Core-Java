package com.app.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Brand;
import com.app.entities.Material;
import com.app.entities.Pen;

public class Validations 
{
	public static Pen validatePen(String brand, String color, String inkColor, String material, int stoke, String updateDate,
			String listingDate, double price, double discount, List<Pen>pen) 
	{
		Brand br = validateBrand(brand);
		Material mat = validateMaterial(material);
		LocalDate ud = validateDate(updateDate);
		LocalDate ld = validateDate(listingDate);	
		return new Pen(br, color, inkColor, mat, stoke, ud, ld, price, discount);
		
	}
	public static LocalDate validateDate(String date)
	{
		return LocalDate.parse(date);
	}
	public static Brand validateBrand(String br)
	{
		return Brand.valueOf(br.toUpperCase());
	}
	public static Material validateMaterial(String mat)
	{
		return Material.valueOf(mat.toUpperCase());
	}
	
	
	public static List<Pen> populatedlist()
	{
		//cello black black plastic 12 2001-12-12 1999-02-02 20 30
		Pen p1 = new Pen(Brand.CELLO, "Black", "Black", Material.ALLOY_STEEL, 12, LocalDate.parse("2024-05-28"), 
				LocalDate.parse("2024-03-28"), 30, 10);
		Pen p2 = new Pen(Brand.PARKER, "Blue", "Blue", Material.METAL, 12, LocalDate.parse("2024-05-12"), 
				LocalDate.parse("2023-01-20"), 30, 25);
		Pen p3 = new Pen(Brand.REYNOLD, "Black", "Black", Material.PLASTIC, 12, LocalDate.parse("2024-04-28"), 
				LocalDate.parse("2024-03-12"), 30,32);
		Pen p4 = new Pen(Brand.CELLO, "Blue", "Blue", Material.ALLOY_STEEL, 12, LocalDate.parse("2024-05-28"), 
				LocalDate.parse("2023-03-28"), 30, 13);
		Pen p5 = new Pen(Brand.PARKER, "Black", "Black", Material.METAL, 12, LocalDate.parse("2024-01-02"), 
				LocalDate.parse("2023-12-28"), 30, 43);
		Pen p6 = new Pen(Brand.REYNOLD, "Red", "Red", Material.PLASTIC, 12, LocalDate.parse("2024-01-28"), 
				LocalDate.parse("2023-03-28"), 30, 38);
		Pen[]penArr = {p1,p2,p3,p4,p5,p6};
		List<Pen>penList = new ArrayList();
		for(Pen p : penArr)
			penList.add(p);
		return penList;
		
	}
}
