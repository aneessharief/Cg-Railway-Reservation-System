package com.example.AdminService.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.AdminService.entity.TrainDetails;

public interface AdminRepository extends MongoRepository<TrainDetails, String> {

}
