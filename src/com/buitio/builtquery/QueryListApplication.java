package com.buitio.builtquery;

import android.app.Application;

import com.raweng.built.Built;

public class QueryListApplication extends Application{

/**
 * This is built.io android tutorial.
 * 
 * Short introduction of some classes with some methods.
 * Contain classes: 1.BuiltInstallation
 * 
 * For quick start with built.io refer "http://docs.built.io/quickstart/index.html#android"
 * For GCM concept refer "http://developer.android.com/google/gcm/gcm.html"
 * 
 * @author raw engineering, Inc
 *
 */
	@Override
	public void onCreate() {
		super.onCreate();
		/*
		 * Initialize the application for a project using built.io Application credentials "Application Api Key" 
		 * and "Application UID".
		 * 
		 */
		try {
			Built.initializeWithApiKey(this, "bltab290b02890b2dea", "built_query_demo");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
