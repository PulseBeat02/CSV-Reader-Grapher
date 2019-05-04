package main.pulsebeat02.CSV_Reading;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Read_Title {

	public static String[] getTitles(File file) {
		
		// TODO Auto-generated method stub

		String [] titles = null;
		
		Scanner scanner = null;
		
        try {

            scanner = new Scanner(file);
            
            titles = scanner.nextLine().replace(',',' ').split("");
            
            
        } catch (FileNotFoundException e) {
        	
            e.printStackTrace();
            
        }
        
        scanner.close();
        
        return titles;
	    
	 }

	}
