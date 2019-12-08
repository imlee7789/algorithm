package greedy.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyFlorist {

    static int getMinimumCost(int k, int[] c) {
    	
    	int a = 0;
    	int plused = 0;
    	int cnt = 0;
    	
    	Arrays.sort(c);

    	for (int i = c.length - 1; i >= 0; i--) {
    		if (cnt == k) {
    			plused++;
    			cnt = 0;
    		}
    		a += c[i] * (1 + plused);
    		cnt++;
    	}
    	
    	return a;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        System.out.println(String.valueOf(minimumCost));

        scanner.close();
    }
}