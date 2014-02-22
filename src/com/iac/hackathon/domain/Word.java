package com.iac.hackathon.domain;

public class Word {

	String name;
	int image;
	
	

	public Word() {
		super();
		name="default";
		image = 0;
	}

	public Word(String name, int image) {
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
