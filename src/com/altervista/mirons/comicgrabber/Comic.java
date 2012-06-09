package com.altervista.mirons.comicgrabber;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public abstract class Comic {
	
	protected String COMIC_TITLE;
	protected String COMIC_AUTHOR;
	protected String BASE_ADDR;
	protected String CURRENT_ADDR;
	protected String currentStripTitle;
	
	
	public static Document readXml(InputStream is) throws SAXException, IOException,
	ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		dbf.setValidating(false);
		dbf.setIgnoringComments(true);
		dbf.setIgnoringElementContentWhitespace(true);
		dbf.setNamespaceAware(false);

		DocumentBuilder db = null;
		db = dbf.newDocumentBuilder();
		db.setEntityResolver(new EntityResolver () {
		  public InputSource resolveEntity(String publicId, String systemId) throws SAXException,
		      IOException {
		    return new InputSource(new StringReader(""));
		  }
		});

		// db.setErrorHandler( new MyErrorHandler());

		return db.parse(is);
	}
	
	
	
	protected Bitmap getImage(URL url) throws IOException {
		return BitmapFactory.decodeStream(getWWWResource(url));
	}
	
	
	public String getComicTitle() {
		return COMIC_TITLE;
	}
	
	public String getAuthor(){
		return COMIC_AUTHOR;
	}
	
	public Document getWWWPage (URL url) throws IOException, SAXException, ParserConfigurationException {
		return readXml(getWWWResource(url));
	}
	
	public InputStream getWWWResource (URL url) throws IOException {
		return url.openConnection().getInputStream();
	}
	
	
}
