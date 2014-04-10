package com.buitio.builtquery;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
public class QueryList extends Activity {

	private ListView conditionsListView;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(getResources().getString(R.string.conditions_title));
		setContentView(R.layout.activity_query_list_layout);
		this.getActionBar().setHomeButtonEnabled(true);
		
		conditionsListView =(ListView) findViewById(R.id.array_list_of_conditions);
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.row_query_list_layout,getResources().getStringArray(R.array.array_list_of_conditions));
		conditionsListView.setAdapter(arrayAdapter);

		conditionsListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				
				/**
				 * Starting activity to load BuiltObjects using selected query.
				 */
				startActivity( new Intent(QueryList.this,QueryResultListActivity.class).putExtra("itemClick", position));
			}
		});
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
