package com.iac.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	private final int SPLASH_DISPLAY_LENGTH = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		/*
		 * ImageView logo = (ImageView) findViewById(R.drawable.logo); Animation
		 * fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
		 * logo.startAnimation(fadeInAnimation);
		 */
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				SplashActivity.this.finish();
				Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(mainIntent);
			}
		}, SPLASH_DISPLAY_LENGTH);
	}
}
