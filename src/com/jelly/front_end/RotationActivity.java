package com.jelly.front_end;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RotationActivity extends Activity {

	private GameView gameView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		gameView = new GameView(this);
		setContentView(gameView);
		//setContentView(R.layout.activity_rotation);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rotation, menu);
		return true;
	}

}
