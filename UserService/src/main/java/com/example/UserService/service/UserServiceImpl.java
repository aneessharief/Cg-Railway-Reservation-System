package com.example.UserService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserService.dao.AdminRepository;
import com.example.UserService.dao.UserPaymentRepository;
import com.example.UserService.entity.PaymentDetails;
import com.example.UserService.entity.TrainDetails;

@Service
public class UserServiceImpl implements UserService {
	

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private UserPaymentRepository userPayRepo;

	public List<TrainDetails> getAllDetails() {
		List<TrainDetails> trainDetails=new ArrayList<TrainDetails>();
		adminRepo.findAll().forEach(trainDetails1 -> trainDetails.add(trainDetails1));
		return trainDetails;
	}

	public String pnrStatus(long pnrNo) {
		Random rand = new Random();
		List<String> status=new ArrayList<String>();
		status.add("Confirm");
		status.add("Waiting list");
		List<PaymentDetails> paymentList=userPayRepo.findAll();
		for(PaymentDetails det:paymentList) {
			if(det.getPnrNo()==pnrNo) {
				return status.get(rand.nextInt(status.size()));
			}
		}
		return "Ticket is not booked with PNR Number "+pnrNo;
	}

	@Override
	public TrainDetails getDetailsByTrainNo(String trainNo) {
		return adminRepo.findById(trainNo)
				.orElseThrow();
			}

	@Override
	public List<TrainDetails> getTrainDetailsByStartStation(String startStation, String destStation) {
		List<TrainDetails> detList=adminRepo.findAll();
		List<TrainDetails> req=new ArrayList<TrainDetails>();
		for(TrainDetails tr:detList)
		{
			String stat=tr.getStartStation();
			String dest=tr.getDestStation();
			if(stat.equals(startStation) && dest.equals(destStation))
			{
				req.add(tr);
			}
		}
		return req;
	}

	

}
