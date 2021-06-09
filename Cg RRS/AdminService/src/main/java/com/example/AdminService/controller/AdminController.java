package com.example.AdminService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdminService.entity.TrainDetails;
import com.example.AdminService.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;

	@GetMapping("/all")
	public List<TrainDetails> getAllDetails() {
		return adminServiceImpl.getAllDetails();
	}
	@GetMapping("/{trainNo}")
	
	public TrainDetails getDetailsByTrainNo(@PathVariable String trainNo) 
	{
		return adminServiceImpl.getDetailsByTrainNo(trainNo);
	}

	@PostMapping("/add")
	public String addTrainDetails(@RequestBody TrainDetails trainDetails) {
		adminServiceImpl.addTrainDetails(trainDetails);
		return ("Added train details with train number - " + trainDetails.getTrainNo() + " successfully..!!");
	}
	
	@PutMapping("/update/{trainNo}")
	public TrainDetails updateTrainDetails(@PathVariable String trainNo,@RequestBody TrainDetails trainDetails)
	{
		return adminServiceImpl.updateTrainDetails(trainNo,trainDetails);
	}
	
	@DeleteMapping("/delete/{trainNo}")
	public ResponseEntity<TrainDetails> deleteTrainDetails(@PathVariable String trainNo)
	{
		return adminServiceImpl.deleteTrainDetails(trainNo);
	}
	
	//update the no of seats based on the no of passengers that booked ticket
		@GetMapping("/updateSeats/{trainNo}/{noOfPassengers}")
		public void updateSeats(@PathVariable String trainNo,@PathVariable int noOfPassengers)
		{
			TrainDetails currentTrain=adminServiceImpl.getDetailsByTrainNo(trainNo);
			int initialSeats=currentTrain.getNoOfSeats();
			int finalSeats=initialSeats-noOfPassengers;
			currentTrain.setNoOfSeats(finalSeats);
			adminServiceImpl.updateTrainDetails(trainNo, currentTrain);
		}

}
