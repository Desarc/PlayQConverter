package core;

import java.io.*;
import java.util.Scanner;



public class iTunesReader {
	
	private FileReader playlist;
	private Scanner scan;
	private char whitespace;
	
	public final static String LIBPATH = "D:\\Music\\iTunes";
	public final static String EXT = ".mp3";
	
	public iTunesReader(String path) {
		File file = new File(path);
		try {
			playlist = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scan = new Scanner(playlist);
		whitespace = readNextLine().charAt(3);
	}
	
	public void printNextLine() {
		System.out.println(scan.nextLine());
	}
	
	public String readNextLine() {
		return(scan.nextLine());
	}
	
	public String convertLine(String origLine) {
		char x = origLine.charAt(0);
		String convLine = "";
		for (int j=0;j<origLine.length();j++) {
			if (origLine.charAt(j) != whitespace) {
				convLine += origLine.charAt(j);
			}
		}
		String fileName = "";
		int start = convLine.indexOf(LIBPATH);
		int end = convLine.indexOf(EXT);
		if (start > 0 && end > 0) {
			fileName = convLine.substring(start+15, end)+EXT;
			fileName = fileName.replace('\\', '/');
		}
		return fileName;
	}
	public boolean hasNextLine() {
		return scan.hasNextLine();
	}
}