package com.study.patientHelper.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.patientHelper.model.PatientDetail;
import com.study.patientHelper.processor.PatientProcessor;

/**
 * This controller provides the endpoints to process the doctordetails
 * 
 * @author Komaljit.Singh
 */
@RestController
@RequestMapping("/patient")
public class PatientController {

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	private final PatientProcessor patientProcessor;

	public PatientController(PatientProcessor patientProcessor){
		this.patientProcessor = patientProcessor;
	}

	/**
	 * End-point to save doctor details
	 * 
	 * @param doctorDetail
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<Boolean> savePatientDetail(@RequestBody final PatientDetail patientDetail) {

		logger.info("A request for save doctor detail is in proccess",patientDetail);

		patientProcessor.savePatientDetail(patientDetail);
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}
	
	@GetMapping("/get")
	public List<PatientDetail> getPatientDetail(@RequestParam int patientId){
		
		logger.info("A request for get doctor detail is in process",patientId);
		return patientProcessor.getPatientDetail(patientId);
	}
}

