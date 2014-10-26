package com.constant;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ContentBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.view.WindowManager.BadTokenException;
import android.widget.Toast;

import com.example.quranapplication.R;

public class AsyncHttpClient {

	public interface AsyncHttpResponseHandler {
		public void onSuccess(String response);
	}

	private Object[] params = new Object[4];
	private boolean isProgressHiding = false;

	public void execute(Context context, String TAG, String url, ArrayList<NameValuePair> nameValuePairs,
			AsyncHttpResponseHandler asyncHttpResponseHandler) {
		if (AsyncUtils.isConnected(context)) {
			params[0] = TAG;
			params[1] = url;
			params[2] = nameValuePairs;
			params[3] = asyncHttpResponseHandler;
			new AsyncRequestClass(context).execute(params);
		}
	}

	public void executeWithoutProgressDialog(Context context, String TAG, String url,
			ArrayList<NameValuePair> nameValuePairs, AsyncHttpResponseHandler asyncHttpResponseHandler) {
		if (AsyncUtils.isConnected(context)) {
			isProgressHiding = true;
			params[0] = TAG;
			params[1] = url;
			params[2] = nameValuePairs;
			params[3] = asyncHttpResponseHandler;
			new AsyncRequestClass(context).execute(params);
		}
	}

	public void postWithImage(Context context, String TAG, String url, String imagePath,
			ArrayList<NameValuePair> nameValuePairs, AsyncHttpResponseHandler asyncHttpResponseHandler) {
		params = new Object[5];
		if (AsyncUtils.isConnected(context)) {
			params[0] = TAG;
			params[1] = url;
			params[2] = nameValuePairs;
			params[3] = asyncHttpResponseHandler;
			params[4] = imagePath;
			new AsyncImageRequest(context).execute(params);
		}
	}

	private ProgressDialog createProgressDialog(Context mContext) {
		ProgressDialog dialog = new ProgressDialog(mContext);
		try {
			dialog.show();
		} catch (BadTokenException e) {

		}
		dialog.setCancelable(false);
		dialog.setContentView(R.layout.progressdialog);
		return dialog;
	}

	private class AsyncImageRequest extends AsyncTask<Object, Void, String> {
		ProgressDialog progressDialog;
		String TAG, url, imagePath;
		ArrayList<NameValuePair> nameValuePairs;
		AsyncHttpResponseHandler asyncHttpResponseHandler;
		Context context;

		public AsyncImageRequest(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			if (progressDialog == null) {
				progressDialog = createProgressDialog(context);
				progressDialog.show();
			} else {
				progressDialog.show();
			}
		}

		@SuppressWarnings("unchecked")
		@Override
		protected String doInBackground(Object... params) {
			// TODO Auto-generated method stub
			String response = "";
			try {
				TAG = (String) params[0];
				url = (String) params[1];
				nameValuePairs = (ArrayList<NameValuePair>) params[2];
				asyncHttpResponseHandler = (AsyncHttpResponseHandler) params[3];
				imagePath = (String) params[4];

				HttpClient client = new DefaultHttpClient();
				HttpPost request = new HttpPost(url);
				MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

				if (imagePath != null) {
					File file = new File(imagePath);
					ContentBody encFile = new FileBody(file, "image/jpg/png");
					entity.addPart("images", encFile);
					long totalSize = entity.getContentLength();
					Log.e("SIZE", "" + totalSize);
				}
				if (nameValuePairs != null)
					for (NameValuePair item : nameValuePairs) {
						entity.addPart(item.getName(), new StringBody(item.getValue()));
					}
				request.setEntity(entity);
				ResponseHandler<String> responsehandler = new BasicResponseHandler();

				response = client.execute(request, responsehandler);
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return response;
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (progressDialog != null)
				progressDialog.dismiss();
			if (result != null)
				try {
					Log.e(TAG, result);
					asyncHttpResponseHandler.onSuccess(result);
				} catch (Exception e) {
					Log.e(TAG, "Must implement the interface " + e.toString());
				}
		}
	}

	private class AsyncRequestClass extends AsyncTask<Object, Void, String> {
		ProgressDialog progressDialog;
		String TAG, url;
		ArrayList<NameValuePair> nameValuePairs;
		AsyncHttpResponseHandler asyncHttpResponseHandler;
		Context context;

		public AsyncRequestClass(Context context) {
			// TODO Auto-generated constructor stub
			this.context = context;
		}

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			if (!isProgressHiding)
				if (progressDialog == null) {
					progressDialog = createProgressDialog(context);
					progressDialog.show();
				} else {
					progressDialog.show();
				}
		}

		@SuppressWarnings("unchecked")
		@Override
		protected String doInBackground(Object... params) {
			// TODO Auto-generated method stub
			TAG = (String) params[0];
			url = (String) params[1];
			nameValuePairs = (ArrayList<NameValuePair>) params[2];
			asyncHttpResponseHandler = (AsyncHttpResponseHandler) params[3];

			InputStream is = null;
			String result = "";

			// HTTP post
			try {
				HttpClient httpclient = new DefaultHttpClient();
				HttpGet httpget = new HttpGet(url);
				httpget.addHeader("Content-Type", "application/json");
				/*if (nameValuePairs != null) {
					httpget.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					Log.e(TAG, url + " " + nameValuePairs.toString());
				} else
			*/
					Log.e(TAG, url);
				HttpResponse response = httpclient.execute(httpget);
				HttpEntity entity = response.getEntity();
				is = entity.getContent();
			} catch (Exception e) {
				Log.e(TAG, "Error in http connection " + e.toString());
			}

			// Convert response to string
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				is.close();
				result = sb.toString();
				// Log.i(TAG + ".result", result);
				return result;
			} catch (Exception e) {
				Log.e(TAG, "Error converting result " + e.toString());
				return null;
			}
		}

		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if (!isProgressHiding)
				if (progressDialog != null)
					progressDialog.dismiss();
			if (result != null)
				try {
					Log.e(TAG, result);
					asyncHttpResponseHandler.onSuccess(result);
				} catch (Exception e) {
					Log.e(TAG, "Must implement the interface " + e.toString());
				}
		}

	}
}

class AsyncUtils {

	public static final String DATA_ERROR = "Data Connection not available.";
	public static final String FIELD_ERROR = "This field is required";

	public static boolean isConnected(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo wifiNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (wifiNetwork != null && wifiNetwork.isConnected()) {
			return true;
		}

		NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mobileNetwork != null && mobileNetwork.isConnected()) {
			return true;
		}

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (activeNetwork != null && activeNetwork.isConnected()) {
			return true;
		}
		Toast.makeText(context, DATA_ERROR, Toast.LENGTH_SHORT).show();
		return false;
	}

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
}
