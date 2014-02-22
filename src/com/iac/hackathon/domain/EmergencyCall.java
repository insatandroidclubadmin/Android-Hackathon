package com.iac.hackathon.domain;

public class EmergencyCall {

	String name;
	int image;
	EmergencyCallCategory category;
	
	
	
	
	public EmergencyCall() {
		super();
		name="default cat";
		image = 0;
		category = new EmergencyCallCategory();
	}

	public EmergencyCall(String name, int image, EmergencyCallCategory category) {
		super();
		this.name = name;
		this.image = image;
		this.category = category;
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

	public EmergencyCallCategory getCategory() {
		return category;
	}

	public void setCategory(EmergencyCallCategory category) {
		this.category = category;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
