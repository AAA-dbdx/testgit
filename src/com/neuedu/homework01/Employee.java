package com.neuedu.homework01;

public class Employee {

	private int iD;
	private String name;
	
	public Employee() {
		
	}

	public Employee(int iD, String name) {
		this.iD = iD;
		this.name = name;
	}

	public int getID() {
		return iD;
	}

	public void setID(int iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "ID："+iD+"  name："+name;
	}
	
}
