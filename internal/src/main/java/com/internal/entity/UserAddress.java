package com.internal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "userAddress")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userAddressId", updatable = false, nullable = false)
	private int userAddressId;

	@Column(name = "mail", nullable = false, length = 500)
	private String mail;

	@Column(name = "addressLane1", nullable = false, length = 255)
	private String addressLane1;

	@Column(name = "addressLane2",  length = 255)
	private String addressLane2;

	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Column(name = "state", nullable = false, length = 50)
	private String state;

	@Column(name = "country", nullable = false, length = 50)
	private String country;

	@Column(name = "zip", nullable = false, length = 10)
	private String zip;

	@Column(name = "phone", nullable = false, length = 15)
	private String phone;
	

	
    @OneToOne
    @JsonBackReference(value = "userTOUserAddress")
    @JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAddress(int userAddressId, String mail, String addressLane1, String addressLane2, String city,
			String state, String country, String zip, String phone, User user) {
		super();
		this.userAddressId = userAddressId;
		this.mail = mail;
		this.addressLane1 = addressLane1;
		this.addressLane2 = addressLane2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		this.phone = phone;
		this.user = user;
	}

	public int getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(int userAddressId) {
		this.userAddressId = userAddressId;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddressLane1() {
		return addressLane1;
	}

	public void setAddressLane1(String addressLane1) {
		this.addressLane1 = addressLane1;
	}

	public String getAddressLane2() {
		return addressLane2;
	}

	public void setAddressLane2(String addressLane2) {
		this.addressLane2 = addressLane2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
