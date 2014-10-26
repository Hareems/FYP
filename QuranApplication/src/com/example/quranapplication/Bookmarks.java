package com.example.quranapplication;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;
import android.widget.SearchView;




import com.example.adapters.CustomListViewAdapterbookmarks;
import com.example.beansbookmarks.RowItembookmarks;
 
public class Bookmarks extends Activity implements
        OnItemClickListener {
	
	Activity ctx;
 
    public static final  String[] Surah_name = new String[] { "Surah Al-Fatiha", "Surah Al-Asr", "surah Al-Ikhlas"};
    public static final   String[]  Verses_from = new String[]{"10","20","30" };
    public static final String[] Till_verses = new String[]{"15","27","32" };
 
    ListView listView;
    List<RowItembookmarks> rowItems;
 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
    	ctx=this;
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookmark);
 
        rowItems = new ArrayList<RowItembookmarks>();
        for (int i = 0; i < Surah_name.length; i++) {
            RowItembookmarks item = new RowItembookmarks(Surah_name[i], Verses_from[i], Till_verses[i]);
            rowItems.add(item);
        }
 
        listView = (ListView) findViewById(R.id.list);
        CustomListViewAdapterbookmarks adapter = new CustomListViewAdapterbookmarks(this,
                R.layout.bookmark_list, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }
 
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
            long id) {
    	//move to next activity i.e ayat page
    	
    	        Intent act1 = new Intent(view.getContext(),StudentDashboardDesignActivity.class);
    	        startActivity(act1);
    	   
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bookmark_menu, menu);
     // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
 
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       
        switch (item.getItemId()) {
        case R.id.search:
        	
            // search action
            return true;
        case R.id.notification:
            // notification
            Notification();
            return true;
        case R.id.home:
        	Home();
            // home
            return true;
       
        default:
            return super.onOptionsItemSelected(item);
        }
    }
    private void Notification() {
        Intent i = new Intent(ctx, Notification.class);
        startActivity(i);
    }
    
    private void Home() {
        Intent i = new Intent(ctx, StudentDashboardDesignActivity.class);
        startActivity(i);
    }
    
  
}