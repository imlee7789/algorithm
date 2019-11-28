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

	// 1. �� ���ĺ��� ������ ���Ѵ�.
	// 2. ��ġ�� ���ĺ��� ���� ����.
	// 3. sum(subs1) == sum(subs2) �̹Ƿ� (���ڼ��� ������) �� �� �ϳ��� ���� ���ϸ� �ȴ�. 
    static int anagram(String s) {
    	if(s.length()%2 != 0) {
    		return -1;
    	}

    	int[] subs1 = new int['z'-'a'+1];
    	int[] subs2 = new int['z'-'a'+1];
    	int answer = 0;
    	
    	//�������� ���ڿ��� �� ���� ���� ī����
    	for(int i=0; i<s.length()/2; i++) {
    		subs1[s.charAt(i)-'a']++;
    		subs2[s.charAt(s.length()/2 + i)-'a']++;
    	}

    	//�� ���� ������ ���̴� �ٲ�� �� ����
    	//����� �� subs1�� �ٲ�� �� �����̰�,
    	//������ �� subs2�� �ٲ�� �� ������.
    	//���� ����� ���� ī��Ʈ�Ѵ�.
    	for(int i=0; i<subs1.length; i++) {
    		
    		int diff = subs1[i] - subs2[i];
    		
    		if(diff > 0) {
    			answer += diff; 
    		}
    	}
    	
    	return answer;
    }
	
}
