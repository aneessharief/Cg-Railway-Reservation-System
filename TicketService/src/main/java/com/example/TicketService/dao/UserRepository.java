package com.example.TicketService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.TicketService.entity.UserDetails;
@Repository
public interface UserRepository extends MongoRepository<UserDetails, Integer> {

}
