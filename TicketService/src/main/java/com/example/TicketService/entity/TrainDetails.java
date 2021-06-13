package com.example.TicketService.entity;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Train Details")
public class TrainDetails {
	@Id
	private String trainNo;

	private String trainName;

	private String startStation;

	private String destStation;

	private String arrivalTime;

	private String deptTime;
	private String duration;
	private int noOfSeats;

	private TrainClassFares trainClassFares;
	

	public TrainDetails() {
		super();
	}

	public TrainDetails(String trainNo, String trainName, String startStation, String destStation, String arrivalTime,
			String deptTime, String duration, int noOfSeats, TrainClassFares trainClassFares) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.startStation = startStation;
		this.destStation = destStation;
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.duration = duration;
		this.noOfSeats = noOfSeats;
		this.trainClassFares = trainClassFares;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getDestStation() {
		return destStation;
	}

	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public TrainClassFares getTrainClassFares() {
		return trainClassFares;
	}

	public void setTrainClassFares(TrainClassFares trainClassFares) {
		this.trainClassFares = trainClassFares;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainNo=" + trainNo + ", trainName=" + trainName + ", startStation=" + startStation
				+ ", destStation=" + destStation + ", arrivalTime=" + arrivalTime + ", deptTime=" + deptTime
				+ ", duration=" + duration + ", noOfSeats=" + noOfSeats + ", trainClassFares=" + trainClassFares + "]";
	}
	
	
}