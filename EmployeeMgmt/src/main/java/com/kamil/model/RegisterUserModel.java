package com.kamil.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="Admin")
public class RegisterUserModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String city;
	private String country;
	private String password;
	
	
	
	public RegisterUserModel() {
		System.out.println("No-args Constructor required for internal use of hibernate");
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "RegisterUserModel [id=" + id + ", userName=" + userName + ", city=" + city + ", country=" + country
				+ ", password=" + password + "]";
	}
	

}
