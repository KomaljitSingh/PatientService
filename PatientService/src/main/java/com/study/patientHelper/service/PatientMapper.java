package com.study.patientHelper.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.study.patientHelper.model.PatientDetail;

public class PatientMapper implements RowMapper {
	public PatientDetail mapRow(ResultSet rs, int rowNum)  throws SQLException {
		PatientDetail patient = new PatientDetail();
		patient.setPatientId(rs.getInt("patientid"));
		patient.setPatientName(rs.getString("name"));
		patient.setMobileNo(rs.getString("phone_no"));
		return patient;
	}
}
