package greedy.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	
    	Arrays.sort(arr);
    	
    	int min = arr[k - 1] - arr[0];
    			
    	for (int i = 1; i < arr.length - k + 1; i++) {
    		
    		int sum = arr[k - 1 + i] - arr[i];
    		System.out.println(sum);
    		if (sum < min) {
    			min = sum;
    		}
    	}
    	
    	return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
