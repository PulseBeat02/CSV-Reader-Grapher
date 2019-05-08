package main.pulsebeat02.CSV_Reading.LoadtoArray.Import;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Read_Text {
	
	static int currentRow = -1;
	
	public static double[][] getDoublesCSV (File file) {
		
		int rows = 0; // Number of Rows

		Scanner scanner = null;
		
		try {
			
			scanner = new Scanner(file);
			
		} catch (FileNotFoundException e1) {
			
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
			
		} // File Scanner
		
		int numbersCount = charCountinString(scanner.nextLine(), ',') + 1;

		rows = (int) getRows(file); // Rows must be Integer
		
		// int tempLineLength = scanner.nextLine().replace(',',' ').split(" ").length;
		
		double [][] values = new double [rows][numbersCount]; // Make double array from CSV file
		
		try {
       
//            scanner.nextLine(); // Skip First Line because it contains titles
            
            while (scanner.hasNextLine()) { // Loops till the end of the file
            	
            	currentRow++;
            	
                String [] CSVline = scanner.nextLine().replace(',',' ').split(" "); // Gets Each Element in the current CSV line
                
                double [] line = new double [CSVline.length]; // Make double array
                
                for (int z = 0; z < CSVline.length; z++) { // Loop through each element of CSVline
                		
                		line[z] = Double.parseDouble(CSVline[z]); // Turn the string number into a double 
                	
                }

                for (int i = 0; i < values[0].length; i++) { // Loop through the finalized values array 
                	
                	values[currentRow][i] = line[i]; // Add the current line array values to the original 2d Values array
                	
//                	if (i % currentRow == 2) {
//                		
//                		currentRow++;
//                		
//                	}
                	
                }
                
                
            }
            
        }
		
		finally {
			
			scanner.close(); // Close Scanner
			
		}
		
		
		
		return values;
		
	}
	
	public static double getRows (File file) { // Returns the number of rows in a file
		
	    LineNumberReader reader = null;
	    
	    try {
	    	
	        reader = new LineNumberReader(new FileReader(file)); // Get file
	        
	        while ((reader.readLine()) != null); // Loops until end of file
	        
	        return reader.getLineNumber();
	        
	    } catch (Exception ex) { // Check just in case for errors
	    	
	        return -1;
	        
	    } finally { 
	    	
	        if (reader != null) { // When reached the end of the file
	        	
	            try {
	            	
					reader.close();
					
				} catch (IOException e) {
					
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					
				} // Close reader
	            
	        }
	        
	    }
	    
	}
	
	public static int charCountinString (String str, char c) {
		
		int charCount = 0;
		
		for (int i = 0; i < str.length(); i++) {
		    
		    if (str.charAt(i) == c) {
		    	
		    	charCount++;
		    	
		    }
		    
		    
		}
		
		return charCount;
		
	}

}
