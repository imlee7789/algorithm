package greedy.easy;

import java.util.Arrays;

public class MarcsCakewalk {

	public static void main(String[] args) {
		int[][] calorie = {
				{1, 3, 2},
				{7, 4, 9, 6},
				{801, 234, 536, 747, 172, 590, 833, 847, 509, 429, 666, 411, 609, 894, 348, 254, 814, 767, 647, 965, 711, 801, 852, 781, 972, 390, 218, 290, 508, 174, 55, 714, 442, 284, 745, 872, 46, 131, 833, 315}
			};
		
		long[] ca = {
				11,
				79,
				84350424920174L
			};

		for(int i=0; i<calorie.length; i++) {
			long ma = marcsCakewalk(calorie[i]);
			
			System.out.println(ma);
			System.out.println(ca[i]);
		}
	}

    static long marcsCakewalk(int[] calorie) {

    	Arrays.sort(calorie);
    	
    	long n = 1;
    	long answer = 0;
    	
    	for(int i=calorie.length-1; i>=0; i--) {
    		long num = calorie[i] * n;
    		answer += num;
    		n *= 2;
    	}
    	
    	return answer;
    }
	
}
