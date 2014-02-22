package com.iac.hackathon;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends Activity {
	
	EditText phoneNumberField;
	String phoneNumber;
	EditText messageBodyField;
	String messageBody;
	Button sendButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_message);
		
		phoneNumberField = (EditText) findViewById(R.id.phoneNumberField);
		phoneNumber = phoneNumberField.getText().toString();
		messageBodyField = (EditText) findViewById(R.id.messageBodyField);
		messageBody = messageBodyField.getText().toString();
		sendButton = (Button) findViewById(R.id.sendButton);
		
		
		sendButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(phoneNumber.trim().length() != 0){

					try {
						
						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNumber, null, messageBody, null, null);
						
						Toast.makeText(SendMessageActivity.this, "SMS Sent!",
									Toast.LENGTH_LONG).show();
					  } catch (Exception e) {
						Toast.makeText(SendMessageActivity.this,
							"SMS failed, please try again later!",
							Toast.LENGTH_LONG).show();
						e.printStackTrace();
					  }
		 
				}
			}
		});
	}

}
