package com.example.TicketService.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "UserDetails")
public class UserDetails {
	
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";

	@Id
	private int id;

	private long pnrNo;

	private String name;

	private int age;

	private String sex;

	private String address;

	private int trainNo;

	private String trainName;

	private String startStation;

	private String destStation;

	private String classType;

	private Passengers passengers;

	private String payment;

	public UserDetails() {
		super();
	}

	public UserDetails(String name, int age, String sex, String address, int trainNo, String trainName,
			String startStation, String destStation, String classType, Passengers passengers) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.startStation = startStation;
		this.destStation = destStation;
		this.classType = classType;
		this.passengers = passengers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo() {
		this.pnrNo = pnrNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
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

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public Passengers getPassengers() {
		return passengers;
	}

	public void setPassengers(Passengers passengers) {
		this.passengers = passengers;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", pnrNo=" + pnrNo + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + ", trainNo=" + trainNo + ", trainName=" + trainName + ", startStation="
				+ startStation + ", destStation=" + destStation + ", classType=" + classType + ", passengers="
				+ passengers + ", payment=" + payment + "]";
	}
}