package com.constant;

import java.util.regex.Pattern;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION_CODES;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * Created by anasvenom on 6/12/13.
 */
public class Utils {

	public static final String DATA_ERROR = "Data Connection not available.";
	public static final String FIELD_ERROR = "This field is required";
	public static int imageSize;

	public static boolean isEmailValid(String email) {
		if (email == null)
			return false;
		else
			return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	}

	public static boolean isUserNameValid(String username) {
		if (username == null)
			return false;
		else {
			Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,15}$");
			return pattern.matcher(username).matches();
		}
	}

	public static boolean isUrlYouTubeOrVimeo(String url) {
		if (url == null)
			return false;
		else {
			return url.contains("youtube") | url.contains("vimeo") ? true
					: false;
		}
	}

	public static boolean isConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (activeNetwork != null && activeNetwork.isConnected()) {
			return true;
		}

		// NetworkInfo wifiNetwork = cm
		// .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		// if (wifiNetwork != null && wifiNetwork.isConnected()) {
		// return true;
		// }
		//
		// NetworkInfo mobileNetwork = cm
		// .getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		// if (mobileNetwork != null && mobileNetwork.isConnected()) {
		// return true;
		// }

		Toast.makeText(context, DATA_ERROR, Toast.LENGTH_SHORT).show();
		Log.e("context", "" + context);
		return false;
	}

	/**
	 * Shows the progress UI and hides the login form.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	public static void showProgress(Context context, final boolean show,
			final View mProgressView, final View mFormView) {
		Log.e("show progress", "show progress " + show);
		// On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
		// for very easy animations. If available, use these APIs to fade-in
		// the progress spinner.
		try {
			if (hasHoneycombMR2()) {
				int shortAnimTime = context.getResources().getInteger(
						android.R.integer.config_shortAnimTime);

				mProgressView.setVisibility(View.VISIBLE);
				mProgressView.animate().setDuration(shortAnimTime)
						.alpha(show ? 1 : 0)
						.setListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
								mProgressView.setVisibility(show ? View.VISIBLE
										: View.GONE);
							}
						});

				mFormView.setVisibility(View.VISIBLE);
				mFormView.animate().setDuration(shortAnimTime)
						.alpha(show ? 0 : 1)
						.setListener(new AnimatorListenerAdapter() {
							@Override
							public void onAnimationEnd(Animator animation) {
								mFormView.setVisibility(show ? View.GONE
										: View.VISIBLE);
							}
						});
			} else {
				// The ViewPropertyAnimator APIs are not available, so simply
				// show
				// and hide the relevant UI components.
				mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
				mFormView.setVisibility(show ? View.GONE : View.VISIBLE);
			}
		} catch (Exception e) {
			// TODO: handle exception
			// e.printStackTrace();
		}
	}

//	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//	public static void slideInBottomAnim(Activity activity, Class<?> targetClass) {
//		Intent intent = new Intent(activity, targetClass);
//		if (hasJellyBean()) {
//			Bundle translateBundle = ActivityOptions.makeCustomAnimation(
//					activity, R.anim.slide_in_top, R.anim.slide_out_top)
//					.toBundle();
//			activity.startActivity(intent, translateBundle);
//		} else {
//			activity.startActivity(intent);
//			activity.overridePendingTransition(R.anim.slide_in_top,
//					R.anim.slide_out_top);
//		}
//	}
//
//	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
//	public static void slideInRightAnim(Activity activity,
//			Class<?> targetClass, boolean isFinish) {
//		Intent intent = new Intent(activity, targetClass);
//		if (hasJellyBean()) {
//			Bundle translateBundle = ActivityOptions.makeCustomAnimation(
//					activity, R.anim.slide_in_left, R.anim.slide_out_left)
//					.toBundle();
//			activity.startActivity(intent, translateBundle);
//			if (isFinish) {
//				activity.finish();
//			}
//
//		} else {
//			activity.startActivity(intent);
//			activity.overridePendingTransition(R.anim.slide_in_left,
//					R.anim.slide_out_left);
//		}
//	}
//
//	public static void slideOutRightAnim(Activity activity) {
//		activity.overridePendingTransition(R.anim.slide_out_right,
//				R.anim.slide_in_right);
//	}
//
//	public static void slideOutTopAnim(Activity activity) {
//		activity.overridePendingTransition(R.anim.slide_out_bottom,
//				R.anim.slide_in_bottom);
//	}

	public static boolean hasFroyo() {
		// Can use static final constants like FROYO, declared in later versions
		// of the OS since they are inlined at compile time. This is guaranteed
		// behavior.
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO;
	}

	public static boolean hasGingerbread() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD;
	}

	public static boolean hasHoneycomb() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
	}

	public static boolean hasHoneycombMR2() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2;
	}

	public static boolean hasJellyBean() {
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;
	}

	public static boolean hasHoneycombMR1() {
		// TODO Auto-generated method stub
		return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1;
	}

	public static boolean hasKitKat() {
		return Build.VERSION.SDK_INT >= VERSION_CODES.KITKAT;
	}
}
