package com.game;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class View extends SurfaceView{

	SurfaceHolder holder;
	
	public View(Context context) {
		super(context);
		holder = getHolder();
	}
	


}
