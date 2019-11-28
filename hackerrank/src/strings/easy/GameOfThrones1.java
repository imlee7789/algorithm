package strings.easy;

public class GameOfThrones1 {
	
	public static void main(String[] args) {
		String[] s = {
				"aaabbbb",
				"cdefghmnopqrstuvw",
				"cdcdcdcdeeeef"
		};
		
		String[] r = {
				"YES",
				"NO",
				"YES"
		};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(gameOfThrones(s[i]) + " ?= " + r[i]);
		}
	}

	// 대칭이지만 1개만 홀수가 가능하다.
    static String gameOfThrones(String s) {
    	
    	int[] dict = new int[26];
    	int oddCnt = 0;
    	
    	for(char c : s.toCharArray()) {
    		dict[c - 'a']++;
    	}
    	
    	for(int i=0; i<dict.length; i++) {
    		if(dict[i]%2 != 0) {
    			oddCnt++;
    		}
    		if(oddCnt>1) {
    			return "NO";
    		}
    	}

    	return "YES";
    }

}
