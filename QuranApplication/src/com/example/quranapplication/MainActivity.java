package com.example.quranapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.constant.AppPrefs;
import com.constant.AsyncHttpClient;
import com.constant.Utils;

public class MainActivity extends Activity {

	private EditText emailEditText, passwordEditText;
	public Resources res;
	public String usernametxt;
	public String passwordtxt, status;

	public static final String KEY_USER = "UserName";
	public static final String KEY_PASS = "PassWord";
	public static String DEBUG_TAG;
	Activity ctx;
	View loginScreenLayout;
	AsyncHttpClient async;

	Dialog alert;
	Animation shake;
	AppPrefs appPrefs;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setting default screen to login.xml
		setContentView(R.layout.login);

		ctx = this;
		res = getResources();
		emailEditText = (EditText) findViewById(R.id.email);
		passwordEditText = (EditText) findViewById(R.id.enterpassword);
		shake = AnimationUtils.loadAnimation(this, R.anim.shake);

		TextView registerScreen = (TextView) findViewById(R.id.registeration);

		// Listening to register new account link
		registerScreen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Switching to Register screen
				Intent i = new Intent(getApplicationContext(),
						Registeration.class);
				startActivity(i);
			}
		});

	TextView forget_password = (TextView) findViewById(R.id.forget_password);

		// Listening to register new account link
		forget_password.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(getApplicationContext(),
						Forget_pwd.class);
				startActivity(i);
			}
		});
		
		
		// using signIn button to move to student dashboard
		Button signin_btn = (Button) findViewById(R.id.signin);
		signin_btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				logMeIn();

			}
		});

	}

	protected void logMeIn() {

		emailEditText.setError(null);
		passwordEditText.setError(null);

		usernametxt = emailEditText.getText().toString();
		passwordtxt = passwordEditText.getText().toString();
		boolean cancel = false;
		View focusView = null;

		if (TextUtils.isEmpty(passwordtxt)) {
			passwordEditText.setError(res.getString(R.string.fieldError));
			focusView = passwordEditText;
			cancel = true;
		}
		if (TextUtils.isEmpty(usernametxt)) {
			emailEditText.setError(res.getString(R.string.fieldError));
			focusView = emailEditText;
			cancel = true;
		} else if (usernametxt.length() < 3) {
			emailEditText
					.setError("Username must be atleast three characters long");
			focusView = emailEditText;
			cancel = true;
		} else if (!Utils.isUserNameValid(usernametxt)) {
			emailEditText
					.setError("Username must contain only lowercase a-z, 0-9, -, or _.");
			focusView = emailEditText;
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

				Intent i = new Intent(getApplicationContext(),
						StudentDashboardDesignActivity.class);
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
