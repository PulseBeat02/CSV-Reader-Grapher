package main.pulsebeat02.Graphing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
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
	
	private final int WIDTH = 1200; // Width for Window
    private final int HEIGHT = 800; // Height for Window
  
    static Graphics2D canvasOriginal; // Canvas
    
    static Graphics canvas = (Graphics) canvasOriginal;
  
    public Graph_GUI (JPanel panel, JFrame window) { // GUI
  	
      super("CSV Graph");

      panel.paint(canvas);
      
      window.add(panel);
      window.setSize(WIDTH, HEIGHT);
      
    }
    
    public static double[][] getValues (File file) { // Get Values of CSV File
	
		return Read_Text.getDoublesCSV(file);
	
	}

	public static String[] getTitles (File file) { // Get Titles of CSV File
	
		return Read_Title.getTitles(file);
	
	}
	
	@Deprecated
	public static void drawPointCoords (Graphics canvas, int xCoord, int yCoord, int XArc, int YArc) { // Deprecated
	
		canvas.drawOval(XArc, YArc, xCoord, yCoord);
	
	}
	
	public static void drawPoint (Graphics canvas, Point point) { // Draws Point
		
		Ellipse2D.Double shape = new Ellipse2D.Double(point.x, point.y, point.Ysize, point.Xsize);
		((Graphics2D) canvas).draw(shape);
		
		// canvas.drawOval(point.x, point.y, point.Ysize, point.Xsize);
		
	}
	
	@Deprecated
	public static void drawLineCoords (Graphics canvas, int x1, int y1, int x2, int y2) { // Deprecated
		
		canvas.drawLine(x1, y1, x2, y2);
	
	}
	
	public static void drawLinePoints (Graphics canvas, Point point, Point point2) { // Draws Line
		
		((Graphics2D) canvas).draw(new Line2D.Double(point.x, point.y, point2.x, point2.y));
		
	}
	
	public static void drawGraph(File file) { // Draw a Graph
		
		double[][] values = getValues(file);  
		
		// String [] titles = getTitles(file);
		
		ArrayList<Point> Points = new ArrayList<Point>(); // Define ArrayList of Points

		for (int i = 0; i < values.length - 1; i++) {
			
			for (int z = 0; z < values[0].length; z++) {
				
				// double [] currentPoint = {values[i][z], values[i + 1][z]};
				
				Point currentPoint = new Point(values[i][z], values[i + 1][z], 5, 5); // Make current point
				Points.add(currentPoint); // Add it to ArrayList
				
				// drawPointCoords(canvas, (int)currentPoint[0], (int)currentPoint[1], 5, 5); Better Alternative is to use Point Class
				
				if (Points.size() >= 2) {
					
					drawLinePoints (canvas, currentPoint, Points.get(Points.indexOf(currentPoint) - 1));
					
				}
				
			}
			
		}
		
		for (int c = 0; c < Points.size(); c++) {
			
			drawPoint(canvas, Points.get(c));
			
		}
		
	}
	
	
	public static void main(String[] args, File file) {
		
		drawGraph(file);
		
	}
				
}

















