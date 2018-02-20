package com.example.drag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {
	
	EditText id,name,email,mob;
	Button next;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.reg);
		
		
		id = (EditText) findViewById(R.id.r_id);
		name = (EditText) findViewById(R.id.r_name);
		email = (EditText) findViewById(R.id.r_email);
		mob = (EditText) findViewById(R.id.r_mob);
		
		next = (Button) findViewById(R.id.r_nex);
		
		
		DatabaseHandler db = new DatabaseHandler(this);
		
		try
		{
			id.setText(db.getId());
		}
		catch(Exception ep)
		{
			Toast.makeText(Register.this, ep.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		
		
		next.setOnClickListener(new View.OnClickListener() {
			
            @Override
            public void onClick(View v) {
            	
            	String c = Check();
            	if(c.compareTo("true")==0)
            	{
            		Intent i1 = new Intent(Register.this,MainActivity.class);
            		i1.putExtra("Name", name.getText().toString());
            		i1.putExtra("Email", email.getText().toString());
            		i1.putExtra("ID", id.getText().toString());
            		i1.putExtra("Mob", mob.getText().toString());
            		startActivity(i1);
            	}
            	else
            	{
            		Toast.makeText(Register.this, ""+c, Toast.LENGTH_SHORT).show();
            	}
            }
        });
	}
	
	public String Check()
	{
		if(name.getText().toString().compareTo("")==0)
		{
			return "Please Enter Name";
		}
		if(email.getText().toString().compareTo("")==0)
		{
			return "Please Enter E-Mail ID";
		}
		if(mob.getText().toString().compareTo("")==0)
		{
			return "Please Enter Mobile No";
		}
		
		if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches())
		{
			return "Invalid E-Mail ID";
		}	
		
		if(mob.getText().toString().length() != 10)
		{
			return "Invalid Phone No";
		}
		return "true";
	}

}
