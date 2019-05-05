package main.pulsebeat02.CSV_Reading.LoadtoArrayList.Export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportCSV {
	
	public static void createFile(String file, ArrayList<String> arrData) { // Creates a file from a String ArrayList
		
        FileWriter writer = null; // Temporarily Initialize Writer
        
		try {
			
			writer = new FileWriter(file + ".csv"); // Make file
			
		} catch (IOException e) { // Just in case...
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		}
        
        int size = arrData.size(); // Define size of arrayList
        
        for (int i = 0; i < size; i++) { // Loop through each Element
        	
            String str = arrData.get(i).toString(); // Turn it into String
            
            try {
            	
				writer.write(str); // Write it
				
			} catch (IOException e1) { // Just in case...
				
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
				
			}
            
            if (i < size - 1) { // **This prevent creating a blank like at the end of the file**
            
                try {
                	
					writer.write("\n"); // Write next line
					
				} catch (IOException e) { // Just in Case...
					
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					
				}
                
            }
            
        }
        
        try {
        	
			writer.close(); // Close Writer
			
		} catch (IOException e) { // Just in Case
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			
		}
        
    }

}
