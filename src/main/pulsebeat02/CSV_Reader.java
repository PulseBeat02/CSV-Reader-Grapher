package main.pulsebeat02;

import java.io.File;

import main.pulsebeat02.Graphing.Graph_GUI;

// import main.pulsebeat02.Graphing.Graph;

public class CSV_Reader {

	public static void main(String[] args) {
		
		File testFile = new File("C:\\CSV Reader\\CSV_Reader\\src\\main\\pulsebeat02\\test.csv");
		
		Graph_GUI.main(args, testFile);
		
	}
	
}
