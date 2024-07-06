package com.app.entities;

import java.time.LocalDate;

public class PartTimeEmp extends Employee
{
	private double amount;

	//ctor
	public PartTimeEmp(String name, LocalDate dateOfJoining, String phonoNo, Long adharNo, double amount) {
		super(name, dateOfJoining, phonoNo, adharNo);
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return super.toString() + "	PartTimeEmp [amount=" + amount + "]";
	}

	
	
}
