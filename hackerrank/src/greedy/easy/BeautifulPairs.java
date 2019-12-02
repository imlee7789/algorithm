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

	// 문제 설명
	// 배열 A와 배열 B의 값이 같은 경우를 Beautiful pair라고 한다.
	// 1. 최대 Beautiful pair의 개수를 구해라.
	// 2. 반드시 B의 요소 중 1개는 바꿔야 한다.
	
	// 풀이 방법
	// 1. Beautiful pair의 개수를 구한다.
	//    1-1. A를 순회한다.
	//    1-2. Beautiful pair는 하나의 pair만 가져야 하므로 bp[j]에 체크해둔다. 
	//    1-3. pair가 성립될 때 bpCnt++;
	
	// 2. 반드시 B의 요소 중 1개를 바꿔야한다.
	//    2-1. 반드시 1개를 변경해야 하므로 모든 요소가 beautiful pair일 경우 -1, 
	//    2-2. 하나라도 틀렸다면 요소 하나를 변경해서 beautiful pair를 만들 수 있으므로 +1
	
	// 최적화
	// 3. sort를 하는것이 빠를까? (참고. quick sort의 시간 복잡도는 O(NlogN))
	//    메인 로직의 A, B는 최악의 경우 O(n^2)이다.
	//    그러나 정렬할 경우 NlogN이다.
	//    즉 정렬했을 때 O(3NlogN) < O(N^2)이므로 정렬하는 것이 시간복잡도가 적다.
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
