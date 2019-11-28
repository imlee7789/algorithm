package strings.easy;

public class Anagram {
	
	public static void main(String[] args) {
		String[] s = {
				"aaabbb",
				"ab",
				"abc",
				"mnop",
				"xyyx",
				"xaxbbbxx"
		};
		
		int[] a = {
				3,
				1,
				-1,
				2,
				0,
				1
		};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(anagram(s[i]) + " ?= " + a[i]);
		}
	}

	// 1. 각 알파벳의 개수를 구한다.
	// 2. 겹치는 알파벳의 수를 뺀다.
	// 3. sum(subs1) == sum(subs2) 이므로 (글자수가 같으니) 둘 중 하나의 합을 구하면 된다. 
    static int anagram(String s) {
    	if(s.length()%2 != 0) {
    		return -1;
    	}

    	int[] subs1 = new int['z'-'a'+1];
    	int[] subs2 = new int['z'-'a'+1];
    	int answer = 0;
    	
    	//나누어진 문자열의 각 문자 개수 카운팅
    	for(int i=0; i<s.length()/2; i++) {
    		subs1[s.charAt(i)-'a']++;
    		subs2[s.charAt(s.length()/2 + i)-'a']++;
    	}

    	//각 문자 개수의 차이는 바꿔야 할 개수
    	//양수일 때 subs1의 바꿔야 할 개수이고,
    	//음수일 때 subs2의 바꿔야 할 개수다.
    	//따라서 양수일 때만 카운트한다.
    	for(int i=0; i<subs1.length; i++) {
    		
    		int diff = subs1[i] - subs2[i];
    		
    		if(diff > 0) {
    			answer += diff; 
    		}
    	}
    	
    	return answer;
    }
	
}
