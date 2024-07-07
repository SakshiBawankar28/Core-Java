package com.app.Utils;

import java.time.LocalDate;
import java.util.Map;

import com.app.core.Item;

public class ItemValidation {
	// description ,price, shippind_date
	public static Item addItemInList(String desc, double price, String date, Map<Integer, Item> maps) {

		LocalDate d = LocalDate.parse(date);
		return new Item(desc, price, d);

	}

}
