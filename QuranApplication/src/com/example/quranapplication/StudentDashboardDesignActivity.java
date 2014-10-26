package com.example.quranapplication;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class StudentDashboardDesignActivity extends Activity {
	
	Activity ctx;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.dashboard_fragment_layout);
	         
	        ctx = this;
	        
	        /**
	         * Creating all buttons instances
	         * */
	        // Dashboard profile button
	        Button profile_btn = (Button) findViewById(R.id.profile_btn);
	         
	        // Dashboard message button
	        Button message_btn = (Button) findViewById(R.id.message_btn);
	         
	        // Dashboard boomarks button
	        Button bookmark_btn = (Button) findViewById(R.id.bookmark_btn);
	         
	        // Dashboard surah button
	        Button surah_btn = (Button) findViewById(R.id.surah_btn);
	         
	        // Dashboard quaris button
	        Button receiter_btn = (Button) findViewById(R.id.receiter_btn);
	         
	    
	         
	     // Dashboard settings button
	        Button quari_btn = (Button) findViewById(R.id.quari_btn);
	         
	        /**
	         * Handling all button click events
	         * */
	         
	        // Listening to profile button click
	        profile_btn.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View view) {
	                // Launching profile Screen
	                Intent i = new Intent(getApplicationContext(), TestProfile.class);
	                startActivity(i);
	            }
	        });
	         
	       // Listening message button click
	        message_btn.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View view) {
	                // Launching message Screen
	                Intent i = new Intent(getApplicationContext(), Message.class);
	                startActivity(i);
	            }
	        });
	         
	        // Listening Boomarks button click
	        bookmark_btn.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View view) {
	                // Launching Boomarks Screen
	                Intent i = new Intent(getApplicationContext(), Bookmarks.class);
	                startActivity(i);
	            }
	        });
	         
	        // Listening to Surah button click
	        surah_btn.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View view) {
	                // Launching surah Screen
	                Intent i = new Intent(getApplicationContext(), Surah_Receiter.class);
	                startActivity(i);
	            }
	        });
	         
	        // Listening to Quaris button click
	        receiter_btn.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View view) {
	                // Launching quaris Screen
	                Intent i = new Intent(getApplicationContext(), Surah_Receiter.class);
	                startActivity(i);
	            }
	        });
	         
	       
	        // Listening to quari button click
	        quari_btn.setOnClickListener(new View.OnClickListener() {
	             
	            @Override
	            public void onClick(View view) {
	                // Launching settings Screen
	                Intent i = new Intent(getApplicationContext(), Quari.class);
	                startActivity(i);
	            }
	            
	        });
	    }
	 
	 @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	    	MenuInflater inflater = getMenuInflater();
	        inflater.inflate(R.menu.setting_about, menu);
	     
	 
	        return super.onCreateOptionsMenu(menu);
	    }

	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	       
	        switch (item.getItemId()) {
	        case R.id.settings:
	        	Settings();
	            // search action
	            return true;
	        case R.id.about:
	        	Settings();
	            // search action
	            return true;
	       
	       
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	    private void Settings() {
	        Intent i = new Intent(ctx, PasswordSetting.class);
	        startActivity(i);
	    }
	    
	    private void About() {
	        Intent i = new Intent(ctx, About.class);
	        startActivity(i);
	    }
	    
}
