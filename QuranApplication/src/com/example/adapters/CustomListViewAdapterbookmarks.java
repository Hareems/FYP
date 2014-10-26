package com.example.adapters;

import java.util.List;
import com.example.quranapplication.R;
import com.example.beansbookmarks.RowItembookmarks;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
public class CustomListViewAdapterbookmarks extends ArrayAdapter<RowItembookmarks> {
 
    Context context;
 
    public CustomListViewAdapterbookmarks(Context context, int resourceId,
            List<RowItembookmarks> items) {
        super(context, resourceId, items);
        this.context = context;
    }
     
    /*private view holder class*/
    private class ViewHolder {
        
        TextView surah_name;
        TextView verses;
        TextView till_verses;
    }
     
    @Override
	public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        RowItembookmarks rowItem = getItem(position);
         
        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.bookmark_list, null);
            holder = new ViewHolder();
            holder.surah_name = (TextView) convertView.findViewById(R.id.surah_name);
            holder.verses = (TextView) convertView.findViewById(R.id.verses);
            holder.till_verses = (TextView) convertView.findViewById(R.id.till_verses);
            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();
                 
        holder.surah_name.setText(rowItem.getSurah_name());
        holder.verses.setText(rowItem.getVerses());
        holder.till_verses.setText(rowItem.getTill_Verses());
         
        return convertView;
    }
}