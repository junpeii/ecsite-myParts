package com.internousdev.espresso.dto;

public class DestinationInfoDTO {

	private int id;
	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String email;
	private String telNumber;
	private String userAddress;

	//ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//ユーザーID
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	//姓
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	//名
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//姓ふりがな
	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	//名ふりがな
	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	//メアド
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//電話番号
	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	//住所
	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
}

