package com.iac.hackathon;

import com.iac.hackathon.domain.Gesture;
import com.iac.hackathon.domain.Word;
import com.iac.hackathon.manager.MessageManager;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.ImageView;

public class WordDialogActivity extends Activity {

	MessageManager manager = new MessageManager();
	ImageView gestureImage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_word_dialog);
		
		init();
		
		String gestureName = getIntent().getExtras().getString("gesture");
		setTitle(gestureName);
		
		Gesture word = manager.getWordByName(gestureName);
		if(word==null){
			word = manager.getLetterByName(gestureName);
		}
		gestureImage.setImageResource(word.getImage());
		
	}

	private void init() {
		gestureImage = (ImageView) findViewById(R.id.gesture_image_dictionary);
		
	}

}
