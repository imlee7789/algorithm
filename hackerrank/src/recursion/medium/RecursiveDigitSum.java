package recursion.medium;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class RecursiveDigitSum {
    static int superDigit(String n, int k) {
    	
    	BigInteger sum = new BigInteger("0");

    	// 1. n의 요소의 합을 구한다.
    	for(int i=0; i<n.length(); i++) {
    		sum = sum.add(new BigInteger(n.charAt(i)+""));
    	}

    	// 2. n의 요소 합의 결과에 k를 곱한다.
    	// >> sum("123") * 2 == sum("123" + "123")
    	sum = sum.multiply(new BigInteger(k+""));
    	
    	n = sum.toString();
    	
    	// 3. n요소의 합이 super digit이 될 때까지 반복한다.
    	while(n.length()>1) {
    		sum = new BigInteger("0");
    		
    		for(int i=0; i<n.length(); i++) {
        		sum = sum.add(new BigInteger(n.charAt(i)+""));
    		}
    		
        	n = sum.toString();
    	}
    	
    	return sum.intValue();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
