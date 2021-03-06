package com.tth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="population")  
public class User {
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * public User(String name, String city, double population) { // TODO
	 * Auto-generated constructor stub super(); this.name = name; this.city = city;
	 * this.population = population; }
	 */
	
	public User(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	String city;
	long population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPopulation() {
		return population;
	}
	public User setPopulation(long population) {
		this.population = population;
		return null;
	}
	

	@Override
	public String toString() {
		return "Population [id=" + id + ", name=" + name + ", city=" + city + ", population=" + population + "]";
	}

}
