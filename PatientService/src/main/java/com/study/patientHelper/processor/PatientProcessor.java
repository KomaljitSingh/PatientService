package com.study.patientHelper.processor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.patientHelper.controller.PatientController;
import com.study.patientHelper.model.PatientDetail;
import com.study.patientHelper.service.PatientRepository;



@Service
public class PatientProcessor {
private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientRepository patientRepository;

	public PatientProcessor(PatientRepository patientRepository) {
		
		this.patientRepository = patientRepository;
	}
	
	public void savePatientDetail(PatientDetail patientDetail){
		
		logger.info("save doctor details is called with request as: {} ",patientDetail);
		
		patientRepository.savePatientDetail(patientDetail);
	}
	
	public List<PatientDetail> getPatientDetail(int patientId){
		
		logger.info("save doctor details is called with request as: "+patientId);
		
		return (List<PatientDetail>) patientRepository.getPatientDetail(patientId);
	}
}
