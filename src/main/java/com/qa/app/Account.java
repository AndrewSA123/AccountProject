package com.qa.app;

public class Account extends Person {


	public Account() {

	}

	public Account(String fName, String lName, String accountNumber) {

		super.firstName = fName;
		super.lastName = lName;
		super.accountNumber = accountNumber;

	}

	public String setFirstName(String name) {

		super.firstName = name;

		return "Name Changed";
	}

	public String getName() {

		return super.firstName + " " + super.lastName;
	}

}
