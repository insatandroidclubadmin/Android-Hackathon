package com.iac.hackathon;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMSFragment extends Fragment {

	EditText phoneNumberField;
	String phoneNumber;
	EditText messageBodyField;
	String messageBody;
	Button sendButton;
	
	public SendSMSFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main_send_sms,
				container, false);
		
		init(rootView);

		sendButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				phoneNumber = phoneNumberField.getText().toString();
				messageBody = messageBodyField.getText().toString();
				if (phoneNumber.trim().length() != 0) {

					try {

						SmsManager smsManager = SmsManager.getDefault();
						smsManager.sendTextMessage(phoneNumber, null,
								messageBody, null, null);

						Toast.makeText(getActivity(), "SMS Sent!",
								Toast.LENGTH_LONG).show();
					} catch (Exception e) {
						Toast.makeText(getActivity(),
								"SMS failed, please try again later!",
								Toast.LENGTH_LONG).show();
						e.printStackTrace();
					}

				}
			}
		});
		return rootView;
	}

	private void init(View rootView) {
		phoneNumberField = (EditText) rootView.findViewById(R.id.phoneNumberField);
		messageBodyField = (EditText) rootView.findViewById(R.id.messageBodyField);
		sendButton = (Button) rootView.findViewById(R.id.sendButton);
	}

}
