package search.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumLoss {

    // Complete the minimumLoss function below.
    static long minimumLoss(long[] price) {
    	long[][] indexed = new long[price.length][2];
    	
    	for(int i=0; i<price.length; i++) {
    		indexed[i][0] = price[i];
    		indexed[i][1] = i;
    	}
    	
    	Arrays.sort(indexed, (a,b) -> (Long.compare(b[0], a[0])));

    	long minLoss = Long.MAX_VALUE;
    	
    	for(int i=1; i<indexed.length; i++) {
    		
    		long loss = indexed[i-1][0] - indexed[i][0];
    		
    		if(loss>0 && loss<minLoss && indexed[i-1][1] < indexed[i][1]) {
				minLoss = loss;
    		}
    	}
    			
    	return minLoss;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] price = new long[n];

        String[] priceItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            long priceItem = Long.parseLong(priceItems[i]);
            price[i] = priceItem;
        }

        long result = minimumLoss(price);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
