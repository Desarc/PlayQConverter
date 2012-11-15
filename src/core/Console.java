package core;

import java.util.ArrayList;
import java.util.Scanner;



public class Console {
	
	
	
	
	public static void main(String args[]) {
		//System.out.println("Specify the input file name (.txt): ");
		Scanner in = new Scanner(System.in);
//		String inName = in.nextLine();
//		String inFilePath = "D:\\"+inName+".txt";
//		iTunesReader reader = new iTunesReader(inFilePath);
		ArrayList<String> songs = new ArrayList<String>();
//		while (reader.hasNextLine()) {
//			reader.readNextLine();
//			songs.add(reader.convertLine(reader.readNextLine()));
//		}

		
		System.out.println("Specify the input file name (.xml): ");
		String inName = in.nextLine();
		String inFilePath = "D:\\"+inName+".xml";
		iTunesXMLReader xmlReader = new iTunesXMLReader(inFilePath);
		songs = xmlReader.getList();
		PlayQWriter writer = new PlayQWriter();
		writer.buildXML(songs);
		System.out.println("Specify the output file name: ");
		String outName = in.nextLine();
		String outFilePath = "D:\\"+outName+".mpq";
		writer.writeDocument(outFilePath);

	}
}