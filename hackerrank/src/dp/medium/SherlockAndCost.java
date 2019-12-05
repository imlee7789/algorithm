package dp.medium;

import java.io.IOException;
import java.util.Scanner;

public class SherlockAndCost {
	
	
	// 문제
	// 1 <= A[i] <= B[i] 일 때
	// SUM(|A[i-1] - A[i]|), i=1,N 를 구하는 문제.
	
	// 문제 풀이
	//		A[i-1]	A[i]
	//	1)	1		1
	//	2)	B[i-1]	1
	//	3)	1		B[i]
	//	4)	B[i-1]	B[i]
	// 매 순간 위의 4가지 경우 중 무엇이 최선인가를 선택하는 문제다.
	
	// 풀이는 매 순간(i) 마다 A[i]가 1인지 B[i]인지 구하는 문제다.
	
	// 1) A[i] == 1?
	//    A[i-1] == 1 or B[i-1] 중 어떨 때 가장 큰 값인지 구한다.
	
	// 2) A[i] == B[i]?
	//    A[i-1] == 1 or B[i-1] 중 어떨 때 가장 큰 값인지 구한다.
	
	// 1)과 2)를 반복적으로 i==N까지 구한다.
	// 그렇게 되면 매번 1 or B[i]를 선택했을 때 가장 큰 차의 합을 구할 수 있으므로
	// i==N일 때 1)과 2)중 큰 값이 최종 답이 된다.
    private static int cost(int[] B) {
    	
    	int costLast1 = 0;	// 지난 값이 1이었을 때 (차의) 최대합
    	int costLastB = 0;	// 지난 값이 B[i-1]였을 때 (차의) 최대합
    	
    	// 차이를 누적할 것이므로 1부터 시작
    	for(int i=1; i<B.length; i++) {
    		//						costLast1							costLastB
    		int this1 = Math.max(	costLast1 + Math.abs(1 - 1), 		costLastB + Math.abs(B[i-1] - 1));
    		int thisB = Math.max(	costLast1 + Math.abs(1 - B[i]),		costLastB + Math.abs(B[i-1] - B[i]));
    		
    		costLast1 = this1;
    		costLastB = thisB;
    	}
        
        return Math.max(costLast1, costLastB);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            
            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            int result = cost(B);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
