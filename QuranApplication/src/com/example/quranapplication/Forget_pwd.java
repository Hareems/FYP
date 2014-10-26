package com.example.quranapplication;


import com.constant.AppPrefs;
import com.constant.Utils;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;

public class Forget_pwd extends Activity {
	
	private EditText enter_emailEditText;
	public Resources res;
	public String enter_emailtxt;
	Activity ctx;
	AppPrefs appPrefs;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
      
        ctx = this;
		res = getResources();
		enter_emailEditText = (EditText) findViewById(R.id.enter_email);
		
		// using cancel button to move to main activity 
		Button cancel_btn = (Button) findViewById(R.id.cancel);
		cancel_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent i = new Intent(getApplicationContext(),
						MainActivity.class);
				startActivity(i);

			}
		});
		
		
		
		// using send button to send new password 
				Button send_btn = (Button) findViewById(R.id.send_email);
				send_btn.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub

						logMeIn();

					}
				});
    }
	
	protected void logMeIn() {

		enter_emailEditText.setError(null);
		enter_emailtxt = enter_emailEditText.getText().toString();
		boolean cancel = false;
		View focusView = null;
		if (TextUtils.isEmpty(enter_emailtxt)) {
			enter_emailEditText.setError(res.getString(R.string.fieldError));
			focusView = enter_emailEditText;
			cancel = true;
		}else if (!Utils.isEmailValid(enter_emailtxt)) {
			enter_emailEditText
			.setError("Username invalid");
	focusView = enter_emailEditText;
	cancel = true;
	}
	
		Intent i = new Intent(getApplicationContext(),
				MainActivity.class);
		startActivity(i);
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
	        Intent i = new Intent(ctx, Notification.class);
	        startActivity(i);
	    }
	    
	    private void Home() {
	        Intent i = new Intent(ctx, StudentDashboardDesignActivity.class);
	        startActivity(i);
	    }
	    
}
