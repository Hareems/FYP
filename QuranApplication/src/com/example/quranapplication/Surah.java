package com.example.quranapplication;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.constant.AppPrefs;
import com.constant.AsyncHttpClient;
import com.constant.AsyncHttpClient.AsyncHttpResponseHandler;
import com.constant.Utils;

public class Surah extends Activity {

	ListView listview;
	ArrayList<String> list;
	AsyncHttpClient async;
	Activity ctx;
	ArrayAdapter<String> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.surah);
		async = new AsyncHttpClient();
		listview = (ListView) findViewById(R.id.listview);
		list = new ArrayList<String>();
		ctx = this;
		GetData();
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapterView, View view,
					int arg2, long arg3) {

				Log.e(arg2 + "", "" + list.get(arg2).toString());
				Toast.makeText(ctx, "" + list.get(arg2).toString(),
						Toast.LENGTH_SHORT).show();

			}
		});
		

	}

	private void GetData() {
		// TODO Auto-generated method stub
		try {
			if (Utils.isConnected(ctx)) {
				async.execute(ctx, "", AppPrefs.BASE_URL + "Surrah", null,
						new AsyncHttpResponseHandler() {

							@Override
							public void onSuccess(String response) {
								// TODO Auto-generated method stub
								try {
									JSONArray jsonarr = new JSONArray(response);
									for (int i = 0; i < jsonarr.length(); i++) {

										JSONObject jobj = jsonarr
												.getJSONObject(i);
										String surahname = jobj
												.getString("SurrahName");

										list.add(surahname);

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
