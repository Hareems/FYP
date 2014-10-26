package com.example.hareemaudio;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Context;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageSlide extends Activity {
	public int currentimageindex=0;
    Timer timer;
    TimerTask task;
    ImageView slidingimage;
    Button  play_button, pause_button;
    
    private boolean flag; //that's my variable

    int[] IMAGE_IDS = {R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) 
{
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
        final Handler mHandler = new Handler();
        addListenerOnButton1();
        addListenerOnButton2();
        // Create runnable for posting
        final Runnable mUpdateResults = new Runnable() {
            public void run() {
            	if(flag)
            		
                AnimateandSlideShow();

            }
        };

        int delay = 500; // delay for .5 sec.

        int period = 4000; // repeat every 4 sec.

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {

             mHandler.post(mUpdateResults);

        }

        }, delay, period);

}

    public void onClick(View v) {

        finish();
        android.os.Process.killProcess(android.os.Process.myPid());
      }
       private void AnimateandSlideShow() {

        slidingimage = (ImageView)findViewById(R.id.ImageView_id);
        slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);

        currentimageindex++;

      }

       //
       
   	// Button press play
   	
		public void addListenerOnButton1() {
	 
			final Context context = this;
	 
			play_button = (Button) findViewById(R.id.button1);
	 
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
	 
			pause_button = (Button) findViewById(R.id.button2);
	 
			pause_button.setOnClickListener(new OnClickListener() {
	 
				@Override
				public void onClick(View arg0) {
	 
				    flag=false; 
	 
				}
	 
			});
	 
		}
       //
		
		

       
      }
