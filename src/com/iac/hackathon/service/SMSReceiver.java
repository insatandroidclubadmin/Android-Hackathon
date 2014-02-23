package com.iac.hackathon.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.iac.hackathon.ReadSMSActivity;

public class SMSReceiver extends BroadcastReceiver {
	private final String ACTION_RECEIVE_SMS = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals(ACTION_RECEIVE_SMS)) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				Object[] pdus = (Object[]) bundle.get("pdus");

				final SmsMessage[] messages = new SmsMessage[pdus.length];
				for (int i = 0; i < pdus.length; i++) {
					messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
				}
				if (messages.length > -1) {
					final String messageBody = messages[0].getMessageBody();
					final String phoneNumber = messages[0]
							.getDisplayOriginatingAddress();
					
					Intent intentRead = new Intent(context, ReadSMSActivity.class);
					Bundle bundleRead = new Bundle();
					bundleRead.putString("number", phoneNumber);
					bundleRead.putString("message", messageBody);
					intentRead.putExtras(bundleRead);
					intentRead.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(intentRead);
					
				}
			}
		}

	}
}