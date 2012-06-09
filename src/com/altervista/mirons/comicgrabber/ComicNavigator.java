package com.altervista.mirons.comicgrabber;

public interface ComicNavigator {
	
	public Strip next();
	
	public Strip next(int n);
	
	public Strip previous();
	
	public Strip previous(int n);
	
	public Strip latest();
	
	public Strip first();

}
