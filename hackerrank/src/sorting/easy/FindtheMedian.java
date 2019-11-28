package sorting.easy;

import java.util.Arrays;

public class FindtheMedian {

	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 4, 6, 5, 3};
		
		int r = findMedian(arr);
		
		System.out.println(r);
		
	}

    static int findMedian(int[] arr) {
    	Arrays.sort(arr);
    	
    	return arr[arr.length/2];
    }
	
}
