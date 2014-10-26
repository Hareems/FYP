package com.constant;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.quranapplication.R;

public class AppPrefs {
	public static String BASE_URL = "http://localhost:1771/api/";
	
	private SharedPreferences appSharedPrefs;
	private SharedPreferences.Editor prefsEditor;
	private String user_id = "user_id_prefs";
	private String full_name = "full_name_prefs";
	private String user_name = "user_name_prefs";
	private String email = "email_prefs";
	private String phone_num = "phone_prefs";
	private String category = "category_prefs";
	private String status = "status_prefs";
	Dialog alert;
	AsyncHttpClient async;
	Animation shake;
	Context mcontext;

	public AppPrefs(Context ctx) {
		// TODO Auto-generated constructor stub
		appSharedPrefs = ctx.getSharedPreferences(
				ctx.getString(R.string.app_name), Context.MODE_PRIVATE);
		prefsEditor = appSharedPrefs.edit();
		async = new AsyncHttpClient();
		shake = AnimationUtils.loadAnimation(ctx, R.anim.shake);
		this.mcontext = ctx;

	}

	public String getUser_id() {
		return appSharedPrefs.getString(user_id, "");
	}

	public void setUser_id(String userid) {
		prefsEditor.putString(user_id, userid).commit();
	}

	public String getFull_name() {
		return appSharedPrefs.getString(full_name, "");
	}

	public void setFull_name(String fullname) {
		prefsEditor.putString(full_name, fullname).commit();
	}

	public String getUser_name() {
		return appSharedPrefs.getString(user_name, "");
	}

	public void setUser_name(String username) {
		prefsEditor.putString(user_name, username).commit();
	}

	public String getEmail() {
		return appSharedPrefs.getString(email, "");
	}

	public void setEmail(String _email) {
		prefsEditor.putString(email, _email).commit();
	}

	public String getPhone() {
		return appSharedPrefs.getString(phone_num, "");
	}

	public void setPhone(String phone) {
		prefsEditor.putString(phone_num, phone).commit();
	}

	public String getStatus() {
		return appSharedPrefs.getString(status, "");
	}

	public void setStatus(String _status) {
		prefsEditor.putString(status, _status).commit();

	}

	public String getCategory() {
		return appSharedPrefs.getString(category, "");
	}

	public void setCategory(String _category) {
		prefsEditor.putString(category, _category).commit();
	}

	public void appSharedClear() {
		prefsEditor.putString(user_id, "");
		prefsEditor.putString(full_name, "");
		prefsEditor.putString(user_name, "");
		prefsEditor.putString(phone_num, "");
		prefsEditor.putString(status, null);

		// prefsEditor.clear().commit();

	}

//	public void alert_dialog(final Activity ctx, final String type,
//			String heading, String field_heading, String hint,
//			final String toast) {
//
//		alert = new Dialog(ctx, android.R.style.Theme_Translucent);
//		alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		alert.setCancelable(true);
//		alert.setCanceledOnTouchOutside(true);
//		alert.setContentView(R.layout.forget_password_layout);
//		TextView heading_tv = (TextView) alert.findViewById(R.id.heading);
//		TextView field_heading_tv = (TextView) alert
//				.findViewById(R.id.field_heading);
//		final EditText emailEditText = (EditText) alert
//				.findViewById(R.id.emailEditText);
//
//		TextView yes_btn = (TextView) alert.findViewById(R.id.yes_btn);
//		TextView no_btn = (TextView) alert.findViewById(R.id.no_btn);
//		heading_tv.setText(heading);
//		field_heading_tv.setText(field_heading);
//
//		emailEditText.setHint(hint);
//
//		emailEditText.setError(null);
//
//		yes_btn.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				final String usernametxt = emailEditText.getText().toString();
//				boolean cancel = false;
//				if (TextUtils.isEmpty(usernametxt)) {
//					emailEditText.startAnimation(shake);
//					cancel = true;
//				}
//				if (cancel) {
//					cancel = false;
//				} else {
//					if (Utils.isConnected(ctx)) {
//						ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//
//						if (type.equals("password")) {
//							nameValuePairs.add(new BasicNameValuePair("email",
//									usernametxt));
//							async.execute(ctx, type, AppPrefs.BASE_URL
//									+ "forgotPassword?", nameValuePairs,
//									new AsyncHttpResponseHandler() {
//
//										@Override
//										public void onSuccess(String response) {
//											// TODO Auto-generated method stub
//
//											try {
//												JSONObject status_obj = new JSONObject(
//														response);
//												String status = status_obj
//														.getString("status");
//												if (status.equals("TRUE")) {
//													Toast.makeText(
//															ctx,
//															status_obj
//																	.getString("message"),
//															Toast.LENGTH_SHORT)
//															.show();
//													alert.cancel();
//
//												}
//												Toast.makeText(
//														ctx,
//														status_obj
//																.getString("message"),
//														Toast.LENGTH_SHORT)
//														.show();
//											} catch (JSONException e) {
//												// TODO Auto-generated catch
//												// block
//												e.printStackTrace();
//											}
//
//										}
//									});
//						} else {
//							nameValuePairs.add(new BasicNameValuePair(
//									"user_id", getUser_id()));
//							nameValuePairs.add(new BasicNameValuePair("code",
//									usernametxt));
//							async.execute(ctx, type, AppPrefs.BASE_URL
//									+ "activateUserAccount?", nameValuePairs,
//									new AsyncHttpResponseHandler() {
//
//										@Override
//										public void onSuccess(String response) {
//											// TODO Auto-generated method stub
//
//											try {
//												JSONObject status_obj = new JSONObject(
//														response);
//												String status = status_obj
//														.getString("status");
//												if (status.equals("TRUE")) {
//													Toast.makeText(
//															ctx,
//															status_obj
//																	.getString("message"),
//															Toast.LENGTH_SHORT)
//															.show();
//													Utils.slideInRightAnim(
//															ctx,
//															MainContainer.class,
//															true);
//													alert.cancel();
//												}
//												Toast.makeText(
//														ctx,
//														status_obj
//																.getString("message"),
//														Toast.LENGTH_SHORT)
//														.show();
//											} catch (JSONException e) {
//												// TODO Auto-generated catch
//												// block
//												e.printStackTrace();
//											}
//
//										}
//									});
//
//						}
//
//					}
//				}
//
//			}
//
//		});
//
//		no_btn.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				alert.cancel();
//
//			}
//		});
//
//		alert.show();
//
//	}
//
//	public void Logout_dialog(final Activity ctx, String heading,
//			String field_heading) {
//
//		alert = new Dialog(ctx, android.R.style.Theme_Translucent);
//		alert.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		alert.setCancelable(true);
//		alert.setCanceledOnTouchOutside(true);
//		alert.setContentView(R.layout.logout_layout);
//		TextView heading_tv = (TextView) alert.findViewById(R.id.heading);
//		TextView field_heading_tv = (TextView) alert
//				.findViewById(R.id.field_heading);
//
//		TextView yes_btn = (TextView) alert.findViewById(R.id.yes_btn);
//		TextView no_btn = (TextView) alert.findViewById(R.id.no_btn);
//		heading_tv.setText(heading);
//		field_heading_tv.setText(field_heading);
//
//		yes_btn.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				Utils.slideInRightAnim(ctx, LoginActivity.class, true);
//				appSharedClear();
//				alert.cancel();
//			}
//
//		});
//
//		no_btn.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				alert.cancel();
//
//			}
//		});
//
//		alert.show();
//
//	}

}
