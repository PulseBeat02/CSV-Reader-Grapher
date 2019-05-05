package main.pulsebeat02.Graphing;

import java.awt.Container;
import java.awt.Graphics2D;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.pulsebeat02.CSV_Reading.LoadtoArray.Import.Read_Text;
import main.pulsebeat02.CSV_Reading.LoadtoArray.Import.Read_Title;

public class Graph_GUI extends JFrame {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private final int WIDTH = 1200;
    private final int HEIGHT = 800;
  
    private Container drawable;
  
    private static Graphics2D canvas;
  
    public Graph_GUI (JPanel canvas, File file) {
  	
      super("CSV Graph");
      
      drawable = getContentPane();
      
      drawable.add(canvas);
      
      setSize(WIDTH, HEIGHT);
      
    }
    
    public static double[][] getValues (File file) {
	
		return Read_Text.getDoublesCSV(file);
	
	}

	public static String[] getTitles (File file) {
	
		return Read_Title.getTitles(file);
	
	}
	
	@Deprecated
	public static void drawPoint (Graphics2D canvas, int xCoord, int yCoord, int XArc, int YArc) {
	
		canvas.drawOval(XArc, YArc, xCoord, yCoord);
	
	}

	public static void drawLine (Graphics2D canvas, int x1, int y1, int x2, int y2) {
	
		canvas.drawLine(x1, y1, x2, y2);
	
	}
	
	public static void drawGraph(File file) {
		
		double [][] values = getValues(file);
		String [] titles = getTitles(file);
		
		ArrayList<Point> Points = new ArrayList<Point>();

		for (int i = 0; i < values.length; i++) {
			
			for (int z = 0; z < values[0].length; z++) {
				
				double [] currentPoint = {values[i][z], values[i + 1][z]};
				
				// drawPoint(canvas, (int)currentPoint[0], (int)currentPoint[1], 5, 5); Better Alternative is to use Point Class
				
				if (points >= 1) {
					
					// Work on later.
					
				}
				
			}
			
		}
		
	}
				
}

















