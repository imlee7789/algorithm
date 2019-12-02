package greedy.easy;

public class SherlockAndTheBeast {

	public static void main(String[] args) {
		int[] n = {
				1,
				3,
				5,
				11,
				15,
				13,
				8580,
//				16559,
//				75217,
//				16078,
//				23495,
//				43846,
//				78882,
//				84094,
//				64745,
//				72145,
//				24615,
//				41935,
//				85806,
//				59304,
//				24941,
//				44114,
//				10650,
//				16746,
//				14631,
//				26530,
//				47882
			};

		String[] ca = {
				"-1", 
				"555",
				"33333",
				"55555533333",
				"555555555555555",
				"5553333333333",
				""
			};

		for(int i=0; i<n.length; i++) {
			long s = System.currentTimeMillis();
			decentNumber(n[i]);
			long e = System.currentTimeMillis();
			System.out.println((e-s) + "ms");
		}
	}
	
	// ���� ����
	// 1. 3x + 5y = n;���� x�� y�� ���ϴ� ������.
	//    3x��ŭ 5��, 5y��ŭ 3�� ����Ѵ�.
	//
	// 2. N�� ��Ÿ�� ��� �� ���� ū ���� ã�´�.
	//    �� 15��� ������ ���� 2���� ������� ����� �����ϴ�.
	//	  555555555555555
	//    333333333333333
	//    �׷��� �� �� ū ���ڸ� ä���ؾ��Ѵ�.
	//    ��, ������ ���� ���� 5's digit���� ���ϰ� ���� ��� ���� 3's digit���� ���ؾ� �Ѵ�.
	//
	// 3. ȿ����
	//    ������ �������� �� ��. ( Diophantine equation? linear combination )
	
	// On discussion
	static void decentNumber_on_discussion(int n) {
    	StringBuilder sb = new StringBuilder();
    	
		int y = n;
		int z = y;
		
		while(z%3!=0) {
			z -= 5;
		}
		
		if(z<0) {
			System.out.println(-1);
		}
		
		for(int i=0; i<z; i++) {
			sb.append('5');
		}
		
		for(int i=0; i<(y-z); i++) {
			sb.append('3');
		}
		
		System.out.println(sb.toString());
		
	}
	
	// Optimized version
	// �˰����� �� �� �ٽ� Ǯ� ����.
	// ù �������� �������� �帧�� ���ذ� ����.
	static void decentNumber(int n) {
		
		StringBuilder sb = new StringBuilder();
		
		int threeCnt = 0;
		int fiveCnt = 0;
		
		found:
		for(int x=n/3; x>=0; x--) {
			for(int y=0; y<=n/5; y++) {
				if(3*x + 5*y == n) {
					threeCnt = x;
					fiveCnt = y;
					break found;
				}
				//optimized
				if(3*x + 5*y > n) {
					break;
				}
			}
			
		}

		for(int i=0; i<threeCnt; i++) {
			sb.append("555");
		}
		
		for(int i=0; i<fiveCnt; i++) {
			sb.append("33333");
		}
		
		if(threeCnt == 0 && fiveCnt == 0) {
			sb.append("-1");
		}
		
		System.out.println(sb.toString());
		
	}
		
	// First version
    static void decentNumber_origin(int n) {
    	StringBuilder sb = new StringBuilder();
    	
    	int fivCnt = 0;
    	int thrCnt = 0;

    	found:
        for(int i=0; i<=n/5; i++) {
            for(int j=(n / 60 - 1)* 20; j<=n/3; j++) {
    			if(j*3 + i*5 == n) {
    				thrCnt = j;
    				fivCnt = i;
    				break found;
    			}
    		}
    	}

    	for(int i=0; i<thrCnt; i++) {
    		sb.append("555");
    	}
    	for(int i=0; i<fivCnt; i++) {
    		sb.append("33333");
    	}
    	
    	if(thrCnt == 0 && fivCnt == 0) {
    		sb.append("-1");
    	}
    	
    	System.out.println(sb.toString());
    }
	
}
