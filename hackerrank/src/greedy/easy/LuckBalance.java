package greedy.easy;

import java.util.Arrays;

public class LuckBalance {

	public static void main(String[] args) {
		int[][] contests = {
				{5, 1},
				{2, 1},
				{1, 1},
				{8, 1},
				{10, 0},
				{5, 0}
			};
		
		int k = 3;
		
		int ma = luckBalance(k, contests);
		
		System.out.println(ma);
	}
	
    static int luckBalance(int k, int[][] contests) {
    	
    	Arrays.sort(contests, (a,b) -> (b[0] - a[0]));
    	Arrays.sort(contests, (a,b) -> (b[1] - a[1]));
    	
    	int luck = 0;
    	
    	for(int i=0; i<k; i++) {
    		luck += contests[i][0];
    	}
    	
    	for(int i=k; i<contests.length; i++) {
    		if(contests[i][1] == 1) {
    			luck -= contests[i][0];
    		}else {
    			luck += contests[i][0];
    		}
    	}

    	return luck;
    }
}
