package com.example.AdminService.entity;

public class TrainClassFares
{
	private String firstClassACFare;
	private String twoTierAcFare;
	private String threeTierAcFare;
	private String sleeperFare;
	
	public TrainClassFares() {
		super();
	}
	public String getFirstClassACFare() {
		return firstClassACFare;
	}
	public void setFirstClassACFare(String firstClassACFare) {
		this.firstClassACFare = firstClassACFare;
	}
	public String getTwoTierAcFare() {
		return twoTierAcFare;
	}
	public void setTwoTierAcFare(String twoTierAcFare) {
		this.twoTierAcFare = twoTierAcFare;
	}
	public String getThreeTierAcFare() {
		return threeTierAcFare;
	}
	public void setThreeTierAcFare(String threeTierAcFare) {
		this.threeTierAcFare = threeTierAcFare;
	}
	public String getSleeperFare() {
		return sleeperFare;
	}
	public void setSleeperFare(String sleeperFare) {
		this.sleeperFare = sleeperFare;
	}
	public TrainClassFares(String firstClassACFare, String twoTierAcFare, String threeTierAcFare, String sleeperFare) {
		super();
		this.firstClassACFare = firstClassACFare;
		this.twoTierAcFare = twoTierAcFare;
		this.threeTierAcFare = threeTierAcFare;
		this.sleeperFare = sleeperFare;
	}
	@Override
	public String toString() {
		return "TrainClassFares [firstClassACFare=" + firstClassACFare + ", twoTierAcFare=" + twoTierAcFare
				+ ", threeTierAcFare=" + threeTierAcFare + ", sleeperFare=" + sleeperFare + "]";
	}
	
	
}