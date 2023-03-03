package com.my.study.backjune;

public class Test {
    static long sum(int[] a) {
      	if(a.length <= 0 || a.length >3000000) {
    		throw new IllegalArgumentException();
    	}
        long ans = 0;
        for (int i : a) {
        	if(i < 0 || i >1000000) {
        		throw new IllegalArgumentException();
        	}
        	ans += i;
		}
        return ans;
    }
    
    public static void main(String[] args) {
    	long ans = sum(new int[] {-1,2,3});
    	System.out.println(ans);

	}
}

