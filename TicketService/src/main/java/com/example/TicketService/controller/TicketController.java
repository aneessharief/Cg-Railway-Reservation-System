package com.example.TicketService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.TicketService.entity.TrainDetails;
import com.example.TicketService.entity.UserDetails;
import com.example.TicketService.services.TicketServiceImpl;

import io.swagger.annotations.ApiOperation;

@Component
@RestController
@RequestMapping("/user")
public class TicketController 
{
	@Autowired
	private TicketServiceImpl ticketServiceImpl;	
	
	@GetMapping("/all")
	@ApiOperation(value="Get all user details who booked their tickets")
	public List<UserDetails> getAll()
	{
		return ticketServiceImpl.getAll();
	}
	
	@GetMapping("/get/{pnrNo}")
	@ApiOperation(value="Get user details by Pnr Number")
	public UserDetails getUserDetailsById(@PathVariable long pnrNo)
	{
		return ticketServiceImpl.getUserDetailsById(pnrNo);
	}
	
	@PostMapping("/book/add")
	@ApiOperation(value="Book a ticket")
	public String addUserDetails(@RequestBody UserDetails userDetails)
	{
		RestTemplate restTemplate=new RestTemplate();
		userDetails.setId(TicketServiceImpl.getNextSequence(userDetails.SEQUENCE_NAME));
		userDetails.setPnrNo();
		userDetails.setPayment("Pending");
		int trainNo=userDetails.getTrainNo();
		int noOfAdults=userDetails.getPassengers().getAdults();
		int noOfChildren=userDetails.getPassengers().getChildren();
		int totalPassengers=noOfAdults+noOfChildren;
		restTemplate.getForObject("http://localhost:8011/admin/updateSeats/"+trainNo+"/"+totalPassengers, TrainDetails.class);
		return ticketServiceImpl.addUserBookingDetails(userDetails);	
	}
	
	@DeleteMapping("/cancel/{pnrNo}")
	@ApiOperation(value="Cancel a ticket")
	public String deleteUserDetailsById(@PathVariable long pnrNo)
	{
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getForObject("http://localhost:8014/pay/cancel/"+pnrNo, String.class);
		//System.out.println(s);
		return ticketServiceImpl.deleteUserBookingDetails(pnrNo);
	}
	
}
	
