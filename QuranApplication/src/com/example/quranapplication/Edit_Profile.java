package com.example.quranapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Edit_Profile extends Activity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.edit_profile);
    final Button switchact =(Button)findViewById(R.id.save_changes);
    switchact.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent act1 = new Intent(view.getContext(),Profile.class);
        startActivity(act1);
      }
    });
}
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
  	MenuInflater inflater = getMenuInflater();
      inflater.inflate(R.menu.activity_main_action, menu);
  
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
      case R.id.about:
      	About();
          // about us
          return true;
      case R.id.settings:
          Settings();
      	// settings
          return true;
      default:
          return super.onOptionsItemSelected(item);
      }
  }
  private void Notification() {
      Intent i = new Intent(Edit_Profile.this, Notification.class);
      startActivity(i);
  }
  
  private void Home() {
      Intent i = new Intent(Edit_Profile.this, StudentDashboardDesignActivity.class);
      startActivity(i);
  }
  
  private void About() {
      Intent i = new Intent(Edit_Profile.this, About.class);
      startActivity(i);
  }
  
  private void Settings() {
      Intent i = new Intent(Edit_Profile.this, Settings.class);
      startActivity(i);
  }
}
  
