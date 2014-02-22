package com.iac.hackathon;

import java.util.ArrayList;

import com.iac.hackathon.domain.Gesture;
import com.iac.hackathon.manager.MessageManager;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;

public class ReadSMSActivity extends Activity {

	MessageManager manager = new MessageManager();
	ArrayList<Gesture> gestures;
	int currentGesturePosition=0;
	
	Handler handler = new Handler();
	
	TextView phoneView, messageView, gestureNameView;
	ImageView gestureImage ; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_sms);
		// Show the Up button in the action bar.
		setupActionBar();
		
		Bundle bundle = getIntent().getExtras();
		String number = bundle.getString("number");
		String message = bundle.getString("message");
		
		findViewsById();
		
		
		gestures= manager.getGestures(message);
		messageView.setText(message);
		phoneView.setText("From " + number);
		updateGestureImage();
	}

	private void findViewsById() {
		phoneView = (TextView)findViewById(R.id.phone_number);
		messageView = (TextView)findViewById(R.id.message);
		gestureNameView = (TextView)findViewById(R.id.gesture_name);
		gestureImage = (ImageView)findViewById(R.id.gesture_image);
	}

	private void updateGestureImage() {
		if(currentGesturePosition<gestures.size()){
			Gesture currentGesture = gestures.get(currentGesturePosition);
			currentGesturePosition++;
			gestureImage.setImageResource(currentGesture.getImage());
			gestureNameView.setText(currentGesture.getName());
			handler.postDelayed(updateRunnable, 1000);
		}
	}
	Runnable updateRunnable = new Runnable() {
		@Override
		public void run() {
			updateGestureImage();
		}
	};
	
	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
