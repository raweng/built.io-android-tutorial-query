package com.buitio.builtquery.ViewHolder;

import android.util.Log;
import android.widget.TextView;

import com.raweng.built.BuiltObject;

/**
 * This is built.io android tutorial.
 * 
 * Short introduction of some classes with some methods.
 * Contain classes: 
 * 1. BuiltQuery
 * 
 * For quick start with built.io refer "http://docs.built.io/quickstart/index.html#android"
 * 
 * @author raw engineering, Inc
 *
 */
public class QueryListViewHolder {


	public TextView nameTextView;
	public android.widget.TextView priorityTextView;

	public void populateView(BuiltObject builtObject) {
		
		/*
		 * Extracting the data from builtObject instance.
		 */
		if(builtObject.has("name")){
			nameTextView.setText((String)builtObject.get("name"));
		}

		if(builtObject.has("priority")){
            priorityTextView.setText("Priority : "+ builtObject.getInt("priority"));
		}
	}

}
