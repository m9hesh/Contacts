package com.contacts.manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Contacts {
	private String name;
	private String phoneNumber;
	private String birthDate;
	private String email;
	private int age;

	public Contacts(String name, String phoneNumber, String birthDate, String email) throws ParseException {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.birthDate = birthDate;
		this.email = email;
		this.age = toAge(birthDate);
		
		/*SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		formatter.setLenient(false);
		Date toDate = formatter.parse(birthDate);// converts string to actual Date
		long toMilli = toDate.getTime();// converts Date to milliseconds since 1970
		long diff = new Date().getTime() - toMilli; // age int milliseconds.
		this.age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);*/

	}
	
	public Contacts(Contacts source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) throws ParseException {
		this.birthDate = birthDate;
		setAge(toAge(birthDate));
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}
	
	public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime() - formatter.parse(birthDate).getTime(); //age in milliseconds
        return (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
    }

	@Override
	public int hashCode() {
		return Objects.hash(age, birthDate, email, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contacts other = (Contacts) obj;
		return age == other.age && Objects.equals(birthDate, other.birthDate) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	public String toString() {
        return "Name: " + this.name + "\n" +
            "Phone number: " + this.phoneNumber + "\n" +
            "Birth Date: " + this.birthDate + "\n" +
            "Age: " + this.age + " year old\n";
    }

}
