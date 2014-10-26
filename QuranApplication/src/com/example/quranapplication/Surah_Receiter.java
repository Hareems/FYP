package com.example.quranapplication;

import android.app.SearchManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class Surah_Receiter extends TabActivity {
	// TabSpec Names
	private static final String Surah_SPEC = "Surah";
	private static final String Juzz_SPEC = "Juzz";
	private static final String Receiter_SPEC = "Reciter";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surah_receiter);
        
        TabHost tabHost = getTabHost();
        
        // Inbox Tab
        TabSpec surahSpec = tabHost.newTabSpec(Surah_SPEC);
        // Tab Icon
        surahSpec.setIndicator(Surah_SPEC);
        Intent surahIntent = new Intent(this, Surah.class);
        // Tab Content
       surahSpec.setContent(surahIntent);
        
        // Outbox Tab
        TabSpec juzzSpec = tabHost.newTabSpec(Juzz_SPEC);
        juzzSpec.setIndicator(Juzz_SPEC);
        Intent juzzIntent = new Intent(this, Juzz.class);
        juzzSpec.setContent(juzzIntent);
        
        // Profile Tab
        TabSpec receiterSpec = tabHost.newTabSpec(Receiter_SPEC);
        receiterSpec.setIndicator(Receiter_SPEC);
        Intent receiterIntent = new Intent(this, Receiter.class);
        receiterSpec.setContent(receiterIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(surahSpec); // Adding Inbox tab
        tabHost.addTab(juzzSpec); // Adding Outbox tab
        tabHost.addTab(receiterSpec); // Adding Profile tab
    } @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bookmark_menu, menu);
     // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
 
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       
        switch (item.getItemId()) {
        case R.id.search:
            // search action
            return true;
        case R.id.notification:
            // notification
            Notification();
            return true;
        case R.id.home:
        	Home();
            // home
            return true;
      
          
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    private void Notification() {
        Intent i = new Intent(Surah_Receiter.this, Notification.class);
        startActivity(i);
    }
    
    private void Home() {
        Intent i = new Intent(Surah_Receiter.this, StudentDashboardDesignActivity.class);
        startActivity(i);
    }
    
   
    
    
}


