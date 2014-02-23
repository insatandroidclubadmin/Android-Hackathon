package com.iac.hackathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {
	private final int SPLASH_DISPLAY_LENGTH = 3000;
	Animation animation; 
	ImageView logo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		animation = AnimationUtils.loadAnimation(this, R.anim.down_to_up);
		logo = (ImageView) findViewById(R.id.splash_image);
		logo.startAnimation(animation);
		
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {

				Intent intent = new Intent(SplashActivity.this,
						MainActivity.class);
				startActivity(intent);

				SplashActivity.this.finish();

				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

			}
		}, SPLASH_DISPLAY_LENGTH);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
			}
		}, SPLASH_DISPLAY_LENGTH);

	}

	@Override
	public void onBackPressed() {
		this.finish();
		super.onBackPressed();
	}
}
