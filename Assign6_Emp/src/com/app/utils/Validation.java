package com.app.utils;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import com.app.emp_exception.EmployeeException;
import com.app.entities.Employee;
import com.app.entities.FullTimeEmp;
import com.app.entities.PartTimeEmp;

public class Validation {
	public static FullTimeEmp validateFullTimeEmp(String name, String dateOfJoining, String phonoNo, Long adharNo,
			double salary, List<Employee>list) throws EmployeeException {
		// String name, LocalDate dateOfJoining, String phonoNo, Long adharNo, double
		// salary
		checkForDulAdhar(adharNo, list);
		validatePhone(phonoNo);
		checkForDulAdhar(adharNo, list);
		LocalDate date = parseDate(dateOfJoining);
		return new FullTimeEmp(name, date, phonoNo, adharNo, salary);
	}

	public static PartTimeEmp validatePartTimeEmp(String name, String dateOfJoining, String phonoNo, Long adharNo,
			double amount, List<Employee>list) throws EmployeeException {
		// String name, LocalDate dateOfJoining, String phonoNo, Long adharNo, double
		// salary
		checkForDulAdhar(adharNo, list);
		validatePhone(phonoNo);
		LocalDate date = parseDate(dateOfJoining);
		return new PartTimeEmp(name, date, phonoNo, adharNo, amount);
	}

	//check for duplicate adhar number
	public static void checkForDulAdhar(Long adharno, List<Employee>list) throws EmployeeException
	{
		Employee emp = new Employee(adharno);
		if(list.contains(emp))
			throw new EmployeeException("Duplicate adhar number !!");
	}
	
	////adhar number validations
//	public static void validateAdhar(Long adharno)
//	{
//		Employee emp = new Employee(adharno);
//		String regex = "(^[0-9]*$.{12})";
//		if(adharno.matches(regex))
//			
//	}
	
	//phone number validation
	public static void validatePhone(String phoneno) throws EmployeeException
	{
		Employee emp = new Employee(phoneno);
		String regex = "^[0-9]{10}$";   /*"(^[0-9]*$.{10})"*/
		if(!phoneno.matches(regex))
			throw new EmployeeException("Phono number size must be 10");
			
	}
	
	// delete emp by id search
	public static void deleteEmp(int id, List<Employee> list) throws EmployeeException {
		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			if (id == emp.getId()) {
				it.remove();
				System.out.println("Delete employee");
			} else {
				throw new EmployeeException("Invalid id, employee can't remove");
			}
		}
	}

//	 search emp by adharno
	public static Employee empSearchByAdhar(Long adharno, List<Employee> emp) throws EmployeeException {
		Employee em = new Employee(adharno);
		int index = emp.indexOf(em);
		if (index == -1)
			throw new EmployeeException("Invalid adhar number");
		return emp.get(index);
	}

	public static LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

}
