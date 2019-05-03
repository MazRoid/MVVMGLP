package com.mazroid.mvvm.model;

import com.google.gson.annotations.SerializedName;


public class EmpResponse{

	@SerializedName("website")
	public String website;

	@SerializedName("address")
	public Address address;

	@SerializedName("phone")
	public String phone;

	@SerializedName("name")
	public String name;

	@SerializedName("company")
	public Company company;

	@SerializedName("id")
	public int id;

	@SerializedName("email")
	public String email;

	@SerializedName("username")
	public String username;



	public void setWebsite(String website){
		this.website = website;
	}

	public String getWebsite(){
		return website;
	}

	public void setAddress(Address address){
		this.address = address;
	}

	public Address getAddress(){
		return address;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCompany(Company company){
		this.company = company;
	}

	public Company getCompany(){
		return company;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return
			"EmpResponse{" +
			"website = '" + website + '\'' +
			",address = '" + address + '\'' +
			",phone = '" + phone + '\'' +
			",name = '" + name + '\'' +
			",company = '" + company + '\'' +
			",id = '" + id + '\'' +
			",email = '" + email + '\'' +
			",username = '" + username + '\'' +
			"}";
		}
}