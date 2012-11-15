package core;


import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import nu.xom.Attribute;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.ParsingException;
import nu.xom.ValidityException;



public class PlayQWriter {
	
	private Document playlist;
	private String xml;
	
	public PlayQWriter() {
		xml = "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?><PlayQ mode=\"1\" order=\"0\" order_scope=\"0\"><ImagePath /><LastPlayed /><Items></Items></PlayQ>";
		Builder parser = new Builder(false);
		try {
			playlist = parser.build(xml, "");
		} catch (ValidityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParsingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void printDocument() {
		System.out.println(playlist.toXML());
	}
	
	public void buildXML(ArrayList<String> songs) {
		Element root = playlist.getRootElement();
		Element songlist = root.getFirstChildElement("Items");
		for (int i=0;i<songs.size();i++) {
			Element song = new Element("LocalAudio");
			String line = "/mnt/sdcard"+songs.get(i);
			Attribute name = new Attribute("id", line);
			song.addAttribute(name);
			songlist.appendChild(song);
		}
	}
	
	public void writeDocument(String name) {
		try {
			FileWriter fstream = new FileWriter(name);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(playlist.toXML());
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}