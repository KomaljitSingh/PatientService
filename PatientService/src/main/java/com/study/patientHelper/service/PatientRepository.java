package com.study.patientHelper.service;

import java.util.List;

import com.study.patientHelper.model.AppointmentDetail;
import com.study.patientHelper.model.PatientDetail;

public interface PatientRepository {
	public void savePatientDetail(PatientDetail patientDetail);
	
	public List<PatientDetail> getPatientDetail(int patientId);
	
	public void bookAppointment(AppointmentDetail appointmentDetail);
}
