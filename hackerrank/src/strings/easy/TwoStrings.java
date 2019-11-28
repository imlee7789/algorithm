package strings.easy;

public class TwoStrings {

	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		
		System.out.println(twoStrings(s1, s2));
	}

    static String twoStrings(String s1, String s2) {
    	
    	boolean[] dict = new boolean[26];

    	for(char c : s1.toCharArray()) dict[c - 'a'] = true;
    	
    	for(char c : s2.toCharArray()) {
    		if(dict[c - 'a']) {
    			return "YES";
    		}
    	}
    	
		return "NO";
    }
    
    // æ÷√ ø° ...
    static String twoStrings2(String s1, String s2) {
    	
    	for(int i='a'; i<='z'; i++) {
    		if(s1.indexOf(i) > -1 && s2.indexOf(i) > -1) {
    			return "YES";
    		}
    	}
    	
		return "NO";
    }
    
}
