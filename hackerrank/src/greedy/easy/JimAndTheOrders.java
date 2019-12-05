package greedy.easy;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JimAndTheOrders {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {

    	// number, servetime
    	Map<Integer, Integer> hm = new HashMap<>();
    	
    	for(int i=0; i<orders.length; i++) {
    		hm.put(i, orders[i][0] + orders[i][1]);
    	}

    	return hm.entrySet().
				stream().
				sorted(Map.Entry.comparingByValue()).
				mapToInt(key -> (int)key.getKey()+1).
				toArray();
    }
    
    static int[] jimOrders_arrVersion(int[][] orders) {

    	int[][] dels = new int[orders.length][2];
    	
    	for(int i=0; i<orders.length; i++) {
    		dels[i][0] = i+1;
    		dels[i][1] = orders[i][0] + orders[i][1];
    	}
    	
    	Arrays.sort(dels, (a,b) -> (a[1] - b[1]));
    	
    	return Arrays.
				stream(dels).
				mapToInt(n -> n[0]).
				toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        
    	StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            sb.append(String.valueOf(result[i]));

            if (i != result.length - 1) {
                sb.append(" ");
            }
        }

        System.out.println(sb.toString());

        scanner.close();
    }
}