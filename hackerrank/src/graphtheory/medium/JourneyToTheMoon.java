package graphtheory.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class JourneyToTheMoon {

	// ����
	// UN�� 2���� �޷� ���� ��ȹ�� �ִ�.
	// �� 2���� �ٸ� ������ ������� �����ž� �Ѵ�.
	// 2���� ¦���� �� ID list�� ���� ���̴�.
	// �� ¦�� ���� �������̴�.
	// �� �� �� ���� ������ ���� ������ ���ΰ�.

	// ���� Ǯ��
	// ������ ���� �� ���󸶴� �� ������ ���ϸ� �ȴ�.
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
    	
    	// �� �������� ����Id�� �����.
    	for(int i=0; i<astronaut.length; i++) {
    		int ast1 = astronaut[i][0];
    		int ast2 = astronaut[i][1];

    		// �� �� cid�� ���� ��������, ���� �ο��Ѵ�.
    		if(astroId[ast1] == 0 && astroId[ast2] == 0) {
    			contryId++;
    			astroId[ast1] = contryId;
    			astroId[ast2] = contryId;

    		}
    		// ast2�� ���� �ִٸ� ast1id == ast2id
    		else if(astroId[ast1] == 0 && astroId[ast2] > 0){
    			astroId[ast1] = astroId[ast2];
    		}
    		// ast1�� ���� �ִٸ� ast2id == ast1id
    		else if(astroId[ast2] == 0 && astroId[ast1] > 0){
    			astroId[ast2] = astroId[ast1];
    		}
    		// �� �� ���� �޾Ҵµ� ��ȣ�� �ٸ��ٸ�
    		// ���� ���� �����̹Ƿ� �ϳ��� �����ȣ�� ���Ͻ�Ų��.
    		// ��, ast2 = ast1�� �Ѵٸ� ast2�� ���� ��� ast�� �����ȣ�� ast1�� �ٲ۴�.
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
    	
    	// �� ���� �ο����� üũ��.
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
