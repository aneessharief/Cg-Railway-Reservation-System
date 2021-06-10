package com.example.UserService.service;

import java.util.List;

import com.example.UserService.entity.TrainDetails;

public interface UserService {
	
	public List<TrainDetails> getAllDetails();
	public String pnrStatus(long pnrNo);
	public TrainDetails getDetailsByTrainNo(String trainNo);
	public List<TrainDetails> getTrainDetailsByStartStation(String startStation,String destStation);
}
