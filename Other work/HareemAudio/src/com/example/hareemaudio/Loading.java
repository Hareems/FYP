package com.example.hareemaudio;

import com.example.hareemaudio.SpinersActivity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.PopupWindow;
import android.app.ProgressDialog;
import android.view.View.OnClickListener;
import android.os.Handler;
import android.os.Message;




public class Loading extends Activity {
	 Button button;
	 ProgressDialog progressDoalog ;

	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.spinner);
	  button = (Button) findViewById(R.id.button1);
	  button.setOnClickListener(new OnClickListener() {
	   // @Override
	    public void onClick(View v) {
	      progressDoalog = new ProgressDialog(Loading.this);
	      progressDoalog.setMax(100);
	      progressDoalog.setMessage("Its loading....");
	      progressDoalog.setTitle("Preparing your Audio Selection");
	      progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	      progressDoalog.show();
	      new Thread(new Runnable() {
	        @Override
	        public void run() {
	                        try {
	     while (progressDoalog.getProgress() <= progressDoalog
	    .getMax()) {
	       Thread.sleep(400);
	       handle.sendMessage(handle.obtainMessage());
	       if (progressDoalog.getProgress() == progressDoalog
	    .getMax()) {
	         progressDoalog.dismiss();
	       }
	     }
	          } catch (Exception e) {
	     e.printStackTrace();
	   }
	        }
	      }).start();
	    }

	    Handler handle = new Handler() {
	    @Override
	      public void handleMessage(Message msg) {
	        super.handleMessage(msg);
	        progressDoalog.incrementProgressBy(1);
	      }
	    };
	  });
	 }}
	        