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

public final class PhdComic extends Comic implements ComicNavigator {

	int currentId;
	Strip current;
	int relativePos = 0;
	
	public PhdComic() {
		COMIC_AUTHOR = "Jorge Cham";
		COMIC_TITLE = "PhD - Piled Higher and Deeper";
		BASE_ADDR = "http://www.phdcomics.com/comics/archive.php?comicid=%d";
		CURRENT_ADDR = "http://www.phdcomics.com/comics.php";
		current = latest();
	}
	
	
	 private Strip get (int id) {
		 
		 try {
			Document rawPage = getWWWPage(new URL(String.format(BASE_ADDR, id)));
			
			NodeList links = rawPage.getElementsByTagName( "link" );
			NodeList metas = rawPage.getElementsByTagName("meta");
			
			for (int i = 0; i < metas.getLength(); i++) {
				
				Element e = (Element) metas.item(i);
				
				if (e.getAttribute("description").equals("title") ) {
					// TODO
				}
				
			}
		    
		    // for every link tag
		    Element link = (Element) links.item(0);
		    Bitmap image = getImage(new URL(link.getAttribute("href")));
		    
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return null;
	}

	public Strip next() {
		return null;
	}

	public Strip next(int n) {
		return null;
	}

	public Strip previous() {
		return null;
	}

	public Strip previous(int n) {
		return null;
	}

	public Strip latest() {
		return null;
	}

	public Strip first() {
		return null;
	}

}
