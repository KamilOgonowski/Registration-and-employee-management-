package com.kamil.model;

public class RegisterUserModel {

	private String userName;
	private String city;
	private String country;
	private String password;
	@Override
	public String toString() {
		return "RegisterUserModel [userName=" + userName + ", city=" + city + ", country=" + country + ", password="
				+ password + "]";
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
	

}
