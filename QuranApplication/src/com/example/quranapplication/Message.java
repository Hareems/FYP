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

public class Message extends TabActivity {
	// TabSpec Names
	private static final String INBOX_SPEC = "Inbox";
	private static final String OUTBOX_SPEC = "Outbox";
	private static final String Compose_SPEC = "Compose";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        
        TabHost tabHost = getTabHost();
        
        // Inbox Tab
        TabSpec inboxSpec = tabHost.newTabSpec(INBOX_SPEC);
        // Tab Icon
        inboxSpec.setIndicator(INBOX_SPEC);
        Intent inboxIntent = new Intent(this, Inbox.class);
        // Tab Content
        inboxSpec.setContent(inboxIntent);
        
        // Outbox Tab
        TabSpec outboxSpec = tabHost.newTabSpec(OUTBOX_SPEC);
        outboxSpec.setIndicator(OUTBOX_SPEC);
        Intent outboxIntent = new Intent(this, Outbox.class);
        outboxSpec.setContent(outboxIntent);
        
        // Profile Tab
        TabSpec composeSpec = tabHost.newTabSpec(Compose_SPEC);
        composeSpec.setIndicator(Compose_SPEC);
        Intent composeIntent = new Intent(this, Compose.class);
        composeSpec.setContent(composeIntent);
        
        // Adding all TabSpec to TabHost
        tabHost.addTab(inboxSpec); // Adding Inbox tab
        tabHost.addTab(outboxSpec); // Adding Outbox tab
        tabHost.addTab(composeSpec); // Adding Profile tab
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
    
 
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       
        switch (item.getItemId()) {
        
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
        Intent i = new Intent(Message.this, Notification.class);
        startActivity(i);
    }
    
    private void Home() {
        Intent i = new Intent(Message.this, StudentDashboardDesignActivity.class);
        startActivity(i);
    }
    
   
}
