package com.app.entities;

import java.time.LocalDate;

public class FullTimeEmp extends Employee
{
	private double salary;

	//ctor
	public FullTimeEmp(String name, LocalDate dateOfJoining, String phonoNo, Long adharNo, double salary) {
		super(name, dateOfJoining, phonoNo, adharNo);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString()+"	FullTimeEmp [salary=" + salary + "]";
	}

		
	
}
