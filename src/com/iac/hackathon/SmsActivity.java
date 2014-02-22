package com.iac.hackathon;

import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Bundle;

public class SmsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    // Create the Keyboard
    Keyboard myKeyboard = new Keyboard(getApplicationContext(), R.xml.keybrd);

    // Lookup the KeyboardView
    KeyboardView myKeyboardView = (KeyboardView)findViewById(R.id.keyboardview);
    // Attach the keyboard to the view
   // myKeyboardView.setKeyboard(myKeyboard);
    // Do not show the preview balloons
    //myKeybrdView.setPreviewEnabled(false);
    
}
