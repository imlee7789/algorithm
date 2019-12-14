package dp.medium;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

    // Complete the fibonacciModified function below.
    static BigInteger fibonacciModified(int t1, int t2, int n) {
        
        BigInteger ti2 = new BigInteger("0");

        BigInteger ti = new BigInteger(String.valueOf(t1));
        BigInteger ti1 = new BigInteger(String.valueOf(t2));
        
        for (int i=2; i<n; i++) {
            ti2 = ti.add(ti1.multiply(ti1));
            ti = ti1;
            ti1 = ti2;
        }

        return ti2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigInteger result = fibonacciModified(t1, t2, n);

        System.out.println(result.toString());

        scanner.close();
    }
}
