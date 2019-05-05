package main.pulsebeat02.CSV_Reading.LoadtoArrayList.Import;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Read_Text {
	
	public ArrayList<Double[]> readData(File file) { // Returns a double [] ArrayList from the CSV file
		
	    ArrayList <String[]> content = new ArrayList<>(); // Make ArrayList
	    
	    try (BufferedReader br = new BufferedReader(new FileReader(file))) { // Create BufferedReader on file
	    	
	        String line = ""; // Temporary Line Holder (can be null)
	        
	        try {
	        	
				while ((line = br.readLine()) != null) { // Loops through file
					
				    content.add(line.split(",")); // Add each element to ArrayList
				    
				}
				
			} catch (IOException e) { // Just in case...
				
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			}
	        
	    } catch (FileNotFoundException e) { // If the file is not found...
	    	
	      e.printStackTrace();
	    	
	    } catch (IOException e1) { // Just in case...
	    	
			// TODO Auto-generated catch block
	    	
			e1.printStackTrace();
			
		}
	    
	    return getDoubleArrayList(content);
	    
	}
	
	private ArrayList<Double[]> getDoubleArrayList(ArrayList<String[]> stringArray) { // Returns a Double [] ArrayList converted from a String ArrayList
		
        ArrayList<Double[]> result = new ArrayList<Double[]>(); // Create new Double ArrayList
        
        for (String[] stringValue : stringArray) { // Use For-Each loop for each element
        	
            try {
            	
                // Convert String to Integer, and store it into integer array list.
            	
            	for (int i = 0; i < stringArray.size(); i++) { // For each element in the stringArray
            		
            		result.add(Integer.parseInt(stringValue[i]), null); // Add the new element and parse it into an Integer
            		
            	}
                
            } catch (NumberFormatException e) { // If the string [] ArrayList contains characters that aren't numerical...
            	
                e.printStackTrace();
                
            } 
            
        }    
        
        return result;
        
    }

}
