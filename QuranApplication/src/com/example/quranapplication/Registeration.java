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
import android.widget.TextView;

public class Registeration extends Activity{
	
	private EditText firstnameEditText, lastnameEditText, usernameEditText, passwordEditText, confirmpasswordEditText;
	public Resources res;
	public String firstnametxt, lastnametxt, usernametxt, confirmpasswordtxt;
	public String passwordtxt, status;
	
	Activity ctx;
	//View loginScreenLayout;
	AsyncHttpClient async;

	//Dialog alert;
	//Animation shake;
	AppPrefs appPrefs;
	
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	       
	        // Set View to register.xml
	        setContentView(R.layout.registeration);
	        
	        ctx = this;
			res = getResources();
			firstnameEditText = (EditText) findViewById(R.id.firstname);
			lastnameEditText = (EditText) findViewById(R.id.lastname);
			usernameEditText = (EditText) findViewById(R.id.username);
			passwordEditText = (EditText) findViewById(R.id.pass_word);
			confirmpasswordEditText = (EditText) findViewById(R.id.confirmpassword);
			
			//shake = AnimationUtils.loadAnimation(this, R.anim.shake);
	 
	        TextView loginScreen = (TextView) findViewById(R.id.login);
	 
	        // Listening to Login Screen link when user already has account
	        loginScreen.setOnClickListener(new View.OnClickListener() {
	 
	            @Override
				public void onClick(View arg0) {
	            	
	            
	            	
	                // Closing registration screen
	                // Switching to Login Screen
	                finish();
	            }
	        });
	        //using registered button to move to login screen after successful registeration 
	        Button register_btn=(Button)findViewById(R.id.register);
	            register_btn.setOnClickListener(new View.OnClickListener() {

	                        @Override
	                        public void onClick(View v) {
	                            // TODO Auto-generated method stub
	                        	logMeIn();
	                        	
	                           
	                            
	                         }
	                            
	                        
	                    });   
	 }
	 protected void logMeIn() {

			firstnameEditText.setError(null);
			lastnameEditText.setError(null);
			usernameEditText.setError(null);
			passwordEditText.setError(null);
			confirmpasswordEditText.setError(null);

			firstnametxt = firstnameEditText.getText().toString();
			lastnametxt = lastnameEditText.getText().toString();
			usernametxt = usernameEditText.getText().toString();
			confirmpasswordtxt = confirmpasswordEditText.getText().toString();
			passwordtxt = passwordEditText.getText().toString();
			boolean cancel = false;
			View focusView = null;

			if (TextUtils.isEmpty(passwordtxt)) {
				passwordEditText.setError(res.getString(R.string.fieldError));
				focusView = passwordEditText;
				cancel = true;
			} else if (passwordtxt.length() < 3) {
				passwordEditText
				.setError("Password must be atleast three characters long");
		focusView = passwordEditText;
		cancel = true;
	} 
			
			if (!confirmpasswordtxt.equals(passwordtxt)) {
				   confirmpasswordEditText
				     .setError("Confirm Password does not match");
				   focusView = confirmpasswordEditText;
				   cancel = true;
				  }
			
			if (TextUtils.isEmpty(firstnametxt)) {
				firstnameEditText.setError(res.getString(R.string.fieldError));
				focusView = firstnameEditText;
				cancel = true;}
			
			if (TextUtils.isEmpty(lastnametxt)) {
				lastnameEditText.setError(res.getString(R.string.fieldError));
				focusView = lastnameEditText;
				cancel = true;}
			
			if (TextUtils.isEmpty(usernametxt)) {
				usernameEditText.setError(res.getString(R.string.fieldError));
				focusView = usernameEditText;
				cancel = true;
			} else if (usernametxt.length() < 3) {
				usernameEditText
						.setError("Username must be atleast three characters long");
				focusView = usernameEditText;
				cancel = true;
			} else if (!Utils.isUserNameValid(usernametxt)) {
				usernameEditText
						.setError("Username must contain only lowercase a-z, 0-9, -, or _.");
				focusView = usernameEditText;
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

					 Intent i = new Intent(getApplicationContext(),MainActivity.class);
                     startActivity(i);
                     

					// ArrayList<NameValuePair> nameValuePairs = new
					// ArrayList<NameValuePair>();
					// nameValuePairs
					// .add(new BasicNameValuePair("email", usernametxt));
					// nameValuePairs.add(new BasicNameValuePair("password",
					// passwordtxt));
					//
					// async.execute(ctx, this.getLocalClassName(),
					// AppPrefs.BASE_URL
					// + "login?", nameValuePairs,
					// new AsyncHttpResponseHandler() {
					//
					// @Override
					// public void onSuccess(String response) {
					// // TODO Auto-generated method stub
					// JSONObject result;
					// try {
					// result = new JSONObject(response);
					// String status = result.getString("status");
					// if (status.equals("TRUE")) {
					// String finalData = result
					// .getString("data");
					// JSONObject finalData_obj = new JSONObject(
					// finalData);
					//
					//
					// appPrefs.setUser_id(finalData_obj
					// .getString("user_id"));
					// appPrefs.setFull_name(finalData_obj
					// .getString("user_full_name"));
					// appPrefs.setUser_name(finalData_obj
					// .getString("user_name"));
					// appPrefs.setEmail(finalData_obj
					// .getString("user_email"));
					// appPrefs.setPhone(finalData_obj
					// .getString("user_mobile"));
					// appPrefs.setCategory(finalData_obj
					// .getString("user_category"));
					// appPrefs.setStatus(finalData_obj
					// .getString("user_status"));
					// if (finalData_obj.getString(
					// "user_status").equals("0")) {
					//
					// // appPrefs.alert_dialog(
					// // ctx,
					// // "code",
					// // res.getString(R.string.verification_heading),
					// // res.getString(R.string.code),
					// // res.getString(R.string.code),
					// // res.getString(R.string.wrong_code));
					// } else {
					//
					// // Utils.slideInRightAnim(ctx,
					// // MainContainer.class, true);
					// }
					//
					// } else {
					// Toast.makeText(ctx,
					// result.getString("message"),
					// Toast.LENGTH_SHORT).show();
					// }
					// } catch (JSONException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// } catch (Exception e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					//
					// }
					// });
					//
				}
			}

		}
}
