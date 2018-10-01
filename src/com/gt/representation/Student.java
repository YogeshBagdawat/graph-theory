package com.gt.representation;

public class Student {
	private String firstName;
	private String lastName;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String firstName, String lastname) {
		this.firstName = firstName;
		this.lastName = lastname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
