package com.altervista.mirons.comicgrabber;

import android.graphics.Bitmap;

public final class Strip {
	
	private Comic comic;
	private Bitmap image;
	private String title;
	
	public Strip(Comic comic, String title, Bitmap image) {
		
		this.title = title;
		this.comic = comic;
		this.image = image;
	}


	public Comic getComic() {
		return comic;
	}
	
	public Bitmap getImage() {
		return image;
	}
	
	public String getTitle() {
		return title;
	}
	
	
}
