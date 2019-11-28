package greedy.easy;

import java.util.Arrays;

public class MaximumPerimeterTriangle {

	public static void main(String[] args) {
		int[] sticks = {1, 1, 1, 3, 3};
		
		int[] ca = {1, 3, 3};
		
		int[] ma = maximumPerimeterTriangle(sticks);
		
		System.out.println(Arrays.toString(ma));
		System.out.println(Arrays.toString(ca));
		
	}
	
    static int[] maximumPerimeterTriangle(int[] sticks) {
    	
    	Arrays.sort(sticks);
    	
    	int[] answer = new int[3];

    	find:
    	for(int i=sticks.length-1; i>=2; i--) {
    		for(int j=i-1; j>=1; j--) {
    			for(int k=j-1; k>=0; k--) {
    				int a = sticks[i];
    				int b = sticks[j];
    				int c = sticks[k];
    				if(b+c > a) {
    					answer[0] = c;
    					answer[1] = b;
    					answer[2] = a;
    					break find;
    				}
    	    	}	
        	}	
    	}
    	
    	if(answer[0] == 0) {
    		return new int[] {-1};
    		
    	}else {
    		return answer;
    	}
    	
    }
}
