package com.iac.hackathon.domain;

public class Letter extends Gesture{

	String name;
	int image;
	
	
	
	
	public Letter() {
		super();
		name="default";
		image=0;
	}

	public Letter(String name, int image) {
		super();
		this.name = name;
		this.image = image;
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

}
