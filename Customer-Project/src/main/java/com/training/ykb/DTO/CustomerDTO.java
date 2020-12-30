package com.training.ykb.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.training.ykb.validation.UniqueUserName;

public class CustomerDTO {

	@JsonIgnore
	private Long custId;
	@NotEmpty(message = "Kullanıcı Adı Boş Olamaz")
	@UniqueUserName
	private String userName;
	@NotEmpty(message = "Parola Boş Olamaz")
	@Size(min = 6, max = 20, message = "Parola min 6 max 20 karakter olmalı")
	private String password;
	@Email
	private String email;
	private String gender;
	@Min(value = 18, message = "18 Yaşından küçük olamaz")
	private int age;

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
