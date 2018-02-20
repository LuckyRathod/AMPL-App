package com.example.drag;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Pass extends Activity{
	
	ImageView a,b,c,d,e,f,g,h,i;
	TextView no,fin;
	int width,height;
	int cou1=0,cou2=0,cou3=0,cou4=0,cou5=0,cou6=0,cou7=0,cou8=0,cou9=0;
	String cur="0";
	Button sub;
	Boolean two = true;
	String Pass="",ID="";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pass);
		
		final RelativeLayout lay = (RelativeLayout) findViewById(R.id.a_mylay);
        final TextView xCoord = (TextView) findViewById(R.id.a_textView1);
        final TextView yCoord = (TextView) findViewById(R.id.a_textView2);
        no = (TextView) findViewById(R.id.a_no);
        
        fin = (TextView) findViewById(R.id.a_fin);
        
        sub = (Button) findViewById(R.id.a_sub);
        sub.setAlpha(0);
        
        a = (ImageView) findViewById(R.id.a_imageView1);
        b = (ImageView) findViewById(R.id.a_imageView2);
        c = (ImageView) findViewById(R.id.a_imageView3);
        d = (ImageView) findViewById(R.id.a_imageView4);
        e = (ImageView) findViewById(R.id.a_imageView5);
        f = (ImageView) findViewById(R.id.a_imageView6);
        g = (ImageView) findViewById(R.id.a_imageView7);
        h = (ImageView) findViewById(R.id.a_imageView8);
        i = (ImageView) findViewById(R.id.a_imageView9);
        
        fin.setText("");
        no.setText("");
        
        Intent i1 = getIntent();
        Pass = i1.getStringExtra("Pass");
        ID = i1.getStringExtra("ID");
        final TableLayout tab = (TableLayout) findViewById(R.id.tablay);
        
        ViewTreeObserver observer = tab.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
			@Override
            public void onGlobalLayout() {
            	width = lay.getWidth();
                height = lay.getHeight();
                xCoord.setText(""+width);
                yCoord.setText(""+height);
                tab.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        
        lay.setOnTouchListener(new View.OnTouchListener() {
        	
            public boolean onTouch(View v, MotionEvent event) {
                final int action = event.getAction();
                int x = (int) event.getX();
                int y = (int) event.getY();
                
                int xa1 = 0;
                int ya1 = 0;
                
                int xa2 = ((width * 33)/100);
                int ya2 = ((height * 33)/100);
                
                int xb1 = xa2+10;
                int yb1 = ya1;

                int xb2 = xa2+xa2+10;
                int yb2 = ya2;
                
                int xc1 = xb2+10;
                int yc1 = ya1;
                
                int xc2 = xa2+xb2+10;
                int yc2 = ya2;
                
                int xd1 = 0;
                int yd1 = ya2+10;
                
                int xd2 = xa2;
                int yd2 = ya2+ya2;
                
                int xe1 = xa2+10;
                int ye1 = yd1;

                int xe2 = xa2+xa2+10;
                int ye2 = yd2;
                
                int xf1 = xb2+10;
                int yf1 = yd1;
                
                int xf2 = xa2+xb2+10;
                int yf2 = yd2;
                
                int xg1 = 0;
                int yg1 = ya2+ya2+10;
                
                int xg2 = xa2;
                int yg2 = ya2+ya2+ya2;
                
                int xh1 = xa2+10;
                int yh1 = yg1;

                int xh2 = xa2+xa2+10;
                int yh2 = yg2;
                
                int xi1 = xb2+10;
                int yi1 = yg1;
                
                int xi2 = xa2+xb2+10;
                int yi2 = yg2;
                
                
                
                switch (action & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN: {
                        xCoord.setText(String.valueOf((int) event.getX()));
                        yCoord.setText(String.valueOf((int) event.getY()));
                        break;
                    }

                    case MotionEvent.ACTION_MOVE:{
                    	
                    	if(two)
                    	{
                        xCoord.setText(String.valueOf((int) event.getX()));
                        yCoord.setText(String.valueOf((int) event.getY()));
                        if(x > xa1 && x <= xa2 && y > ya1 && y <= ya2)
                        {
                        	if(cur != "1")
                        	{
                        		cou1+=1;
                        		
                        		if(cou1 < 6)
                        		{
                        		if(cou1==1)
                        		{
                        			a.setImageResource(R.drawable.green);
                        		}
                        		else if(cou1==2)
                        		{
                        			a.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou1==3)
                        		{
                        			a.setImageResource(R.drawable.red);
                        		}
                        		else if(cou1==4)
                        		{
                        			a.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou1==5)
                        		{
                        			a.setImageResource(R.drawable.pink);
                        		}
                        		cur = "1";
                        		no.setText("1");
                        		fin.append("1,");
                        		}
                        	}
                        	else
                        	{
                        		//Toast.makeText(MainActivity.this, "1 If", Toast.LENGTH_SHORT).show();
                        	}
                        }
                        if(x > xb1 && x <= xb2 && y > yb1 && y <= yb2)
                        {
                        	if(cur != "2")
                        	{
                        		cou2+=1;
                        		
                        		if(cou2 < 6)
                        		{
                        		if(cou2==1)
                        		{
                        			b.setImageResource(R.drawable.green);
                        		}
                        		else if(cou2==2)
                        		{
                        			b.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou2==3)
                        		{
                        			b.setImageResource(R.drawable.red);
                        		}
                        		else if(cou2==4)
                        		{
                        			b.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou2==5)
                        		{
                        			b.setImageResource(R.drawable.pink);
                        		}
                        		cur = "2";
                        		no.setText("2");
                        		fin.append("2,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        if(x > xc1 && x <= xc2 && y > yc1 && y <= yc2)
                        {
                        	if(cur != "3")
                        	{
                        		cou3+=1;
                        		
                        		if(cou3 < 6)
                        		{
                        		if(cou3==1)
                        		{
                        			c.setImageResource(R.drawable.green);
                        		}
                        		else if(cou3==2)
                        		{
                        			c.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou3==3)
                        		{
                        			c.setImageResource(R.drawable.red);
                        		}
                        		else if(cou3==4)
                        		{
                        			c.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou3==5)
                        		{
                        			c.setImageResource(R.drawable.pink);
                        		}
                        		cur = "3";
                        		no.setText("3");
                        		fin.append("3,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        
                        if(x > xd1 && x <= xd2 && y > yd1 && y <= yd2)
                        {
                        	if(cur != "4")
                        	{
                        		cou4+=1;
                        		
                        		if(cou4 < 6)
                        		{
                        		if(cou4==1)
                        		{
                        			d.setImageResource(R.drawable.green);
                        		}
                        		else if(cou4==2)
                        		{
                        			d.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou4==3)
                        		{
                        			d.setImageResource(R.drawable.red);
                        		}
                        		else if(cou4==4)
                        		{
                        			d.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou4==5)
                        		{
                        			d.setImageResource(R.drawable.pink);
                        		}
                        		cur = "4";
                        		no.setText("4");
                        		fin.append("4,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        
                        if(x > xe1 && x <= xe2 && y > ye1 && y <= ye2)
                        {
                        	if(cur != "5")
                        	{
                        		cou5+=1;
                        		
                        		if(cou5 < 6)
                        		{
                        		if(cou5==1)
                        		{
                        			e.setImageResource(R.drawable.green);
                        		}
                        		else if(cou5==2)
                        		{
                        			e.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou5==3)
                        		{
                        			e.setImageResource(R.drawable.red);
                        		}
                        		else if(cou5==4)
                        		{
                        			e.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou5==5)
                        		{
                        			e.setImageResource(R.drawable.pink);
                        		}
                        		cur = "5";
                        		no.setText("5");
                        		fin.append("5,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        
                        if(x > xf1 && x <= xf2 && y > yf1 && y <= yf2)
                        {
                        	if(cur != "6")
                        	{
                        		cou6+=1;
                        		
                        		if(cou6 < 6)
                        		{
                        		if(cou6==1)
                        		{
                        			f.setImageResource(R.drawable.green);
                        		}
                        		else if(cou6==2)
                        		{
                        			f.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou6==3)
                        		{
                        			f.setImageResource(R.drawable.red);
                        		}
                        		else if(cou6==4)
                        		{
                        			f.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou6==5)
                        		{
                        			f.setImageResource(R.drawable.pink);
                        		}
                        		cur = "6";
                        		no.setText("6");
                        		fin.append("6,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        
                        if(x > xg1 && x <= xg2 && y > yg1 && y <= yg2)
                        {
                        	if(cur != "7")
                        	{
                        		cou7+=1;
                        		
                        		if(cou7 < 6)
                        		{
                        		if(cou7==1)
                        		{
                        			g.setImageResource(R.drawable.green);
                        		}
                        		else if(cou7==2)
                        		{
                        			g.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou7==3)
                        		{
                        			g.setImageResource(R.drawable.red);
                        		}
                        		else if(cou7==4)
                        		{
                        			g.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou7==5)
                        		{
                        			g.setImageResource(R.drawable.pink);
                        		}
                        		cur = "7";
                        		no.setText("7");
                        		fin.append("7,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        
                        if(x > xh1 && x <= xh2 && y > yh1 && y <= yh2)
                        {
                        	if(cur != "8")
                        	{
                        		cou8+=1;
                        		
                        		if(cou8 < 6)
                        		{
                        		if(cou8==1)
                        		{
                        			h.setImageResource(R.drawable.green);
                        		}
                        		else if(cou8==2)
                        		{
                        			h.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou8==3)
                        		{
                        			h.setImageResource(R.drawable.red);
                        		}
                        		else if(cou8==4)
                        		{
                        			h.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou8==5)
                        		{
                        			h.setImageResource(R.drawable.pink);
                        		}
                        		cur = "8";
                        		no.setText("8");
                        		fin.append("8,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                        
                        if(x > xi1 && x <= xi2 && y > yi1 && y <= yi2)
                        {
                        	if(cur != "9")
                        	{
                        		cou9+=1;
                        		
                        		if(cou9 < 6)
                        		{
                        		if(cou9==1)
                        		{
                        			i.setImageResource(R.drawable.green);
                        		}
                        		else if(cou9==2)
                        		{
                        			i.setImageResource(R.drawable.blue);
                        		}	
                        		else if(cou9==3)
                        		{
                        			i.setImageResource(R.drawable.red);
                        		}
                        		else if(cou9==4)
                        		{
                        			i.setImageResource(R.drawable.yellow);
                        		}
                        		else if(cou9==5)
                        		{
                        			i.setImageResource(R.drawable.pink);
                        		}
                        		cur = "9";
                        		no.setText("9");
                        		fin.append("9,");
                        		}
                        	}
                        	else
                        	{
                        		
                        	}
                        }
                    	}
                        break;
                    }
                    
                    case MotionEvent.ACTION_UP: 
                    {
                    	//no.setText("Up");
                    	
                    	String[] fi = fin.getText().toString().split(",");
                    	
                    		//Intent intent = new Intent(Intent.ACTION_SEND);
                            //intent.setType("text/plain");
                            //intent.putExtra(android.content.Intent.EXTRA_TEXT, "Standing");
                            //startActivity(intent);
                    	if(fi.length >= 4)
                    	{
                    		if(fin.getText().toString().compareTo(Pass)==0)
                    		{
                    			Toast.makeText(Pass.this, "Password Matched", Toast.LENGTH_SHORT).show();
                    			Intent i1 = new Intent(Pass.this,Name.class);
                    			i1.putExtra("ID",ID);
                    			startActivity(i1);
                    		}
                    		else
                    		{
                    			a.setImageResource(R.drawable.black);
                    			b.setImageResource(R.drawable.black);
                    			c.setImageResource(R.drawable.black);
                    			d.setImageResource(R.drawable.black);
                    			e.setImageResource(R.drawable.black);
                    			f.setImageResource(R.drawable.black);
                    			g.setImageResource(R.drawable.black);
                    			h.setImageResource(R.drawable.black);
                    			i.setImageResource(R.drawable.black);
                    			cou1=0;
                    			cou2=0;
                    			cou3=0;
                    			cou4=0;
                    			cou5=0;
                    			cou6=0;
                    			cou7=0;
                    			cou8=0;
                    			cou9=0;
                    			cur="0";
                    			no.setText("");
                    			fin.setText("");
                    			Toast.makeText(Pass.this, "Password Not Matched", Toast.LENGTH_SHORT).show();
                    		}
                    	}
                    	else
                    	{
                    		a.setImageResource(R.drawable.black);
                        	b.setImageResource(R.drawable.black);
                        	c.setImageResource(R.drawable.black);
                        	d.setImageResource(R.drawable.black);
                        	e.setImageResource(R.drawable.black);
                        	f.setImageResource(R.drawable.black);
                        	g.setImageResource(R.drawable.black);
                        	h.setImageResource(R.drawable.black);
                        	i.setImageResource(R.drawable.black);
                        	cou1=0;
                        	cou2=0;
                        	cou3=0;
                        	cou4=0;
                        	cou5=0;
                        	cou6=0;
                        	cou7=0;
                        	cou8=0;
                        	cou9=0;
                        	cur="0";
                        	no.setText("");
                        	fin.setText("");
                    	}
                    }
                }
                return true;

            }
        });
    }
}
