package main;

import algorithms.*;




import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;

import com.panayotis.gnuplot.*;

import calculation.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
    	
        LittleFrog lf = new LittleFrog();
        Fibonacci ij = new Fibonacci(); 
        lf.setR(17);
        ArrayList<Double> z = new ArrayList<>();
        for (int i = 0; i < (int)Math.pow(2, lf.getR() - 2) + 4; i++) {
            z.add(lf.getZ(i));
            System.out.println(z.get(i));
        }
        ArrayList<Double> k = new ArrayList();
        
        for (int i = 0; i < 400; i++) {
        	double v = ij.getZ();
            System.out.println( "Fibo "+ v + " " + (i + 1));
            if(ij.list.contains(v)) {
            	System.out.println("Contain " + i);
            }
            k.add(v);
        }
        Map<Double, Integer> freqt = Calculation.frequency(k);
        CategoryChart new2;
        new2 = new CategoryChartBuilder().width(800).height(600).build();
        new2.addSeries("freqCr", new ArrayList<>(freqt.keySet()),
                new ArrayList<>(freqt.values()));
        try {
            BitmapEncoder.saveBitmap(new2, "freqCr",
                    BitmapEncoder.BitmapFormat.PNG);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(freqt.toString());
        int o = 6;
        System.out.println(o++);
        System.out.println(o);

        double math = Calculation.mathExpect(z);
        System.out.println("Math expection: " + math);
        double dispersion = Calculation.dispersion(z);
        System.out.println("Dispersion: " + dispersion + "\n");
        Map<Double, Integer> freq = Calculation.frequency(z);
     
        new2 = new CategoryChartBuilder().width(800).height(600).build();
        new2.addSeries("freqCr", Arrays.asList(0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9),
                new ArrayList<>(freq.values()));
        try {
            BitmapEncoder.saveBitmap(new2, "freqCr2",
                    BitmapEncoder.BitmapFormat.PNG);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JavaPlot f = new JavaPlot("C:\\Users\\ACER\\Desktop\\gnuplot\\bin\\gnuplot.exe");
       
//        try {
//			//f.setGNUPlotPath("C:/Users/ACER/Desktop/gnuplot/bin/gnuplot.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
       
        
        System.out.println(freq.toString());
        System.out.println(Calculation.correlation(z, 2, lf.getR()) + "\n");
        int fileCount = 1;
        for (int i = 10; i < 13; i++) {
        	String path = "res/data1.txt";
        	path = path.replaceFirst("1", Integer.toString(fileCount));
        	fileCount++;
            LittleFrog test = new LittleFrog();
            test.setR(i);
            ArrayList<Double> seq = new ArrayList<>();
            for (int j = 0; j < Math.pow(2, test.getR() - 2); j++) {
                seq.add(test.getZ(j));
            }
            try {
            	FileWriter writer = new FileWriter(path, false);
			
				
			
            for(int c = 5; c <= 20; c += 5) {
            	System.out.println("Correlation " + "s = " + c + " " + " T= " + i + " " + Calculation.correlation( seq, c, test.getR()));
            	 
                  	writer.write( c + " " +  Calculation.correlation( seq, c, test.getR()) + "\n");
                  	
               
            }
            
        	writer.flush();
        	writer.close();
            }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
//        f.addPlot("'res/data1.txt' with lines, 'res/data2.txt' with lines, 'res/data3.txt' with lines" + "\n" + "set label 1 'Y'" );
//        //f.addPlot("set label 1 'Y-AXIS'");
//       
//        f.plot();
        try {
        	FileWriter writer = new FileWriter("res/data4.txt", false);
        	LittleFrog frog = new LittleFrog();
        	double a = 0;
        	int[] array = new int[7]; 
        	for (int i = 0; i < (int)Math.pow(2, frog.getR() - 2); i++) {
				a = frog.getZ(i);
	            if(0<= a && a <= 0.159 ) {
	         
	            	array[5]++; 
	            }
	            else if(0.159<= a && a <= 0.326 ) {
		          
		            	array[4]++; 
		        }
	            else if(0.326<= a && a <= 0.492 ) {
		            
		            	array[6]++; 
		        }
	            else if(0.492 <= a && a <= 0.581 ) {
		            
		            	array[0]++; 
		        }
	            else if(0.581 <= a && a <= 0.717 ) {
		            
		            	array[1]++; 
		        }
	            else if(0.717 <= a && a <= 0.854 ) {
		           
		            	array[2]++; 
		        }
	            else if(0.854<= a && a <= 1 ) {
		          
		            	array[3]++; 
		        }
	            else {
	            	System.out.println("des");
	            }
	    }
        	double [] ar = new double[7];
        	ar[5] = 0.159;
        	ar[4] = 0.157;
        	ar[6] = 0.166;
        	ar[0] = 0.089;
        	ar[1] = 0.136;
        	ar[2] = 0.137;
        	ar[3] = 0.156;
        	   for(int c = 0;c < ar.length; c ++) {
               	
               	 
                     	writer.write( ar[c] + " " +  array[c] + "\n");
                     	
                  
               }
        	   writer.flush();
        	   writer.close();
        	   f.addPlot("'res/data4.txt' with lines");
        	   f.plot();
        }catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
