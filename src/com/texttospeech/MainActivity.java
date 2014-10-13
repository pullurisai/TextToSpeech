package com.texttospeech;

import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
//import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;

public class MainActivity extends Activity {

	EditText etData;
	TextToSpeech speech;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_layout);
		etData = (EditText) findViewById(R.id.etData);
		speech = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
			

			@Override
			public void onInit(int status) {
				if(status != TextToSpeech.ERROR){
				speech.setLanguage(Locale.UK);
			}
		}
		});
	}
	public void readIt(View view) {
		Toast toast = Toast.makeText(getApplicationContext(), "Speak It", Toast.LENGTH_SHORT);
		toast.show();
		speech.speak(etData.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
	}
}
