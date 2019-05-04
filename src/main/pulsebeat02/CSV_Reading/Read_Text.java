package main.pulsebeat02.CSV_Reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Read_Text {
	
	public static int[][] getIntsCSV(File file) {
		
		int rows = 0;
		
		Scanner scanner = null;

		try {
			
			rows = getRows(file);
			
		} catch (IOException e1) {
			
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
			
		}
		
		int [][] values = new int [Read_Title.getTitles(file).length][rows];
		
		try {

            scanner = new Scanner(file);
            scanner.nextLine();
            
            while (scanner.hasNextLine()) {
            	
                String [] CSVline = scanner.nextLine().replace(',',' ').split("");
                
                int currentRow = 0;
                
                int [] line = new int [CSVline.length];
                
                for (int z = 0; z < CSVline.length; z++) {
                	
                	line[z] = Integer.parseInt(CSVline[z]);
                	
                }
                
                for (int i = 0; i < values.length; i++) {
                	
                	line[i] = values[i][currentRow];
                	currentRow++;
                	
                }
                
                
            }
            
        } catch (FileNotFoundException e) {
        	
            e.printStackTrace();
            
        }
		
		scanner.close();
		
		return values;
		
		
		
	}
	
	public static int getRows (File file) throws IOException {
		
	    LineNumberReader reader = null;
	    
	    try {
	    	
	        reader = new LineNumberReader(new FileReader(file));
	        
	        while ((reader.readLine()) != null);
	        
	        return reader.getLineNumber();
	        
	    } catch (Exception ex) {
	    	
	        return -1;
	        
	    } finally { 
	    	
	        if (reader != null) 
	        	
	            reader.close();
	        
	    }
	    
	}

}
