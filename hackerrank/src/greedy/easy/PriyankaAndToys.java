package greedy.easy;

import java.util.Arrays;

public class PriyankaAndToys {

	public static void main(String[] args) {
		int[][] w = {
				{1, 2, 3, 21, 7, 12, 14, 21}
			};
		int[] ca = {
				4
			};
		
		for(int i=0; i<w.length; i++) {
			int ma = toys(w[i]);
			System.out.println(ca[i] + " ?= " + ma);
		}
	}
	

    static int toys(int[] w) {
    	
    	Arrays.sort(w);
    	
    	int lastWeight = w[0];
    	int containerCnt = 1;
    	
    	for(int i=1; i<w.length; i++) {
    		if(w[i] - lastWeight > 4) {
    			lastWeight = w[i];
    			containerCnt++;
    		}
    	}

    	return containerCnt;
    }
	
}
