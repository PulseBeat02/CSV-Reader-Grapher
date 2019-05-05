package main.pulsebeat02.CSV_Reading.LoadtoArray.Export;

import java.io.BufferedWriter;
import java.io.IOException;

import main.pulsebeat02.Util.File_Printing;

public class ExportCSV {
	
	public static BufferedWriter export (double [][] array, String Filename) throws IOException {
		
		return File_Printing.writeArray(array, Filename); // Use Class to Export Array
		
	}

}
