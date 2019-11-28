package search.easy;

import java.util.Arrays;

public class IceCreamParlor {

	public static void main(String[] args) {
		int[] m = {
				4,
				4
			};
		
		int[][] arr = {
				{1, 4, 5, 3, 2},
				{2, 2, 4, 3}
			};
		
		int[][] a = {
				{1, 4},
				{1, 2}	
			};
		
		
		for(int i=0; i<m.length; i++) {
			int[] r = icecreamParlor(m[i], arr[i]);
			System.out.println(Arrays.toString(r));
			System.out.println(Arrays.toString(a[i]));
		}
	}

    static int[] icecreamParlor(int m, int[] arr) {

    	int[] r = new int[2];
    	
    	search:
    	for(int i=0; i<arr.length-1; i++) {
        	for(int j=i+1; j<arr.length; j++) {
        		if(arr[i] + arr[j] == m) {
        			r[0] = i+1;
        			r[1] = j+1;
        			break search;
        		}
        	}
    	}
    	
    	return r;
    }
    
}
