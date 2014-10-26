package com.example.quranapplication;

import com.constant.AppPrefs;
import com.constant.AsyncHttpClient;
import com.constant.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class PasswordSetting extends Activity{
	
	private EditText newpasswordEditText, passwordEditText, confirmpasswordEditText;
	public Resources res;
	public String  confirmpasswordtxt, passwordtxt, newpasswordtxt;
	
	Activity ctx;
	AsyncHttpClient async;
	AppPrefs appPrefs;
	
	
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.passwordsetting);
	        
	        ctx = this;
			res = getResources();
			newpasswordEditText = (EditText) findViewById(R.id.newpassword);
			passwordEditText = (EditText) findViewById(R.id.pass_word);
			confirmpasswordEditText = (EditText) findViewById(R.id.confirmpassword);  
			
			// using cancel button to move to dashboard  
			Button cancel_btn = (Button) findViewById(R.id.cancel);
			cancel_btn.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub

					Intent i = new Intent(getApplicationContext(),
						StudentDashboardDesignActivity.class);
					startActivity(i);

				}
			});
			
			
			  //to save password
	        Button save_pwd_btn=(Button)findViewById(R.id.save_changes);
	        save_pwd_btn.setOnClickListener(new View.OnClickListener() {

	                        @Override
	                        public void onClick(View v) {
	                            // TODO Auto-generated method stub
	                        	Check();
	                        } 
	           });	
}
	 protected void Check() {

		 newpasswordEditText.setError(null);
			passwordEditText.setError(null);
			confirmpasswordEditText.setError(null);

			newpasswordtxt = newpasswordEditText.getText().toString();
			confirmpasswordtxt = confirmpasswordEditText.getText().toString();
			passwordtxt = passwordEditText.getText().toString();
			boolean cancel = false;
			View focusView = null;

			if (TextUtils.isEmpty(passwordtxt)) {
				passwordEditText.setError(res.getString(R.string.fieldError));
				focusView = passwordEditText;
				cancel = true;
			} 
			
			
			if (TextUtils.isEmpty(newpasswordtxt)) {
				newpasswordEditText.setError(res.getString(R.string.fieldError));
				focusView = newpasswordEditText;
				cancel = true;
			} else if (newpasswordtxt.length() < 3) {
				newpasswordEditText
				.setError("Password is too weak");
		focusView = newpasswordEditText;
		cancel = true;
	} 
			
			
			if (!confirmpasswordtxt.equals(newpasswordtxt)) {
				   confirmpasswordEditText
				     .setError("Confirm Password does not match");
				   focusView = confirmpasswordEditText;
				   cancel = true;
				  }
			
			if (cancel) {
				focusView.requestFocus();
				cancel = false;
			} else {
				if (Utils.isConnected(this)) {
					InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					imm.hideSoftInputFromWindow(passwordEditText.getWindowToken(),
							0);

					 Intent i = new Intent(getApplicationContext(),StudentDashboardDesignActivity.class);
                  startActivity(i);
				}
			}

		}
}