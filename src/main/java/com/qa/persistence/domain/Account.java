package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long ID;
	@Column(length = 45)
	String firstName;
	@Column(length = 45)
	String lastName;
	@Column(length = 4)
	String accountNumber;

	public Account() {

	}

	public Account(String accountNumber, String fName, String lName) {

		firstName = fName;
		lastName = lName;
		this.accountNumber = accountNumber;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{\"firstName\": " + "\"" + this.firstName + "\"" + "," + "\n\"lastName\": " + "\"" + this.lastName
				+ "\"" + "," + "\"" + "accountNumber\":" + "\"" + this.accountNumber + "\"" + "}";
	}

	public Long getID() {
		return this.ID;
	}


	public String setFirstName(String name) {

		firstName = name;

		return "First Name Changed";
	}

	public String setLastName(String name) {

		lastName = name;

		return "Last Name Changed";
	}

	public String setAccountNumber(String id) {

		accountNumber = id;

		return "Account Number Changed";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getName() {

		return firstName + " " + lastName;
	}

}
