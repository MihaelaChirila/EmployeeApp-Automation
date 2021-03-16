package tstdata;

import utils.Reader;

public class NewUser {
	public String firstName;
	public String lastName;
	public String email;
	public String company;
	public String phoneNumber;
     
	public NewUser(String name) {
		this.firstName = Reader.json(name).get("firstName").toString();
		this.lastName = Reader.json(name).get("lastName").toString();
		this.email = Reader.json(name).get("email").toString();
		this.company = Reader.json(name).get("company").toString();
		this.phoneNumber = Reader.json(name).get("phoneNumber").toString();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getCompany() {
		return company;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
}
