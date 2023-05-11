package calculation;

import java.util.*;



public class Calculation {
	
	
    public static double mathExpect(ArrayList<Double> input){
        double res = 0;
        HashMap<Double, Integer> values = getP(input);
        for (Map.Entry<Double, Integer> entry: values.entrySet()) {
            res += entry.getKey() * entry.getValue() / input.size();
        }
        return res;
    }
    
    
    public static double dispersion(ArrayList<Double> input){
        double res = 0;
        double mathEx = mathExpect(input);
        HashMap<Double, Integer> values = getP(input);
        for (Map.Entry<Double, Integer> entry : values.entrySet()) {
            res += Math.pow((entry.getKey() - mathEx), 2) * entry.getValue() / input.size();
        }
        return res;
    }
    
    
    private static HashMap<Double, Integer> getP(ArrayList<Double> input){
        HashMap<Double, Integer> values = new HashMap<>();
        for (Double tmp: input) {
            if (values.containsKey(tmp)){
                values.put(tmp, values.get(tmp) + 1);
            }
            else{
                values.put(tmp, 1);
            }
        }
        return values;
    }
    
    
    public static double correlation(ArrayList<Double> input, int s, int r){
        double R = 0;
        for (int i = 0; i < input.size() - s; i++) {
            R += input.get(i) * input.get(i + s);
        }
       // System.out.println("Something " + input.size());
        R *= 12;
        R = R / (Math.pow((double)2, r - 2) - s);
        R -= 3;
        return R;
    }
    
    
    public static Map<Double, Integer> frequency(ArrayList<Double> input){
    	Map e = new TreeMap<Integer, Integer>();
    	for(int i = 0; i < 10; i++) {
    		int key = 1 * i;
    		e.put(key, 0);
    	}
    
    	ArrayList<Integer> res = new ArrayList();
    	for(int i = 0; i <10; i ++) {
    		res.add(0);
    	}
    	System.out.println(e);
        for (int i = 0; i < input.size(); i++) {
        	
          for(int j = 0; j < 11; j++  ) {
        	  double key = 0.1 * j;
        	  int check = (int)(input.get(i) * 10);
        	  if(e.containsKey(check)) {
        		  e.put(check, ((int)e.get(check) + 1));
        		  break;
        	  }
        	  
          }
        }
    	System.out.println(e);
        for (Double value: input){
            int tmp = (int)(value * 10);
            res.set(tmp, res.get(tmp) + 1);
        }
        System.out.println(res);
        return e;
    }
}