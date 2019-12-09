package greedy.medium;

import java.io.IOException;
import java.util.Scanner;

public class GoodlandElectricity {

	 /* ���� Ǯ��
	  * 
	  * �ϳ��� �÷�Ʈ(idx)�� idx�� �߽����� -(k-1) ~ +(k-1) ������ city�� ������ �����ϴ�.
	  * 
	  * ��, idx�� ���� �÷�Ʈ�� �� ���� �÷�Ʈ�� ������ ������ idx+1 ~ idx+2k-1�̴�.
	  * 
	  * ���� �÷�Ʈ�� ������ ���� ��ġ�Ƿ��� idx+2k-1���� idx+1�� ���������� �˻��ϸ� ��ġ �������� Ȯ���ؾ� �Ѵ�.
	  * 
	  * �� �� idx���� �÷�Ʈ�� idx+1 ~ idx+2k-1 ������ ���ٸ� ���� �Ұ����� ���ð� �ִٴ� ���̹Ƿ� -1�� �����Ѵ�.
	  * 
	  * ���� ������ �ݺ��ϸ� �ּ����� ���� �÷�Ʈ�� �� �� �ִ�.
	  */
    static int pylons(int k, int[] arr) {

        int minPlantCnt = 0;

        int supliedCnt = 0;
        
        int idx = k - 1;
        
        int lastIdx = -1;
        
        while (idx < arr.length) {
        	
        	// idx�� ���� �÷�Ʈ�� ��
        	if (arr[idx] == 1) {
        		
        		lastIdx = idx;
        		supliedCnt = idx + (k - 1);	// idx�� ������ �� �ִ� �ִ� ����
        		idx += 2 * k - 1; // �ּ����� ���� �÷�Ʈ�� ���� ���� index
        		
        		if (idx >= arr.length) {
        			idx = arr.length - 1;
        		}
        		
        		minPlantCnt++;	// �÷�Ʈ ����
        		
        		// ��� ���ø� �������� �� �� �̻� ã�� �ʴ´�.
        		if (supliedCnt >= arr.length - 1) {
        			break;
        		}
        		
        	} else {
        		// �ִ� ���� idx + 2k - 1���� idx + 1���� ���� ���� �÷�Ʈ�� ã������ idx--
        		// ��� ã�ٰ� lastIdx == idx�� �ȴٸ� ���� �Ұ����� ���ð� �ִٴ� ���̹Ƿ� -1 ����
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
