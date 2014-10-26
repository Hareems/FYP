package com.example.quranapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
public class Settings extends Activity {

	private String[] repetation= {"1","2","3","4","5"};
	Spinner spnr,spnr2, spnr3, spnr4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
    spnr = (Spinner)findViewById(R.id.surah);
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
        this, android.R.layout.simple_spinner_item, repetation);
    spnr.setAdapter(adapter);
    spnr.setOnItemSelectedListener(
            new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> arg0, View arg1,
                        int arg2, long arg3) {
                  int position = spnr.getSelectedItemPosition();
                  Toast.makeText(getApplicationContext(),"You have selected "+repetation[+position],Toast.LENGTH_LONG).show();
                    // TODO Auto-generated method stub
                }
                @Override
                public void onNothingSelected(AdapterView<?> arg0) {
                    // TODO Auto-generated method stub
                }
            }
        );
    spnr2 = (Spinner)findViewById(R.id.repeat);
       ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, repetation);
    spnr2.setAdapter(adapter2);
    spnr2.setOnItemSelectedListener(
              new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> arg0, View arg1,
                          int arg2, long arg3) {
                    int position = spnr2.getSelectedItemPosition();
                    Toast.makeText(getApplicationContext(),"You have selected "+repetation[+position],Toast.LENGTH_LONG).show();
                      // TODO Auto-generated method stub
                  }
                  @Override
                  public void onNothingSelected(AdapterView<?> arg0) {
                      // TODO Auto-generated method stub
                  }
              }
          );
    spnr3 = (Spinner)findViewById(R.id.from);
      ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, repetation);
    spnr3.setAdapter(adapter3);
    spnr3.setOnItemSelectedListener(
              new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> arg0, View arg1,
                          int arg2, long arg3) {
                    int position = spnr3.getSelectedItemPosition();
                    Toast.makeText(getApplicationContext(),"You have selected "+repetation[+position],Toast.LENGTH_LONG).show();
                      // TODO Auto-generated method stub
                  }
                  @Override
                  public void onNothingSelected(AdapterView<?> arg0) {
                      // TODO Auto-generated method stub
                  }
              }
          );
    spnr4 = (Spinner)findViewById(R.id.to);
    ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(
            this, android.R.layout.simple_spinner_item, repetation);
    spnr4.setAdapter(adapter4);
    spnr4.setOnItemSelectedListener(
              new AdapterView.OnItemSelectedListener() {
                  @Override
                  public void onItemSelected(AdapterView<?> arg0, View arg1,
                          int arg2, long arg3) {
                    int position = spnr4.getSelectedItemPosition();
                    Toast.makeText(getApplicationContext(),"You have selected "+repetation[+position],Toast.LENGTH_LONG).show();
                      // TODO Auto-generated method stub
                  }
                  @Override
                  public void onNothingSelected(AdapterView<?> arg0) {
                      // TODO Auto-generated method stub
                  }
              }
          );
  }
    
}
