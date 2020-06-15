package com.study.patientHelper.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.study.patientHelper.model.Address;
import com.study.patientHelper.model.Gender;
import com.study.patientHelper.model.PatientDetail;

public class PatientMapper implements RowMapper {
	public PatientDetail mapRow(ResultSet rs, int rowNum)  throws SQLException {
		PatientDetail patient = new PatientDetail();
		patient.setPatientId(rs.getInt("patientid"));
		patient.setPatientName(rs.getString("name"));
		patient.setMobileNo(rs.getString("phone_no"));
		patient.setEmail(rs.getString("email"));
		String[] address = rs.getString("address").split(",");
		Address addressObj = new Address("",address[0],address[1],Integer.parseInt(address[3]),address[2]);
		patient.setAddress(addressObj);
		LocalDateTime localDateTime = rs.getTimestamp("dob").toLocalDateTime();
		ZonedDateTime date = localDateTime.atZone(ZoneId.systemDefault());
		patient.setDob(date);
		String gender = rs.getString("gender");
		if(gender.equals("MALE"))
			patient.setGender(Gender.MALE);
		else
			patient.setGender(Gender.FEMALE);
		return patient;
	}
}
