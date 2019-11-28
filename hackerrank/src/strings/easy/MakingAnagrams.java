package strings.easy;

public class MakingAnagrams {

	public static void main(String[] args) {
		String s1 = "cde";
		String s2 = "abc";
		
		System.out.println(makingAnagrams_Optimaized_beautify(s1, s2));
	}
	
    static int makingAnagrams(String s1, String s2) {
    	
    	int answer = 0;
    	
    	int[] alpCnt1 = new int[26];
    	int[] alpCnt2 = new int[26];

    	for(int i=0; i<s1.length(); i++) {
    		alpCnt1[s1.charAt(i) - 'a']++; 
    	}
    	
    	for(int i=0; i<s2.length(); i++) {
    		alpCnt2[s2.charAt(i) - 'a']++; 
    	}
    	
    	for(int i=0; i<26; i++) {
    		answer += Math.abs(alpCnt1[i] - alpCnt2[i]);
    	}

    	return answer;
    }
	
    
    // 공간 효율성 증가
    // 26 * 4bytes를 아꼈다.
    static int makingAnagrams_Optimaized(String s1, String s2) {
    	
    	int answer = 0;
    	
    	int[] alpCnt = new int[26];

    	for(int i=0; i<s1.length(); i++) {
    		alpCnt[s1.charAt(i) - 'a']++; 
    	}
    	
    	for(int i=0; i<s2.length(); i++) {
    		alpCnt[s2.charAt(i) - 'a']--;
    	}
    	
    	for(int i=0; i<26; i++) {
    		answer += Math.abs(alpCnt[i]);
    	}

    	return answer;
    }

    // 자바의 enhanced-for를 사용한 가독성 좋은 코드.
    // length를 확인하지 않아서 더 좋다는데 정말 좋을 것인가?
    static int makingAnagrams_Optimaized_beautify(String s1, String s2) {
    	
    	int countSum = 0;
    	
    	int[] alpCnt = new int[26];

    	for(char c : s1.toCharArray()) alpCnt[c - 'a']++;
    	
    	for(char c : s2.toCharArray()) alpCnt[c - 'a']--;
    	
    	for(int n : alpCnt) countSum += Math.abs(n);

    	return countSum;
    }
    
}
