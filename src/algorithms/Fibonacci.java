package algorithms;

import java.util.*;


public class Fibonacci {
	
	private int m = 4;
	
	private int k = 16;
	
	public List<Double> list;
	
	private int run = 0;
	
	private int run2 = 0;
	
	
	public Fibonacci() {
		list = new ArrayList<>();
		Random a = new Random();
		for(run = 0; run < 16; run++) {
			list.add(Math.abs((double)a.nextInt() % (int)Math.pow(2, m)));
		}
		
		
	}
	
	public double getZ() {
		list.add((list.get(list.size() - 1) + list.get((list.size() - 1 ) - (run2++ % k) )) % (int)Math.pow(2, m)); 
		return list.get(list.size() - 1) / Math.pow(2, m) ;
	}
}
