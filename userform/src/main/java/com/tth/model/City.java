package com.tth.model;

public class City {
	
	
	public City() {
		// TODO Auto-generated constructor stub
	}
	public City(String name, double latitude, double longitude, String country, long population, Boolean is_capital) {
		super();
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.country = country;
		this.population = population;
		this.is_capital = is_capital;
	}
	String name;
	double latitude;
	double longitude;
	String country;
	long population;
	Boolean is_capital;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getPopulation() {
		return population;
	}
	public void setPopulation(long population) {
		this.population = population;
	}
	public Boolean getIs_capital() {
		return is_capital;
	}
	public void setIs_capital(Boolean is_capital) {
		this.is_capital = is_capital;
	}
	
}
