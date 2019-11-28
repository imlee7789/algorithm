package greedy.easy;

import java.util.Arrays;

public class MinimumAbsoluteDifferenceInAnArray {

	public static void main(String[] args) {
		int[][] arr = {
				{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75},
				{1, -3, 71, 68, 17}
			};

		int[] ca = {
				1,
				3
			};
		
		for(int i=0; i<arr.length; i++) {
			int ma = minimumAbsoluteDifference(arr[i]);
			System.out.println(ma);
			System.out.println(ca[i]);
		}
	}

	// min == 0 check is optimization
    static int minimumAbsoluteDifference(int[] arr) {
    	
    	Arrays.sort(arr);
    	
    	int min = arr[1] - arr[0];
    	
    	for(int i=1; i<arr.length-1; i++) {
    		int tmp = arr[i+1] - arr[i];
    		if(tmp < min) {
    			min = tmp;
    		}
            if(min==0){
                break;
            }
    	}
    	
    	return min;
    }
}
