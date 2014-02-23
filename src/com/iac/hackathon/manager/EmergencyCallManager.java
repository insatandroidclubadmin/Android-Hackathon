package com.iac.hackathon.manager;

import java.util.ArrayList;

import com.iac.hackathon.R;
import com.iac.hackathon.domain.EmergencyCall;
import com.iac.hackathon.domain.EmergencyCallCategory;

public class EmergencyCallManager {

	ArrayList<EmergencyCall> emergencyCalls;
	ArrayList<EmergencyCallCategory> categories;
	
	
	
	public EmergencyCallManager() {
		super();
		emergencyCalls = new ArrayList<EmergencyCall>();
		categories = new ArrayList<EmergencyCallCategory>();
		init();
	}



	private void init() {
		EmergencyCallCategory police = new EmergencyCallCategory("Police",R.drawable.call_police, 197);
		EmergencyCallCategory firemen = new EmergencyCallCategory("Firemen",R.drawable.call_fireman, 198);
		EmergencyCallCategory ambulance = new EmergencyCallCategory("Ambulance", R.drawable.call_doctor,190); ///change image
		
		EmergencyCall thief = new EmergencyCall("Thief", 0, police);
		EmergencyCall accident = new EmergencyCall("Accident", 0, police);
		
		EmergencyCall fire = new EmergencyCall("Fire", 0, firemen);
		
		EmergencyCall complication = new EmergencyCall("Complication", 0, ambulance);
		EmergencyCall accidentAmbulance = new EmergencyCall("Accident", 0, ambulance);
		
		categories.add(police);
		categories.add(firemen);
		categories.add(ambulance);
		
		ArrayList<EmergencyCall> policeCalls = new ArrayList<EmergencyCall>();
		policeCalls.add(thief);
		policeCalls.add(accident);
		police.setEmergencyCalls(policeCalls);
		
		ArrayList<EmergencyCall> firemenCalls = new ArrayList<EmergencyCall>();
		firemenCalls.add(fire);
		firemen.setEmergencyCalls(firemenCalls);
		
		ArrayList<EmergencyCall> ambulanceCalls = new ArrayList<EmergencyCall>();
		ambulanceCalls.add(complication);
		ambulanceCalls.add(accidentAmbulance);
		ambulance.setEmergencyCalls(ambulanceCalls);
		
		emergencyCalls.add(thief);
		emergencyCalls.add(accident);
		emergencyCalls.add(fire);
		emergencyCalls.add(complication);
		emergencyCalls.add(accidentAmbulance);
		
		
		
	}

	public ArrayList<EmergencyCall> getEmergencyCalls() {
		return emergencyCalls;
	}



	public ArrayList<EmergencyCallCategory> getCategories() {
		return categories;
	}

	public EmergencyCall getEmergencyCallByName(String name) {
		for (EmergencyCall call : getEmergencyCalls()) {
			if(name.equals(call.getName())){
				return call;
			}
		}
		return null;  //exception
	}

	public EmergencyCallCategory getEmergencyCallCategoryByName(String name) {
		for (EmergencyCallCategory category : getCategories()) {
			if(name.equals(category.getName())){
				return category;
			}
		}
		return null;  //exception
	}

}
