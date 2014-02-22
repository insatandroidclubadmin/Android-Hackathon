package com.iac.hackathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class EmergencyCallFragment extends Fragment {

	public EmergencyCallFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main_emergency_call,
				container, false);
//		TextView dummyTextView = (TextView) rootView.findViewById(R.id.section_label);
		
		
		return rootView;
	}
}
