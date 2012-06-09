package com.altervista.mirons.comicgrabber;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.graphics.Bitmap;
import android.util.Log;

public final class PhdComic extends Comic implements ComicNavigator {

	private static final String TAG = "PhdComic";
	private int currentId;
	
	public PhdComic() {
		COMIC_AUTHOR = "Jorge Cham";
		COMIC_TITLE = "PhD - Piled Higher and Deeper";
		BASE_ADDR = "http://www.phdcomics.com/comics/archive.php?comicid=%d";
		CURRENT_ADDR = "http://www.phdcomics.com/comics.php";
	}
	
	private Strip get (int id) {

		String urlString = null;
		try {
			
			urlString = String.format(BASE_ADDR, id);
			URL url = new URL(urlString);
			currentId = id;
			return getStripFromUrl(url);

		} catch (MalformedURLException e) {
			Log.e(TAG, "Malformed URL: " + urlString, e);
		} catch (Exception e) {
			Log.e(TAG, "Error in parsing page " + CURRENT_ADDR, e);
		}
		return null;
	}


	private Strip getStripFromUrl(URL url) throws IOException,
			SAXException, ParserConfigurationException, MalformedURLException {
		Bitmap image;
		String stripTitle = "";
		Document rawPage = getWWWPage(url);
		NodeList links = rawPage.getElementsByTagName( "link" );
		NodeList metas = rawPage.getElementsByTagName("meta");
		
		for (int i = 0; i < metas.getLength(); i++) {
			
			Element e = (Element) metas.item(i);
			
			if (e.getAttribute("name").equals("title") ) {
				stripTitle = e.getAttribute("content");
			}	
		}
		Element link = (Element) links.item(0);
		image = getImage(new URL(link.getAttribute("href")));
		
		return new Strip(this, stripTitle, image);
	}

	public Strip next() {
		return get(++currentId);
	}

	public Strip next(int n) {
		return get(currentId += n);
	}

	public Strip previous() {
		return get(currentId -= 1);
	}

	public Strip previous(int n) {
		return get(currentId -= n);
	}

	public Strip latest() {
		try {
			return getStripFromUrl(new URL(CURRENT_ADDR));
		} catch (MalformedURLException e) {
			Log.e(TAG, "Malformed URL: " + CURRENT_ADDR, e);
		} catch (Exception e) {
			Log.e(TAG, "Error in parsing page " + CURRENT_ADDR, e);
		}
		return null;
	}

	public Strip first() {
		currentId = 1;
		return get(currentId);
	}

}
