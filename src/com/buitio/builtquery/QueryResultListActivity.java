package com.buitio.builtquery;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.buitio.builtquery.ViewHolder.QueryListViewHolder;
import com.raweng.built.BuiltError;
import com.raweng.built.BuiltObject;
import com.raweng.built.userInterface.BuiltListViewResultCallBack;
import com.raweng.built.userInterface.BuiltUIListViewController;

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
public class QueryResultListActivity extends Activity{

	private int item;
	private ProgressDialog progressDialog;
	
	/*
	 * Declaration of BuiltUIListViewController.
	 */
	private BuiltUIListViewController builtUIListViewController;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/*
		 * Initialization of BuiltUIListViewController object.
		 */
		builtUIListViewController = new BuiltUIListViewController(this, "task");
		
		/*
		 * Setting the BuiltUIListViewController layout to activity (Initialization of layout to activity).
		 */
		setContentView(builtUIListViewController.getLayout());
		
		setTitle(getResources().getString(R.string.query_result_title));
		this.getActionBar().setHomeButtonEnabled(true);
		
		item = getIntent().getExtras().getInt("itemClick");

		progressDialog = new ProgressDialog(this);
		progressDialog.setCancelable(false);
		progressDialog.setMessage(getResources().getString(R.string.pls_wait_msg));

		loadData();
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

	/**
	 * Check for set up of query.
	 */
	public void loadData(){

			progressDialog.show();
			
			switch (item) {
			case 0:
				
				/*
				 * Querying to loading list for load list in ascending order.
				 */
				builtUIListViewController.getBuiltQueryInstance().ascending("priority");
				loaddata(builtUIListViewController);
				break;

			case 1:
				
				/*
				 * Querying to loading list for load list in descending order.
				 */
				builtUIListViewController.getBuiltQueryInstance().descending("priority");
				loaddata(builtUIListViewController);
				break;

			case 2:

				/*
				 * Querying to loading list for search with specific condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().where("priority", 2);
				loaddata(builtUIListViewController);
				break;

			case 3:

				/*
				 * Querying to loading list for not equal condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().notEqualTo("priority", 2);
				loaddata(builtUIListViewController);
				break;

			case 4:

				/*
				 * Querying to loading list for less than condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().lessThan("priority", 4);
				loaddata(builtUIListViewController);
				break;

			case 5:

				/*
				 * Querying to loading list for greater than condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().greaterThan("priority", 2);
				loaddata(builtUIListViewController);
				break;

			case 6:

				/*
				 * Querying to loading list for less than equal condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().lessThanOrEqualTo("priority", 4);
				loaddata(builtUIListViewController);
				break;

			case 7:

				/*
				 * Querying to loading list for greater than equal condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().greaterThanOrEqualTo("priority", 2);
				loaddata(builtUIListViewController);
				break;

			case 8:

				/*
				 * Querying to loading list for contain in condition.
				 */
				Integer[] intContainedInValues = {2,3};
				builtUIListViewController.getBuiltQueryInstance().containedIn("priority", intContainedInValues);
				loaddata(builtUIListViewController);
				break;

			case 9:

				/*
				 * Querying to loading list for not contain in condition.
				 */
				Integer[] intnotContainedInValues = {2,3};
				builtUIListViewController.getBuiltQueryInstance().notContainedIn("priority", intnotContainedInValues);
				loaddata(builtUIListViewController);
				break;

			case 10:

				/*
				 * Querying to loading list for exists condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().exists("priority");
				loaddata(builtUIListViewController);
				break;

			case 11:

				/*
				 * Querying to loading list for not exists condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().doesNotExists("priority");
				loaddata(builtUIListViewController);
				break;

			case 12:

				/*
				 * Querying to loading list for matching regular expression condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().matches("name", "S", null);
				loaddata(builtUIListViewController);
				break;

			case 13:

				/*
				 * Querying to loading list for matching case-sensitive regular expression condition.
				 */
				builtUIListViewController.getBuiltQueryInstance().matches("name", "S", "i");
				loaddata(builtUIListViewController);
				break;

			case 14:

				/*
				 * Querying to loading list for only condition.
				 */
				ArrayList<String> keys = new ArrayList<String>();
				keys.add("name");
				builtUIListViewController.getBuiltQueryInstance().only(keys);
				loaddata(builtUIListViewController);
				break;

			case 15:

				/*
				 * Querying to loading list for except condition.
				 */
				ArrayList<String> keysExcept = new ArrayList<String>();
				keysExcept.add("priority");
				builtUIListViewController.getBuiltQueryInstance().except(keysExcept);
				loaddata(builtUIListViewController);
				break;

			case 16:

				/*
				 * Querying to loading list BuiltObjects after particular BuiltObject created.
				 */
				builtUIListViewController.getBuiltQueryInstance().afterUid("bltaf9aa6da85a0d49b");
				loaddata(builtUIListViewController);
				break;

			case 17:

				/*
				 * Querying to loading list BuiltObjects before particular BuiltObject created.
				 */
				builtUIListViewController.getBuiltQueryInstance().beforeUid("bltaf9aa6da85a0d49b");
				loaddata(builtUIListViewController);
				break;

			case 18:

				/*
				 * Querying to loading list with limited BuiltObjects.
				 */
				builtUIListViewController.setLimit(2);
				loaddata(builtUIListViewController);
				break;

			case 19:

				/*
				 * Querying to loading list with skipping starting 2 BuiltObject.
				 */
				builtUIListViewController.setSkip(2);
				loaddata(builtUIListViewController);
				break;

			default:
				break;

			}
	}

	public void loaddata(BuiltUIListViewController builtUIListViewController){
		
		/*
		 *  Calling load data 
		 */
		builtUIListViewController.loadData(new BuiltListViewResultCallBack() {

			private QueryListViewHolder holder;

			@Override
			public void onError(BuiltError error) {
				/// builtErrorObject contains more details of error.
				Toast.makeText(QueryResultListActivity.this, "Error "+error.getErrorMessage(), Toast.LENGTH_SHORT).show();
			}

			@Override
			public void onAlways() {
				
				/// write code here that user want to execute.
				/// regardless of success or failure of the operation.
				
				if(progressDialog.isShowing()){
					progressDialog.dismiss();
				}
			}

			@Override
			public int getViewTypeCount() {
				try{
					if(progressDialog.isShowing()){
						progressDialog.dismiss();
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				return 0;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent, BuiltObject builtObject) {
				
				if(progressDialog.isShowing()){
					progressDialog.dismiss();
				}
				///Inflating the row layout in list view.
				
				if(convertView == null){
					LayoutInflater inflater = LayoutInflater.from(QueryResultListActivity.this);
					convertView = inflater.inflate(R.layout.row_query_list_result, parent, false);
					holder = new QueryListViewHolder();
					holder.nameTextView = (TextView)convertView.findViewById(R.id.nameTextView);
					holder.priorityTextView = (TextView)convertView.findViewById(R.id.priorityTextView);
					convertView.setTag(holder);
				}else{
					holder = (QueryListViewHolder)convertView.getTag();
				}

				holder.populateView(builtObject);

				return convertView;
			}

			@Override
			public int getItemViewType(int position) {
				return 0;
			}
		});
	}

}
