package com.study.patientHelper.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.patientHelper.service.PatientRepositoryJDBCImpl;
import com.study.patientHelper.model.Address;
import com.study.patientHelper.model.AppointmentDetail;
import com.study.patientHelper.model.PatientDetail;

@Repository
public class PatientRepositoryJDBCImpl implements PatientRepository{
	
	private static final Logger logger = LoggerFactory.getLogger(PatientRepositoryJDBCImpl.class);
	private JdbcTemplate jdbcTemplate;

	private static final String DATE_FORMAT = "yyyy:MM:dd:HH:mm:ss";

	@Autowired
	public PatientRepositoryJDBCImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void savePatientDetail(PatientDetail patientDetail) {
		// TODO Auto-generated method stub
		// insert query to save doctor detail
		String patientInsertQuery = "INSERT INTO PATIENT (PATIENTID,NAME,PHONE_NO,EMAIL,"
				+ "DOB,PASSWORD,GENDER,STATUS,ADDRESS)"
				+ "VALUES (?,?,?,?,TO_DATE(?,'YYYY:MM:dd:HH24:MI:SS'),?,?,?,?)";
		
		com.study.patientHelper.model.Address addressDetail = patientDetail.getAddress();
		String address = addressDetail.getCity() + "," + addressDetail.getState() + "," + addressDetail.getCountry()
				+ "," + addressDetail.getPincode();
		List<Object> sqlParameters = new ArrayList<>();

		sqlParameters.add(patientDetail.getPatientId());
		sqlParameters.add(patientDetail.getPatientName());
		sqlParameters.add(patientDetail.getMobileNo());
		sqlParameters.add(patientDetail.getEmail());
		sqlParameters.add(patientDetail.getDob().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		sqlParameters.add(patientDetail.getPassword());
		sqlParameters.add(patientDetail.getGender().name());
		sqlParameters.add(patientDetail.getStatus());
		sqlParameters.add(address);

		logger.debug("Executing doctor insert query: {} with params : [{}]", patientInsertQuery,
				sqlParameters.toArray());

		jdbcTemplate.update(patientInsertQuery,sqlParameters.toArray());
	}

	@Override
	public List<PatientDetail> getPatientDetail(int patientId) {
		// TODO Auto-generated method stub
		String patientSelectQuery = "SELECT PATIENTID,NAME,PHONE_NO,EMAIL,"
				+ "DOB,PASSWORD,GENDER,STATUS,ADDRESS FROM PATIENT"
				+ " WHERE PATIENTID = ? ";
		List<Object> sqlParameters = new ArrayList<Object>();
		logger.debug("Executing doctor insert query: {} with params : [{}]", patientSelectQuery,
				sqlParameters.toArray());
		
		List<PatientDetail> patientData = jdbcTemplate.query(patientSelectQuery,new Object[]{patientId},new PatientMapper());
		return patientData;
	}
	
	public void bookAppointment(AppointmentDetail appointmentDetail) {
		String bookAppointmentQuery = "INSERT INTO APPOINTMENT (APPOINTMENTID,DOCTORID,PATIENTID,APPOINTMENT_DATE,APPOINTMENT_STATUS,STATUS)"
				+ "VALUES (?,?,?,TO_DATE(?,'YYYY:MM:dd:HH24:MI:SS'),?,?)";
		
		List<Object> sqlParameters = new ArrayList<>();
		
		sqlParameters.add(appointmentDetail.getAppointmentId());
		sqlParameters.add(appointmentDetail.getDoctorId());
		sqlParameters.add(appointmentDetail.getPatientId());
		sqlParameters.add(appointmentDetail.getAppointmentdate().format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
		sqlParameters.add(appointmentDetail.getAppointmentStatus());
		sqlParameters.add(appointmentDetail.getStatus());
		
		logger.debug("Executing book appointment  insert query: {} with params : [{}]", bookAppointmentQuery,
				sqlParameters.toArray());
		
		jdbcTemplate.update(bookAppointmentQuery,sqlParameters.toArray());
	}
}
