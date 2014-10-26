
package com.example.hareemaudio;

import com.example.hareemaudio.Loading;

import java.util.ArrayList;
import com.example.hareemaudio.MainActivity;
import com.example.hareemaudio.MyOnItemSelectedListener;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinersActivity extends Activity {

  private Spinner spinner1, spinner2, spinner3, spinner4; 
  private Button button;
protected Context context;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.spinner);
	
	addItemsOnSpinner1();
	addItemsOnSpinner2();
	addItemsOnSpinner3();
	addItemsOnSpinner4();
	addListenerOnButton();
	
	
  }
  
  
  // add items into spinner 1 dynamically (Ayat to)
  public void addItemsOnSpinner1() {

	spinner1 = (Spinner) findViewById(R.id.spinner1);
	List list = new ArrayList();
	list.add("1");
	list.add("2");
	list.add("3");
	list.add("4");
	list.add("5");
	list.add("6");
	list.add("7");
	list.add("8");
	list.add("9");
	list.add("10");
	ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner1.setAdapter(dataAdapter);
  }
  
  
 

  // add items into spinner2 dynamically(Ayat from)
  public void addItemsOnSpinner2() {

	spinner2 = (Spinner) findViewById(R.id.spinner2);
	List list = new ArrayList();
	list.add("1");
	list.add("2");
	list.add("3");
	list.add("4");
	list.add("5");
	list.add("6");
	list.add("7");
	list.add("8");
	list.add("9");
	list.add("10");
	ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner2.setAdapter(dataAdapter);
  }
  
  
//add items into spinner3 dynamically(Repeat Spinner)
  public void addItemsOnSpinner3() {

		spinner3 = (Spinner) findViewById(R.id.spinner3);
		List list = new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		list.add("6");
		list.add("7");
		list.add("8");
		list.add("9");
		list.add("10");
		ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner3.setAdapter(dataAdapter);
	  }
  // add items into spinner4 dynamically(Surah spinner)
  public void addItemsOnSpinner4() {

	spinner4 = (Spinner) findViewById(R.id.spinner4);
	List list = new ArrayList();
	list.add("Fatiha");
	list.add("Al-Asr");
	list.add("Al-Feel");
	list.add("Quresh");
	list.add("Naas");
	list.add("Al-Humaza");
	list.add("Al-Fajr");
	list.add("Ash-Shams");
	list.add("An-Nasr");
	list.add("Al-Falaq");
	list.add("At-Tin ");
	list.add("An-Nazi'aat ");
	list.add("Al-Kaafiroon ");
	list.add(" Al-Ikhlaas ");
	list.add(" Al-Masad");
	list.add("Al-Alaq ");
	list.add(" Ash-Shams ");
	ArrayAdapter dataAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	spinner4.setAdapter(dataAdapter);
  }

 
  public void addListenerOnButton() {

	spinner1 = (Spinner) findViewById(R.id.spinner1);
	spinner2 = (Spinner) findViewById(R.id.spinner2);
	spinner3 = (Spinner) findViewById(R.id.spinner3);
	spinner4 = (Spinner) findViewById(R.id.spinner4);
	button = (Button) findViewById(R.id.button1);

	button.setOnClickListener(new OnClickListener() {

	  @Override
	  public void onClick(View v) {

	    Toast.makeText(SpinersActivity.this,
		"Successfuly Set : " + 
                "\nAyat To: "+ String.valueOf(spinner1.getSelectedItem()) + 
                "\nAyat From : "+ String.valueOf(spinner2.getSelectedItem()) +
                "\nRepeatation : "+ String.valueOf(spinner3.getSelectedItem()),
			Toast.LENGTH_SHORT).show();
	  
	  
	}  
	  
	  public void sendMessage(View v) 
	  {
		  Intent intent = new Intent(context, Loading.class);
          startActivity(intent); 
	     ;
	  } 
	  
	 
	  

	});
	
	//Loading Activity start on button press (progress Dialog box)

    /*Intent intent = new Intent(context, Loading.class);
                startActivity(intent); 
                
                 Intent intent = new Intent(SpinersActivity.this, Loading.class);
	      startActivity(intent)*/
	
  }
}
