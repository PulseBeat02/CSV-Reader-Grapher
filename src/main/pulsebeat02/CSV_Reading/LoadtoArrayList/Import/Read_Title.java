package main.pulsebeat02.CSV_Reading.LoadtoArrayList.Import;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read_Title {
	
public static ArrayList<String> getTitles(File file) { // Returns a String ArrayList of titles from the first line
		
		// TODO Auto-generated method stub

		ArrayList<String> titles = new ArrayList<String>(); // Create ArrayList
		
		Scanner scanner = null; // Initialize Scanner
		
        try {

            scanner = new Scanner(file); // Get File
            
            String tmp = scanner.nextLine(); // Temporary line
            
            int commas = 0; // Count commas
            
            for (int i = 0; i < tmp.length(); i++) { // Loops through the line
            	
                if (tmp.charAt(i) == ',') { // If the line contains ','
                	
                	commas++; // Commas++
                	
                }
                
            }
            
            for (int z = 0; z < commas + 1; z++) {
            	
            	String [] titleElement = scanner.nextLine().replace(',',' ').split(""); // Turn line into array of string elements
            	
            	for (int u = 0; u < titleElement.length; u++) { // Loops through the line array
            		
            		titles.add(titleElement[u]); // Add it into the ArrayList
            		
            	}
            	
            }
            
        } catch (FileNotFoundException e) { // If file was not found...
        	
            e.printStackTrace();
            
        }
        
        scanner.close(); // Close scanner
        
        return titles;
	    
	 }

}
