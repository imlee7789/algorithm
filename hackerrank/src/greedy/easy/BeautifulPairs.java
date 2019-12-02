package greedy.easy;

import java.util.Arrays;

public class BeautifulPairs {

	public static void main(String[] args) {

		int[] A = {3, 5, 7, 11, 5, 8};
		int[] B = {5, 7, 11, 10, 5, 8};

		int ca = 6;
		
		int ma = beautifulPairs(A, B);
		
		System.out.println(ma + " ?= " + ca);
	}

	// ���� ����
	// �迭 A�� �迭 B�� ���� ���� ��츦 Beautiful pair��� �Ѵ�.
	// 1. �ִ� Beautiful pair�� ������ ���ض�.
	// 2. �ݵ�� B�� ��� �� 1���� �ٲ�� �Ѵ�.
	
	// Ǯ�� ���
	// 1. Beautiful pair�� ������ ���Ѵ�.
	//    1-1. A�� ��ȸ�Ѵ�.
	//    1-2. Beautiful pair�� �ϳ��� pair�� ������ �ϹǷ� bp[j]�� üũ�صд�. 
	//    1-3. pair�� ������ �� bpCnt++;
	
	// 2. �ݵ�� B�� ��� �� 1���� �ٲ���Ѵ�.
	//    2-1. �ݵ�� 1���� �����ؾ� �ϹǷ� ��� ��Ұ� beautiful pair�� ��� -1, 
	//    2-2. �ϳ��� Ʋ�ȴٸ� ��� �ϳ��� �����ؼ� beautiful pair�� ���� �� �����Ƿ� +1
	
	// ����ȭ
	// 3. sort�� �ϴ°��� ������? (����. quick sort�� �ð� ���⵵�� O(NlogN))
	//    ���� ������ A, B�� �־��� ��� O(n^2)�̴�.
	//    �׷��� ������ ��� NlogN�̴�.
	//    �� �������� �� O(3NlogN) < O(N^2)�̹Ƿ� �����ϴ� ���� �ð����⵵�� ����.
    static int beautifulPairs(int[] A, int[] B) {

    	boolean[] bp = new boolean[B.length];
    	
    	int bpCnt = 0;
    	
    	Arrays.sort(A);
    	Arrays.sort(B);
    	
    	// Main logic
    	for(int i=0; i<A.length; i++) {
			for(int j=0; j<B.length; j++) {
				if(!bp[j] && A[i] == B[j]) {
					bp[j] = true;
					bpCnt++;
					break;
				}
			}
    	}
    	
    	if(bpCnt == A.length) {
    		bpCnt--;
    	}else {
    		bpCnt++;
    	}
    	
        return bpCnt;
    }
    
}
