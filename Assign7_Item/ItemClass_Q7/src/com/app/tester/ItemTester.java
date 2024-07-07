package com.app.tester;

import static com.app.Utils.ItemValidation.addItemInList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.app.core.Item;

public class ItemTester {

	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {

			boolean exit = false;
			Map<Integer, Item> mapList = new HashMap<>();
			while (!exit) {
				System.out.println("Options : 1.Add details \n" + "2. Display Items \n"
						+ "3. sort details by item_code and store in binary file \n"
						+ "4. Sort details by Item_Price and store in binary file" + "5. Read details by item_Price ");
				System.out.println("Choose : ");

				try {
					switch (sc.nextInt()) {

					case 1:
						System.out.println("Enter description ,price, shippind_date");
						Item itemList = addItemInList(sc.next(), sc.nextDouble(), sc.next(), mapList);
						mapList.put(itemList.getItem_code(), itemList);
						System.out.println("Item added successfully");
						break;

					case 2:
						System.out.println("Display Items");
						for (Item list : mapList.values())
							System.out.println(list);
						break;

					case 3:
						System.out.println("Sort this details by itemCode ");
						System.out.println("Enter file name");
						String fileName = sc.next();
						// ser
						try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
							for (Item i : mapList.values())
								out.writeObject(i);
							Map<String, Item> treemap = new TreeMap<>();
							for (Item i : treemap.values())
								System.out.println(i);
						}
						break;

					case 4:
						System.out.println("Sort the details by price");
						System.out.println("Enter file name");
						String fileName1 = sc.next();
						// ser
						try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName1))) {

							for (Item i : mapList.values())
								out.writeObject(i);
							
							LinkedList<Item> list = new LinkedList<>(mapList.values());
							Collections.sort(list, new Comparator<Item>() {

								@Override
								public int compare(Item o1, Item o2) {

									return ((Double) o1.getPrice()).compareTo(o2.getPrice());
								}
							});
							for(Item i1:list)
								System.out.println(i1);
						}
						
						break;
					case 5:
						System.out.println("Enter file name");
						String fileName2 = sc.next();
						// change ser to deser
						try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName2))) {

							for (Item i : mapList.values()) {
								in.readObject();
								System.out.println(i);
							}
							break;
						}

					}
				} catch (Exception e) {
					sc.nextLine();
					System.out.println(e);
				}
			}

		}
	}

}
