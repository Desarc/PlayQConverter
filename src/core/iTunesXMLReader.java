package core;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;
import nu.xom.ParsingException;
import nu.xom.ValidityException;



public class iTunesXMLReader {
	
	private Document playlist;
	private Builder builder;
	
	public iTunesXMLReader(String path) {
		File file = new File(path);
		builder = new Builder();
		try {
			playlist = builder.build(file);
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
	
	public ArrayList<String> getList() {
		ArrayList<String> songList = new ArrayList<String>();
		Elements e = playlist.getRootElement().getFirstChildElement("dict").getFirstChildElement("dict").getChildElements("dict");
		for (int i = 0; i < e.size(); i++) {
			Elements q = e.get(i).getChildElements();
			for (int j = 0; j < q.size(); j++) {
				if (q.get(j).getValue().equals("Location")) {
					String song = q.get(j+1).getValue().substring(32);
					//System.out.println(song);
					song = song.replace("%20", " ");
					songList.add(song);
				}
			}
		}
		return songList;
	}
}