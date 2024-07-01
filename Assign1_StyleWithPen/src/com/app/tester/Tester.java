package com.app.tester;

import java.text.ParseException;
import java.time.Period;

import static com.app.utils.Validations.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.entities.Pen;
import com.app.utils.Validations;

public class Tester 
{
	public static void main(String[] args) throws ParseException
	{
		List<Pen> list = populatedlist();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		int id,stock,month;
		while(!exit)
		{
			//String brand, String color, String inkColor, String material, int stoke, String updateDate,
			//String listingDate, double price, double discount
			System.out.println("1.Add new pen  \n2.Display all pens \n3.Update stock of Pen "
					+ "\n4.Set discount of 20% for all the pens which are not at all sold in last 3 months\r\n"
					+ "5.Remove Pens which are never sold once listed in 9 months \n0. For exit");
			System.out.println("Enter option : ");
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter Pen Details : Brand,  color, inkColor, material, stoke, updateDate,  listingDate,"
						+ "	price,  discount");
				Pen pen = Validations.validatePen(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextInt(),
						sc.next(), sc.next(), sc.nextDouble(), sc.nextDouble(), list);
				list.add(pen);
				System.out.println("Added successfully");
				break;
				
			case 2:
				System.out.println("\nDisplay all pens");
				for(Pen p : list)
				{
					System.out.println(p);
				}
				break;
				
			case 3:
				System.out.println("update stock of pens");
				System.out.println("Enter the pen id and number of pens to update the stock");
				id = sc.nextInt();
				stock=sc.nextInt();
				for(Pen p: list) {
					if(p.getId()==id) {
						p.setStock(p.getStock()+stock);
						System.out.println("Stock updated");
					}
				}
				break;
				
			case 4:
				//int month = Period.between(ld, ud).getMonths();
				for(Pen p:list) {
					month = Period.between(p.getListingDate(), p.getUpdateDate()).getMonths();
					if(month>=3) {
						p.setDiscount(20);
						System.out.println("discount is set");
					}
				}
				break;
				
			case 5:
				Iterator it = list.iterator();
				while(it.hasNext()) {
					Pen p = (Pen)it.next();
					month = Period.between(p.getListingDate(),p.getUpdateDate()).getMonths();
					if(month>=9) {
						it.remove();
						System.out.println("Removed");
					}
				}
				break;
				
			case 0:
				exit = true;
				break;
			}
		}
	}
	
}
