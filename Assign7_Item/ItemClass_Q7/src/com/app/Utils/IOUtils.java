package com.app.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.app.core.Item;

public class IOUtils {
	
	public static void storeDetails(Map<String,Item> items, String filename) throws IOException {
		
		try (PrintWriter pw=new PrintWriter(new FileWriter(filename))) {
			pw.println("Shipment details before terminating");
			for(Item i: items.values())
				pw.println(i);
			pw.println();
			
		}
		
		System.out.println("Saved Info....");
	}

}
