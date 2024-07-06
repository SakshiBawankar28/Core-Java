package com.app.tester;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.app.entities.Employee;
import com.app.entities.FullTimeEmp;
import com.app.entities.PartTimeEmp;

import static com.app.utils.Validation.*;

public class Tester {

	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
			List<Employee> list = new ArrayList<>();
			boolean exit = false;
			
			while(!exit)
			{
				System.out.println("1.Add full time employee\r\n"
						+ "2.Add part time employee\r\n"
						+ "3.Display all employee details\r\n"
						+ "4.Search employee details by Aadhaar number\r\n"
						+ "5.Delete an employee by Emp\r\n"
						+ "6.Display all employee details sorted by date of joining\r\n"
						+ "0.Exit");
				System.out.println("Enter the option : ");
				try {
					switch (sc.nextInt()) {
					case 1:
						//String name, LocalDate dateOfJoining, String phonoNo, Long adharNo, double salary
						System.out.println("Enter full time employee dateails name, date of joining, phoneno, adharno, salary");
						FullTimeEmp fte = validateFullTimeEmp(sc.next(), sc.next(), sc.next(), sc.nextLong(), sc.nextDouble(), list);
						list.add(fte);
						System.out.println("Full time employee added successfully");
						break;
						
					case 2:
						//String name, LocalDate dateOfJoining, String phonoNo, Long adharNo, double salary
						System.out.println("Enter full time employee dateails name, date of joining, phoneno, adharno, salary");
						PartTimeEmp pte = validatePartTimeEmp(sc.next(), sc.next(), sc.next(), sc.nextLong(), sc.nextDouble(), list);
						list.add(pte);
						System.out.println("Part time employee added successfully");
						break;

					case 3:
						for(Employee emp : list)
							System.out.println(emp);
							
						break;
						
					case 4:
						System.out.println("Enter adhar number to search the employee");
						Employee emp = empSearchByAdhar(sc.nextLong(), list);
						System.out.println(emp);
						break;
						
					case 5:
						System.out.println("Enter employee id to delete the employee");
						deleteEmp(sc.nextInt(), list);
						break;
						
					case 6:
						Collections.sort(list, new Comparator<Employee>() 
						{
							@Override
							public int compare(Employee o1, Employee o2) 
							{
								return o1.getDateOfJoining().compareTo(o2.getDateOfJoining());
							}
						});
						break;
					
					case 0:
						exit = true;
						break;
					}
					
				}catch (Exception e) {
					e.printStackTrace();
					sc.nextLine();
				}
			}
		}

	}

}
