package main.pulsebeat02.CSV_Reading.LoadtoArray.Import;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_Title {

	public static String[] getTitles(File file) { // Returns a String [] of titles for the first line of the CSV file
		
		// TODO Auto-generated method stub

		String [] titles = null; 
		
		Scanner scanner = null;
		
        try {

            scanner = new Scanner(file); // Get file
            
            titles = scanner.nextLine().replace(',',' ').split(""); // Get the strings from the titles
            
            
        } catch (FileNotFoundException e) { // If file is not found...
        	
            e.printStackTrace();
            
        }
        
        scanner.close(); // Close scanner
        
        return titles;
	    
	 }

	}
