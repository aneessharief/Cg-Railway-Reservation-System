package com.example.PaymentService.service;

import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PaymentService.dao.UserPaymentRepository;
import com.example.PaymentService.dao.UserRepository;
import com.example.PaymentService.entity.PaymentDetails;
import com.example.PaymentService.entity.UserDetails;
import com.google.common.collect.Lists;

import it.ozimov.springboot.mail.model.Email;
import it.ozimov.springboot.mail.model.defaultimpl.DefaultEmail;
import it.ozimov.springboot.mail.service.EmailService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	int id;

	@Autowired
	public EmailService emailService;
	
	@Autowired
	UserPaymentRepository userPayRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<PaymentDetails> getAll() {
		List<PaymentDetails> payDetails=userPayRepo.findAll();
		return payDetails;
	}

	@Override
	public String proceedToPay(PaymentDetails payment)
	{
		long pnrNo=payment.getPnrNo();
		List<UserDetails> det=userRepo.findAll();
		 for(UserDetails x:det) {
				if(x.getPnrNo()==pnrNo) {
					id=x.getId();
				}	
		}
		userRepo.findById(id)
					.orElseThrow();
		userPayRepo.save(payment); 
		return ("Your payment for PNR Number "+payment.getPnrNo()+" is Successful...!!!");
		
	}
	
	//to update payment field in user details after successful payment
	 public void updateUserPaymentDetails(long pnrNo)
	 {
		  List<UserDetails> details=userRepo.findAll();
		  for(UserDetails x:details) {
			  //System.out.println(x);
				if(x.getPnrNo()==pnrNo) {
					x.setPayment("Successful");
					userRepo.save(x);
				}
		  }
	  }
	 
	@Override
		public String deletePayment(long pnrNo) {
			userPayRepo.deleteById(pnrNo);
			return "You payment for "+pnrNo+ " will be credited to your account within 7 days..";
		}
	
	

}
