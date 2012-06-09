package com.altervista.mirons.comicgrabber;

import android.graphics.Bitmap;

public final class Strip {
	
	private Comic comic;
	private Bitmap image;
	private String title;
	private String id;
	
	public Strip(Comic comic, String title, Bitmap image, String id) {
		
		this.title = title;
		this.comic = comic;
		this.image = image;
		this.id = id;
	}
	
	
	public String getId() {
		return id;
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
