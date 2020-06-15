package com.study.patientHelper.model;

import java.time.ZonedDateTime;

import com.study.patientHelper.model.Address;
import com.study.patientHelper.model.Gender;

public class PatientDetail {
	private long patientId;
	private String patientName;
	private String mobileNo;
	private String email;
	private ZonedDateTime dob;
	private String password;
	private Gender gender;
	private int status;
	private Address address;
	
	public PatientDetail() {}
	
	public PatientDetail(long patientId, String patientName, String mobileNo, String email, ZonedDateTime dob,
			String department, String qualification, String password, Gender gender, int status, Address address,
			String specialist, int yearOfExperience) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.dob = dob;
		this.password = password;
		this.gender = gender;
		this.status = status;
		this.address = address;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ZonedDateTime getDob() {
		return dob;
	}

	public void setDob(ZonedDateTime dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PatientDetail [patientId=" + patientId + ", patientName=" + patientName + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", dob=" + dob + ", password=" + password + ", gender=" + gender + ", status="
				+ status + ", address=" + address + "]";
	}

	
}
