package com.example.hareemaudio;

import com.example.hareemaudio.R;
import com.example.hareemaudio.SpinersActivity;
import android.app.Activity;
//import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {
	
		/** For player */
	
	ImageButton play_button, pause_button, more_button;
	SeekBar seek_bar;
	MediaPlayer player;
	TextView text_shown;
	Handler seekHandler = new Handler();
	

		/** For Image Slidshow. */
	  
	public int currentimageindex=0;
	Timer timer;
	TimerTask task;
	ImageView slidingimage;
	private boolean flag; //that's my variable

	    int[] IMAGE_IDS = {
	    		R.drawable.image1, R.drawable.image2, R.drawable.image3,

	    		R.drawable.image4,R.drawable.image5,R.drawable.image6,
	    		R.drawable.image7};
	  //player    
	    
	   //slider handler
	   // private final Handler handler = new Handler();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		final Handler mHandler = new Handler();
	        addListenerOnButton1();
	        addListenerOnButton2();
		//btnPlay.setClickable(true);
		//btnPlay.setEnabled(true);
		
		getInit();
		seekUpdation();
		addListenerOnButton();
		
		 
		
		
		//yaha se
		
		 
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
            	if(flag)
                AnimateandSlideShow();

            }
        };

        int delay = 1000; // delay for 1 sec.

        int period = 8000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {

             mHandler.post(mUpdateResults);

        }

        }, delay, period);

    }

    
       private void AnimateandSlideShow() {

        slidingimage = (ImageView)findViewById(R.id.ImageView_id);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);

        currentimageindex++;

      }

	

	public void getInit() {
		seek_bar = (SeekBar) findViewById(R.id.audioProgressBar);
		play_button = (ImageButton) findViewById(R.id.play_button);
		pause_button = (ImageButton) findViewById(R.id.pause_button);
		text_shown = (TextView) findViewById(R.id.text_shown);
		play_button.setOnClickListener(this);
		pause_button.setOnClickListener(this);
		player = MediaPlayer.create(this, R.raw.fatiha); //ye wo Audio file hai jo chalarae
		seek_bar.setMax(player.getDuration());
		flag=false; 
	}

	Runnable run = new Runnable() {

		@Override
		public void run() {
			seekUpdation();
		}
	};

	// Button press (more) to change the screen(spinners ajaege)
	
		public void addListenerOnButton() {
	 
			final Context context = this;
	 
			more_button = (ImageButton) findViewById(R.id.more_button);
	 
			more_button.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
	 
				    Intent intent = new Intent(context, SpinersActivity.class);
	                            startActivity(intent);   
	 
				}
	 
			});
	 
		}
	
	public void seekUpdation() {

		seek_bar.setProgress(player.getCurrentPosition());
		seekHandler.postDelayed(run, 1000);
	}

	/** yaha pe abi play/pause button k enable disable ka function lagaugi */
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		
		case R.id.play_button:
			
			/*buttonPlay.setEnabled(false);
			buttonPause.setEnabled(true);/*
			
					//or
			
			/*View button = findViewById(R.id.btnPlay);
	           button.setVisibility(View.GONE);
			 * */
			//text_shown.setText("Playing...");
		 
			
			
			player.start(); // Start playing Audio
			addListenerOnButton1(); // slide images
            
			break;
			
		case R.id.pause_button:
			player.pause();  //Pause Audio
			//text_shown.setText("Paused...");
			
            addListenerOnButton2(); // stop slide images 
            
		}

	}
	
    
	// Button press play
	
		public void addListenerOnButton1() {
	 
			final Context context = this;
	 
			play_button = (ImageButton) findViewById(R.id.play_button);
	 
			play_button.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
	 
				    flag=true; 
	 
				}
	 
			});
	 
		}
    //
		
		
		//button press pause

		public void addListenerOnButton2() {
	 
			final Context context = this;
	 
			pause_button = (ImageButton) findViewById(R.id.pause_button);
	 
			pause_button.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
	 
				    flag=false; 
	 
				}
	 
			});
	 
		}
    //
		
	
}


