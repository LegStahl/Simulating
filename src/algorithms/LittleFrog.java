package algorithms;

import java.util.ArrayList;

public class LittleFrog {
    private int r = 11;
    private static final int m = 16;
    private static final int M = 9973;
    private ArrayList<Integer> a;
    
    public LittleFrog(){
        a = new ArrayList<>();
        a.add(1);
    }
    
    private Integer getA(int i){
        a.add((a.get(i) * M) % (int)Math.pow((double)2, r));
        return a.get(i);
    }
    public double getZ(int k){
        return getA(k) * Math.pow((double)2, -(r));
    }
    public int getR () {
        return r;
    }
    public void setR(int r){
        this.r = r;
    }
}