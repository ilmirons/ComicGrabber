package com.altervista.mirons.comicgrabber;

import android.graphics.Bitmap;

public interface ComicNavigator {
	
	public Bitmap next();
	
	public Bitmap next(int n);
	
	public Bitmap previous();
	
	public Bitmap previous(int n);
	
	public Bitmap latest();
	
	public Bitmap first();

}
