package com.example.drag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home extends Activity {

	EditText id;
	Button login,reg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_lay);
		
		id = (EditText) findViewById(R.id.l_id);
		
		login = (Button) findViewById(R.id.l_login);
		reg = (Button) findViewById(R.id.l_reg);
		
		login.setOnClickListener(new View.OnClickListener() {
			
            @Override
            public void onClick(View v) {
            	
            	DatabaseHandler db= new DatabaseHandler(Home.this);
            	try
            	{
            		String pass = db.getPass(id.getText().toString());
            		Intent i1 = new Intent(Home.this,Pass.class);
            		i1.putExtra("Pass", pass);
            		i1.putExtra("ID", id.getText().toString());
            		startActivity(i1);
            	}
            	catch(Exception ep)
            	{
            		Toast.makeText(Home.this, "Invalid User ID", Toast.LENGTH_LONG).show();
            	}
            }
        });
		
		reg.setOnClickListener(new View.OnClickListener() {
			
            @Override
            public void onClick(View v) {
            	
            	Intent i1 = new Intent(Home.this,Register.class);
            	startActivity(i1);
            }
        });
	}
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent msg) {

	     switch(keyCode) {
	     case(KeyEvent.KEYCODE_BACK):
	         
	          finishAffinity();
	          return true;    
	     }
	     return false;
	}

}
