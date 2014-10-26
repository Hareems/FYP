package com.example.quranapplication;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.constant.AppPrefs;
import com.constant.AsyncHttpClient;
import com.constant.AsyncHttpClient.AsyncHttpResponseHandler;
import com.constant.Utils;

public class Receiter extends Activity {

	ListView listview;
	ArrayList<String> list;
	AsyncHttpClient async;
	Activity ctx;
	ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.receiter);

		listview = (ListView) findViewById(R.id.listview);
		list = new ArrayList<String>();
		ctx = this;

		try {
			if (Utils.isConnected(ctx)) {
				async.execute(ctx, "", AppPrefs.BASE_URL + "Reciter", null,
						new AsyncHttpResponseHandler() {

							@Override
							public void onSuccess(String response) {
								// TODO Auto-generated method stub
								try {
									JSONArray jsonarr = new JSONArray(response);
									for (int i = 0; i < jsonarr.length(); i++) {

										JSONObject jobj = jsonarr
												.getJSONObject(i);
										String recitername = jobj
												.getString("ReciterName");

										list.add(recitername);

										adapter = new ArrayAdapter<String>(
												ctx,
												android.R.layout.simple_list_item_1,
												list);
										listview.setAdapter(adapter);

									}

								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							}
						});

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
