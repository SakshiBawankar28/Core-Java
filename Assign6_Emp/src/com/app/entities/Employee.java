package com.app.entities;

import java.time.LocalDate;

public class Employee 
{
	//Name, Date of joining, Phone Number, Aadhaar number 
	private int id;
	private static int idGenerator;
	private String name;
	private LocalDate dateOfJoining;
	private String phonoNo;
	private Long adharNo;
	
	public Employee(String name, LocalDate dateOfJoining, String phonoNo, Long adharNo) {
		super();
		this.id = ++idGenerator;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.phonoNo = phonoNo;
		this.adharNo = adharNo;
	}
	
	public Employee(Long adharNo)
	{
		this.phonoNo = phonoNo;
	}
	
	public Employee(String phonoNo)
	{
		this.adharNo = adharNo;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getPhonoNo() {
		return phonoNo;
	}

	public void setPhonoNo(String phonoNo) {
		this.phonoNo = phonoNo;
	}

	public Long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(Long adharNo) {
		this.adharNo = adharNo;
	}

	
	@Override
	public boolean equals(Object o) 
	{
		System.out.println("in equals");
		if(o instanceof Employee)
		return this.adharNo.equals(((Employee) o).adharNo);
		return false;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfJoining=" + dateOfJoining + ", phonoNo=" + phonoNo
				+ ", adharNo=" + adharNo + "]";
	}
	
}
