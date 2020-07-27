package com.study.patientHelper.model;

import java.time.ZonedDateTime;

import com.study.patientHelper.model.Address;
import com.study.patientHelper.model.Gender;

public class AppointmentDetail {
	private long appointmentId;
	private long doctorId;
	private long patientId;
	private ZonedDateTime appointmentdate;
	private int appointmentStatus;
	int status;
	
	public AppointmentDetail() {}

	public long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public ZonedDateTime getAppointmentdate() {
		return appointmentdate;
	}

	public void setAppointmentdate(ZonedDateTime appointmentdate) {
		this.appointmentdate = appointmentdate;
	}

	public int getAppointmentStatus() {
		return appointmentStatus;
	}

	public void setAppointmentStatus(int appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointmentDetail [appointmentId=" + appointmentId + ", doctorId=" + doctorId + ", patientId="
				+ patientId + ", appointmentdate=" + appointmentdate + ", appointmentStatus=" + appointmentStatus
				+ ", status=" + status + "]";
	}

	public AppointmentDetail(long appointmentId, long doctorId, long patientId, ZonedDateTime appointmentdate,
			int appointmentStatus, int status) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.appointmentdate = appointmentdate;
		this.appointmentStatus = appointmentStatus;
		this.status = status;
	}	
	
}
