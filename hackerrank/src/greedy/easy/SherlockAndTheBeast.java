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
	
	// 문제 설명
	// 1. 3x + 5y = n;에서 x와 y를 구하는 문제다.
	//    3x만큼 5를, 5y만큼 3을 출력한다.
	//
	// 2. N을 나타낼 방법 중 가장 큰 수를 찾는다.
	//    즉 15라면 다음과 같이 2가지 방법으로 출력이 가능하다.
	//	  555555555555555
	//    333333333333333
	//    그러나 이 중 큰 숫자를 채택해야한다.
	//    즉, 가능한 적은 수를 5's digit으로 구하고 남은 모든 수를 3's digit으로 구해야 한다.
	//
	// 3. 효율성
	//    패턴을 익혀야할 듯 함. ( Diophantine equation? linear combination )
	
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
	// 알고리즘을 본 후 다시 풀어본 버전.
	// 첫 오리지널 버전보다 흐름에 이해가 생김.
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
