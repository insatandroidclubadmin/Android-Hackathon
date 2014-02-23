package com.iac.hackathon;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.iac.hackathon.domain.EmergencyCall;
import com.iac.hackathon.domain.EmergencyCallCategory;
import com.iac.hackathon.manager.EmergencyCallManager;
import com.iac.hackathon.utils.MyExpandableAdapter;

public class EmergencyCallFragment extends Fragment implements OnChildClickListener{
	
	private ArrayList<String> parentItems;
	private ArrayList<Object> childItems;
	EmergencyCallManager manager = new EmergencyCallManager();

	public EmergencyCallFragment() {
	}

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		parentItems = new ArrayList<String>();
		 childItems = new ArrayList<Object>();
		View rootView = inflater.inflate(R.layout.fragment_main_emergency_call,
				container, false);
		
		ExpandableListView expandableList = (ExpandableListView) rootView.findViewById(R.id.list);

		expandableList.setDividerHeight(2);
		expandableList.setGroupIndicator(null);
		expandableList.setClickable(true);

		setGroupParents();
		setChildData();

		MyExpandableAdapter adapter = new MyExpandableAdapter(parentItems, childItems);

		adapter.setInflater( (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE), getActivity());
		expandableList.setAdapter(adapter);
		expandableList.setOnChildClickListener((OnChildClickListener) this);
		
		
		return rootView;
	}
	
	public void setGroupParents() {
		for (EmergencyCallCategory category : manager.getCategories()) {
			parentItems.add(category.getName());
		}
	}

	public void setChildData() {

		ArrayList<String> child;
		
		for (EmergencyCallCategory category : manager.getCategories()) {
			child = new ArrayList<String>();
			for (EmergencyCall emergencyCall : category.getEmergencyCalls()) {
				child.add(emergencyCall.getName());
			}
			childItems.add(child);
		}

	}

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		// TODO Auto-generated method stub
		return false;
	}
}