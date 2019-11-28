package greedy.easy;

public class GridChallenge {

	public static void main(String[] args) {
		String[][] grid = {
				{
					"ebacd",
					"fghij",
					"olmkn",
					"trpqs",
					"xywuv"
				},
				{
					"mpxz",
					"abcd",
					"wlmf"
				}
			};
		
		String[] ca = {
				"YES",
				"NO"
			};
		
		for(int i=0; i<grid.length; i++) {
			String ma = gridChallenge(grid[i]);
			System.out.println(ma);
			System.out.println(ca[i]);
		}
		
	}

    static String gridChallenge(String[] grid) {
    	
    	int t = grid.length;
    	int n = grid[0].length();
    	
    	int[][] chars = new int[t][n];
    	
    	for(int i=0; i<t; i++) {
    		chars[i] = grid[i].chars().sorted().toArray();
    		
    		if(i>0) {
    			for(int j=0; j<n; j++) {
    				if(chars[i-1][j] > chars[i][j]) {
    					return "NO";
    				}
    			}
    		}
    	}
    	
    	return "YES";
    }
	
}
