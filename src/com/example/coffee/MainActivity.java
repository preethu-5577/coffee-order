package com.example.coffee;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int numofc=1;
    TextView cofe;
    String name;
    Button menu;
    String order;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu=(Button)findViewById(R.id.menu);
        final EditText ed=(EditText)findViewById(R.id.namefield);
    	
        menu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Bundle bu=new Bundle();
				name=ed.getText().toString();
				bu.putString("str",name );
				
			//	submitorder();
				Intent i=new Intent(MainActivity.this,submit.class);
				i.putExtras(bu);
				startActivity(i);
			}
		});
    }
    
    public void submitorder()
    {
    	
    	
    	CheckBox wc=(CheckBox)findViewById(R.id.whipped_cream);
    	boolean haswc=wc.isChecked();
    	
    	CheckBox ch=(CheckBox)findViewById(R.id.chocolate);
    	boolean hasch=ch.isChecked();
    	
    	int price=calprice(haswc,hasch);
    	
    	order=ordersummary(price,haswc,hasch);
    	
    	
    	
    	Intent i=new Intent(Intent.ACTION_SENDTO);
    	i.setData(Uri.parse("mailto"));
    	i.putExtra(Intent.EXTRA_TEXT,order);
    	i.putExtra(Intent.EXTRA_SUBJECT,"coffee order");
    	i.putExtra(Intent.EXTRA_EMAIL,"preethi.sp@outlook.com");
    	
    		
      }
    
    private String ordersummary(int p,boolean a,boolean b)
    {
    	String str="";
    	str+="NAME : "+name+"\n";
    	str+="Total Price : INR "+p+"\n";
    	str+="has whipped cream ? "+a+"\n";
    	str+="has chocolate ? "+b+"\n";
    	return str;
    }
    
    private int calprice(boolean a,boolean b)
    {
    	int p=numofc*5;
    	if(a==true)
    	{
    		p+=(numofc);
    	}
    	if(b==true)
    	{
    		p+=(2*numofc);
    	}
    	return p;
    }
    
    public void decrement(View view)
    {
    	if(numofc==1)
    	{
    		Toast.makeText(MainActivity.this,"minimum order is 1 cup", Toast.LENGTH_LONG).show();
    		return;
    	}
    	numofc-=1;
    	displaynumofc();
    }
    public void increment(View view)
    {
    	if(numofc==100)
    	{
    		Toast.makeText(MainActivity.this,"maximum order is 100 cups", Toast.LENGTH_LONG).show();
    		return;
    	}
    	numofc+=1;
    	displaynumofc();
    }
    private void displaynumofc()
    {
    	cofe=(TextView)findViewById(R.id.numofcoffees);
    	cofe.setText(numofc+"");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
