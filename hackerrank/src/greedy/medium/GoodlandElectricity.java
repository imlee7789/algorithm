package greedy.medium;

import java.io.IOException;
import java.util.Scanner;

public class GoodlandElectricity {

	 /* 문제 풀이
	  * 
	  * 하나의 플랜트(idx)는 idx를 중심으로 -(k-1) ~ +(k-1) 범위의 city에 공급이 가능하다.
	  * 
	  * 즉, idx가 공급 플렌트일 때 다음 플랜트가 가능한 범위는 idx+1 ~ idx+2k-1이다.
	  * 
	  * 공급 플랜트가 가능한 적게 설치되려면 idx+2k-1부터 idx+1로 역방향으로 검색하며 설치 가능한지 확인해야 한다.
	  * 
	  * 이 때 idx다음 플랜트가 idx+1 ~ idx+2k-1 범위에 없다면 공급 불가능한 도시가 있다는 뜻이므로 -1을 리턴한다.
	  * 
	  * 위의 내용을 반복하면 최소한의 공급 플랜트를 알 수 있다.
	  */
    static int pylons(int k, int[] arr) {

        int minPlantCnt = 0;

        int supliedCnt = 0;
        
        int idx = k - 1;
        
        int lastIdx = -1;
        
        while (idx < arr.length) {
        	
        	// idx가 공급 플랜트일 때
        	if (arr[idx] == 1) {
        		
        		lastIdx = idx;
        		supliedCnt = idx + (k - 1);	// idx가 공급할 수 있는 최대 범위
        		idx += 2 * k - 1; // 최소한의 공급 플랜트를 위한 도시 index
        		
        		if (idx >= arr.length) {
        			idx = arr.length - 1;
        		}
        		
        		minPlantCnt++;	// 플렌트 누적
        		
        		// 모든 도시를 공급했을 때 더 이상 찾지 않는다.
        		if (supliedCnt >= arr.length - 1) {
        			break;
        		}
        		
        	} else {
        		// 최대 범위 idx + 2k - 1부터 idx + 1까지 공급 가능 플랜트를 찾기위한 idx--
        		// 계속 찾다가 lastIdx == idx가 된다면 공급 불가능한 도시가 있다는 것이므로 -1 리턴
        		idx--;
        		if (idx <= lastIdx) {
        			return -1;
        		}
        	}
        }

        return minPlantCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pylons(k, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
