package com.iac.hackathon.domain;

import java.util.ArrayList;

public class EmergencyCallCategory {

	String name;
	int image;
	int number;
	ArrayList<EmergencyCall> emergencyCalls;
	
	
	
	public EmergencyCallCategory() {
		super();
		name="default";
		image = 0;
		number = 0;
		emergencyCalls = new ArrayList<EmergencyCall>();
	}

	public EmergencyCallCategory(String name, int image, int number) {
		super();
		this.name = name;
		this.image = image;
		this.number = number;
		emergencyCalls = new ArrayList<EmergencyCall>();
	}

	public EmergencyCallCategory(String name,int image, int number,
			ArrayList<EmergencyCall> emergencyCalls) {
		super();
		this.name = name;
		this.image = image;
		this.number = number;
		this.emergencyCalls = emergencyCalls;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public ArrayList<EmergencyCall> getEmergencyCalls() {
		return emergencyCalls;
	}

	public void setEmergencyCalls(ArrayList<EmergencyCall> emergencyCalls) {
		this.emergencyCalls = emergencyCalls;
	}

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public static void main(String[] args) {
		EmergencyCallCategory cat = new EmergencyCallCategory();
		System.out.println(cat.getName());

	}

}
