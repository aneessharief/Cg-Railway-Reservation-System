package com.example.UserService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.entity.TrainDetails;
import com.example.UserService.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/alltrains")
	public List<TrainDetails> getAllDetails()
	{
		return userServiceImpl.getAllDetails();
	}
	@GetMapping("/status/{pnrNo}")
	public String getStatus(@PathVariable long pnrNo)
	{
		return userServiceImpl.pnrStatus(pnrNo);
	}
	@GetMapping("/trainNo/{trainNo}")
	public TrainDetails getDetailsByTrainNo(@PathVariable String trainNo) 
	{
		return userServiceImpl.getDetailsByTrainNo(trainNo);
	}
	@GetMapping("/{startStation}/{destStation}")
	public List<TrainDetails> getTrainDetailsByStartStation(@PathVariable String startStation,@PathVariable String destStation)
	{
		return userServiceImpl.getTrainDetailsByStartStation(startStation,destStation);
	}
}
