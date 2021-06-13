package com.example.TicketService.services;

import java.util.List;

import com.example.TicketService.entity.UserDetails;

public interface TicketService {
	
	public List<UserDetails> getAll();
	public UserDetails getUserDetailsById(long pnrNo);
	public String addUserBookingDetails(UserDetails userDetails);
	public String deleteUserBookingDetails(long pnrNo);

}
