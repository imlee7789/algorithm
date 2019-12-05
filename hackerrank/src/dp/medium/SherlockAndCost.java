package dp.medium;

import java.io.IOException;
import java.util.Scanner;

public class SherlockAndCost {
	
	
	// ����
	// 1 <= A[i] <= B[i] �� ��
	// SUM(|A[i-1] - A[i]|), i=1,N �� ���ϴ� ����.
	
	// ���� Ǯ��
	//		A[i-1]	A[i]
	//	1)	1		1
	//	2)	B[i-1]	1
	//	3)	1		B[i]
	//	4)	B[i-1]	B[i]
	// �� ���� ���� 4���� ��� �� ������ �ּ��ΰ��� �����ϴ� ������.
	
	// Ǯ�̴� �� ����(i) ���� A[i]�� 1���� B[i]���� ���ϴ� ������.
	
	// 1) A[i] == 1?
	//    A[i-1] == 1 or B[i-1] �� � �� ���� ū ������ ���Ѵ�.
	
	// 2) A[i] == B[i]?
	//    A[i-1] == 1 or B[i-1] �� � �� ���� ū ������ ���Ѵ�.
	
	// 1)�� 2)�� �ݺ������� i==N���� ���Ѵ�.
	// �׷��� �Ǹ� �Ź� 1 or B[i]�� �������� �� ���� ū ���� ���� ���� �� �����Ƿ�
	// i==N�� �� 1)�� 2)�� ū ���� ���� ���� �ȴ�.
    private static int cost(int[] B) {
    	
    	int costLast1 = 0;	// ���� ���� 1�̾��� �� (����) �ִ���
    	int costLastB = 0;	// ���� ���� B[i-1]���� �� (����) �ִ���
    	
    	// ���̸� ������ ���̹Ƿ� 1���� ����
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
