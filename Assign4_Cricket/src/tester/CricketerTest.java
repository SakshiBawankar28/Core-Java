package tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.entities.Cricketer;

public class CricketerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			List<Cricketer> list = new ArrayList<>();
			boolean exit = false;
			int counter =0;
			String email, name;
			int rating;
			while (!exit) {
				System.out.println(
						"1.Accept minimum 5 Cricketers in the collection.\r\n" + "2.Modify Cricketer's rating\r\n"
								+ "3.Search Cricketer by name\r\n" + "4.Display all Cricketers added in collection.\r\n"
								+ "5.Display All Cricketers in sorted form by rating. \n0.Exit");
				System.out.println("Enter option");
				try {
					switch (sc.nextInt()) {
					case 1:
						//String name, int age, String email, String Phone, int rating
						for(int i=0; i<5; i++)
						{
							++counter;
							if(counter < 6)
							{
								System.out.println("Enter name, age, email, phono, rating");
								Cricketer cr = new Cricketer(sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
								list.add(cr);
							}
						}
						System.out.println("Minimum 5 cricketer are added successfully");
						break;

					case 2:
						System.out.println("Enter email and rating of cricketer to update the rating");
						email = sc.next();
						rating = sc.nextInt();
						for(Cricketer crk : list)
						{
							if(crk.getEmail().equals(email))
							{
								crk.setRating(rating);
								System.out.println("rating updated");
							}
						}
						break;

					case 3:
						System.out.println("Enter name to search the cricketer");
						name = sc.next();
						for(Cricketer crk : list)
						{
							if(crk.getName().equals(name))
							{
								System.out.println(crk);
								//System.out.println("rating updated");
							}
						}
						break;

					case 4:
						for(Cricketer crkt : list)
							System.out.println(crkt);
						break;
						
					case 5:
						Collections.sort(list, new Comparator<Cricketer>() {

							@Override
							public int compare(Cricketer o1, Cricketer o2) {
								if(o1.getRating() < o2.getRating())
									return -1;
								if(o1.getRating() == o2.getRating())
									return 0;
								return 1;
							}
						});
						break;
						
					case 0:
						exit = true;
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}

		}

	}

}
