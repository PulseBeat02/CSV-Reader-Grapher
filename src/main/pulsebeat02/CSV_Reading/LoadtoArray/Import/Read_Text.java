package main.pulsebeat02.CSV_Reading.LoadtoArray.Import;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Read_Text {
	
	public static double[][] getDoublesCSV(File file) {
		
		int rows = 0; // Number of Rows
		
		Scanner scanner = null; // File Scanner

		try {
			
			rows = (int) getRows(file); // Rows must be Integer
			
		} catch (IOException e1) {
			
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
			
		}
		
		double [][] values = new double [Read_Title.getTitles(file).length][rows]; // Make double array from CSV file
		
		try {

            scanner = new Scanner(file); // Properly initialize Scanner
            scanner.nextLine(); // Skip First Line because it contains titles
            
            while (scanner.hasNextLine()) { // Loops till the end of the file
            	
                String [] CSVline = scanner.nextLine().replace(',',' ').split(""); // Gets Each Element in the current CSV line
                
                int currentRow = 0; // Current Row of Looping
                
                double [] line = new double [CSVline.length]; // Make double array
                
                for (int z = 0; z < CSVline.length; z++) { // Loop through each element of CSVline
                	
                	line[z] = Integer.parseInt(CSVline[z]); // Turn the string number into a double
                	
                }
                
                for (int i = 0; i < values.length; i++) { // Loop through the finalized values array
                	
                	line[i] = values[i][currentRow]; // Add the current line array values to the original 2d Values array
                	currentRow++;
                	
                }
                
                
            }
            
        } catch (FileNotFoundException e) { // If file not found...
        	
            e.printStackTrace();
            
        }
		
		scanner.close(); // Close Scanner
		
		return values;
		
	}
	
	public static double getRows (File file) throws IOException { // Returns the number of rows in a file
		
	    LineNumberReader reader = null;
	    
	    try {
	    	
	        reader = new LineNumberReader(new FileReader(file)); // Get file
	        
	        while ((reader.readLine()) != null); // Loops until end of file
	        
	        return reader.getLineNumber();
	        
	    } catch (Exception ex) { // Check just in case for errors
	    	
	        return -1;
	        
	    } finally { 
	    	
	        if (reader != null) { // When reached the end of the file
	        	
	            reader.close(); // Close reader
	            
	        }
	        
	    }
	    
	}

}
