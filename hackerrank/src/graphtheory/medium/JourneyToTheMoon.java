package graphtheory.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JourneyToTheMoon {

	// 문제
	// UN은 2명을 달로 보낼 계획이 있다.
	// 그 2명은 다른 나라의 사람으로 구성돼야 한다.
	// 2개의 짝으로 된 ID list를 받을 것이다.
	// 각 짝은 같은 나라사람이다.
	// 이 때 몇 가지 종류의 수가 가능할 것인가.

	// 문제 풀이
	// 나라의 수와 각 나라마다 몇 명인지 구하면 된다.
	// i.g. A(2), B(2), C(1), n = 5 
	// combi = (2*(5-2) + 2(5-4) + 1*(5-5)) / 2
	// 6 + 2  + 0 = 8
	// (0,1) (2,3) (4)
	// 0, 2
	// 0, 3
	// 0, 4
	// 1, 2
	// 1, 3
	// 1, 4
	// 2, 4
	// 3, 4
    static long journeyToMoon(int n, int[][] astronaut) {

    	int contryId = 0;
    	int[] astroId = new int[n];
    	
    	// 각 우주인의 나라Id를 새긴다.
    	for(int i=0; i<astronaut.length; i++) {
    		int ast1 = astronaut[i][0];
    		int ast2 = astronaut[i][1];

    		// 둘 다 cid를 받지 못했으면, 새로 부여한다.
    		if(astroId[ast1] == 0 && astroId[ast2] == 0) {
    			contryId++;
    			astroId[ast1] = contryId;
    			astroId[ast2] = contryId;

    		}
    		// ast2만 나라가 있다면 ast1id == ast2id
    		else if(astroId[ast1] == 0 && astroId[ast2] > 0){
    			astroId[ast1] = astroId[ast2];
    		}
    		// ast1만 나라가 있다면 ast2id == ast1id
    		else if(astroId[ast2] == 0 && astroId[ast1] > 0){
    			astroId[ast2] = astroId[ast1];
    		}
    		// 둘 다 나라를 받았는데 번호가 다르다면
    		// 둘이 같은 나라이므로 하나의 나라번호로 통일시킨다.
    		// 단, ast2 = ast1를 한다면 ast2와 같은 모든 ast의 나라번호를 ast1로 바꾼다.
    		else {
    			int maxId = Math.max(astroId[ast1], astroId[ast2]);
    			int minId = Math.min(astroId[ast1], astroId[ast2]);
    			
				for(int j=0; j<astroId.length; j++) {
					if(astroId[j] == minId) astroId[j] = maxId;
				}
    		}
    	}
    	
    	
    	for(int i=0; i<astroId.length; i++) {
    		if(astroId[i]==0) {
    			astroId[i] = ++contryId;
    		}
    	}
    	
    	// contryId == number of contries
    	int[] contries = new int[contryId];
    	
    	// 각 나라별 인원수를 체크함.
    	for(int i=0; i<astroId.length; i++) {
    		contries[astroId[i]-1]++;
    	}
    	
    	long combiCnt = 0L;
    	for(int i=0; i<contries.length; i++) {
    		n -= contries[i];
    		combiCnt += contries[i] * n;
    	}
    	
    	return combiCnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
    	StringBuffer sb = new StringBuffer();

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        sb.append(String.valueOf(result));

        System.out.println(sb.toString());

        scanner.close();
    }
}
