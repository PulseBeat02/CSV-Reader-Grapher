package main.pulsebeat02.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File_Printing {
	
	public static BufferedWriter writeArray (double[][] array, String path) throws IOException {
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < array.length; i++) { //for each row
			
		   for (int j = 0; j < array.length; j++) { //for each column
			   
		      builder.append(array[i][j] + "");//append to the output string
		      
		      if (j < array.length - 1)//if this is not the last row element
		    	  
		         builder.append(",");//then add comma (if you don't like commas you can use spaces)
		      
		   }
		   
		   builder.append("\n");//append new line at the end of the row
		   
		}
	
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		
		writer.write(builder.toString()); //save the string representation of the board
		
		writer.close();
		
		return writer;
		
	}
	
//	public static CSVWriter writeArrayList (ArrayList<Integer> list) {
//		
//		
//		
//	}

}
