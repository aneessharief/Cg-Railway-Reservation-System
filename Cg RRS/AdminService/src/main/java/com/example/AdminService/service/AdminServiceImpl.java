package com.example.AdminService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.AdminService.dao.AdminRepository;
import com.example.AdminService.entity.TrainDetails;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Override
	public List<TrainDetails> getAllDetails() {
		List<TrainDetails> trainDetails = new ArrayList<TrainDetails>();
		adminRepository.findAll().forEach(trainDetails1 -> trainDetails.add(trainDetails1));
		return trainDetails;
	}
	@Override
	public TrainDetails getDetailsByTrainNo(String trainNo) {
		// TODO Auto-generated method stub
		 return adminRepository.findById(trainNo)
				.orElseThrow();
	}

	@Override
	public void addTrainDetails(TrainDetails trainDetails) {
		adminRepository.save(trainDetails);

	}
	
   public TrainDetails updateTrainDetails(String trainNo,TrainDetails trainDetails)
	{
		TrainDetails existingDetails=adminRepository.findById(trainNo)
				.orElseThrow();
		existingDetails.setTrainNo(trainDetails.getTrainNo());
		existingDetails.setTrainName(trainDetails.getTrainName());
		existingDetails.setStartStation(trainDetails.getStartStation());
		existingDetails.setDestStation(trainDetails.getDestStation());
		existingDetails.setArrivalTime(trainDetails.getArrivalTime());
		existingDetails.setDeptTime(trainDetails.getDeptTime());
		existingDetails.setDuration(trainDetails.getDuration());
		existingDetails.setNoOfSeats(trainDetails.getNoOfSeats());
		existingDetails.setTrainClassFares(trainDetails.getTrainClassFares());
		return adminRepository.save(existingDetails);
	}
   
   public ResponseEntity<TrainDetails> deleteTrainDetails(String trainNo)
	{
		TrainDetails existingDetails=adminRepository.findById(trainNo)
				.orElseThrow();
		adminRepository.delete(existingDetails);
		//adminRepo.deleteById(trainNo);
		return ResponseEntity.ok().build();

	}


}
