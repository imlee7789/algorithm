package greedy.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {

    	int[] candies = new int[n];
    	candies[0] = 1;
    	
    	for (int i = 1; i < n; i++) {
    		
    		if (arr[i-1] < arr[i]) {
    			candies[i] = candies[i-1]++;
    			
    		} else {
    			candies[i] = 1;
    			
    			for (int j=i; j>=1; j--) {
    				
    				if (candies[j-1] == candies[j]) {
    					candies[j-1]++;
    					
    				} else {
    					break;
    				}
    			}
    		}
    	}
    	
    	System.out.println(Arrays.toString(candies));
    	
    	return Arrays.stream(candies).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
