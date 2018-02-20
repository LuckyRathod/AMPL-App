package com.example.drag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;


public class Name extends Activity {

	TextView t1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.name_lay);
		t1 = (TextView) findViewById(R.id.n_name);
		
		Intent i1 = getIntent();
		String ID = i1.getStringExtra("ID");
		
		DatabaseHandler db =  new DatabaseHandler(Name.this);
		
		t1.setText("Welcome "+db.getName(ID));
	}
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent msg) {

	     switch(keyCode) {
	     case(KeyEvent.KEYCODE_BACK):
	          Intent a1_intent = new Intent(this, Home.class);
	          startActivity(a1_intent);
	          finish();
	          return true;    
	     }
	     return false;
	}
}
