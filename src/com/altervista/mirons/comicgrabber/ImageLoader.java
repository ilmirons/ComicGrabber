package com.altervista.mirons.comicgrabber;


import java.io.IOException;

import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class ImageLoader {
	
	protected Bitmap getImage(URL url) throws IOException {
		return BitmapFactory.decodeStream(url.openConnection().getInputStream());
	}

}
