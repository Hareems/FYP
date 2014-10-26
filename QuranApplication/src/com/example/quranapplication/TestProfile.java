package com.example.quranapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.app.Activity;
import android.app.SearchManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;


public class TestProfile extends Activity {

	Button button;
	Button save_changes_btn;
	Button edit_profile_btn;
	ImageView image;
	private EditText firstnameET, lastnameET;
	public String firstnametxt,lastnametxt;
	private TextView first_nameTxtView, last_nameTxtView;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testprofile);
        addListenerOnButton();
        
        lastnameET =(EditText)findViewById(R.id.lastname);
        last_nameTxtView =(TextView)findViewById(R.id.last_name);
        firstnameET =(EditText)findViewById(R.id.firstname);
        first_nameTxtView =(TextView)findViewById(R.id.first_name);
          edit_profile_btn =(Button)findViewById(R.id.edit_profile);
         edit_profile_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
        
        	  first_nameTxtView.setVisibility(View.GONE);  
        	
        	  firstnameET.setVisibility(View.VISIBLE); 
        	  last_nameTxtView.setVisibility(View.GONE);
        	  lastnameET.setVisibility(View.VISIBLE);
        	  
        	  
        	  edit_profile_btn.setVisibility(View.GONE);
        
        	  save_changes_btn.setVisibility(View.VISIBLE);
        	  
        	  
          }
        });
         
         save_changes_btn =(Button)findViewById(R.id.save_changes);
         save_changes_btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
        
        	  
        	  
        	  firstnametxt = firstnameET.getText().toString();
        	  lastnametxt = lastnameET.getText().toString();
        	  
        	  first_nameTxtView.setText(firstnametxt);
        	  last_nameTxtView.setText(lastnametxt);
        	 
        	  first_nameTxtView.setVisibility(View.VISIBLE);  
        	  firstnameET.setVisibility(View.GONE);  
        	  last_nameTxtView.setVisibility(View.VISIBLE);  
        	  lastnameET.setVisibility(View.GONE);
        	  edit_profile_btn.setVisibility(View.VISIBLE);
        	  save_changes_btn.setVisibility(View.GONE);
        	  
        	  
          }
        });
         
         
         
    }
    public void addListenerOnButton() {
    	 
		image = (ImageView) findViewById(R.id.imageView1);
 
		button = (Button) findViewById(R.id.change_image);
		button.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
				image.setImageResource(R.drawable.baba);
			}
 
		});
 
	}
 
   
}


