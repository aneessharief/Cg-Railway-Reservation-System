package com.example.AdminService.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.AdminService.entity.TrainDetails;

public interface AdminService {
	
	public List<TrainDetails> getAllDetails();
	public TrainDetails getDetailsByTrainNo(String trainNo);
	public void addTrainDetails(TrainDetails trainDetails);
	public TrainDetails updateTrainDetails(String trainNo,TrainDetails trainDetails);
	public ResponseEntity<TrainDetails> deleteTrainDetails(String trainNo);
	
	

}
