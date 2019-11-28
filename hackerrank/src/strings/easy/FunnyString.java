package strings.easy;

public class FunnyString {
	
	
	public static void main(String[] args) {
		String[] s = {
				"acxz",	// Funny
				"bcxz",	// Not Funny
				"ivvkxq",// Not Funny
				"ivvkx"	// Not Funny
				};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(funnyString(s[i]));
		}
		
	}

	/*
	 * String을 뒤집을 필요 없이 양 방향 끝부터 값의 차이를 비교한다.
	*/	
    static String funnyString(String s) {
    	
    	boolean isFunnty = true;
    	
    	for(int i=1; i<=s.length()/2; i++) {
    		
    		int asc = Math.abs(s.charAt(i-1) - s.charAt(i));
    		int desc = Math.abs(s.charAt(s.length()-1-i) - s.charAt(s.length()-i));
    		
    		if(asc != desc) {
    			isFunnty = false;
    			break;
    		}
    	}
    	
    	if(isFunnty) {
    		return "Funny";
    	}else {
    		return "Not Funny";
    	}
    	
	}

}
