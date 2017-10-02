package com.example.coffee;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class submit extends Activity {
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submit);
        TextView t1=(TextView)findViewById(R.id.txt1);
       Bundle f=getIntent().getExtras();
       String c= f.getString("str"); 
       t1.setText(c);
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
