package strings.easy;

public class StringConstruction {

	public static void main(String[] args) {
		String[] s = {
				"abcd",
				"abab",
				"cbabbbababdcadabbcbcbacbbadaadbbdcdcbdaadbcbccccbdbbcbaaabbaacbbaabcbacadcaaabbcacdaaacdcaaccbdadaccdacbabdcbcdacbbddcdbbbcaaadacdaacdbacccbabcbdabbbadaccaaababcaabaccaabacdbcababbbaddccaccddadacccbcbbddcbccbcaadbcbbdcbcadaddbbbadbbccadcbddadcacacdcaacccdbdccacbddacacacdcbaadcbdaacbddcbbcbacbbabdacacccbbaccdccbbccacbdaadcbdcabbcdbbabcbdbddcbddcadbaacbbcdcacadbaadcbbcaddbbcbadddcabadbdbadcabbacaddbbdddbdaacddccdcdaccadadbaacddabbbddacbccbbcaabacaaddccccddaabbcacbccbbdddadaccdadbcabbabdbbcbbdbcdbcbcccdbbcdbdbdc"};
		
		int[] a = {
				4,
				2,
				4};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(stringConstruction(s[i]) + " ?= " + a[i]);
		}
				
	}
	
	// 몇 개로 압축 가능한가를 묻는 문제다.
	// 'abcd'가 있다면 각 a,b,c,d는 구입한 문자열에 포함되므로 추가 지불할 필요가 없다.
	
	// ** 설명은 복잡하지만, 결국은 몇 개의 문자로 되어있는가 이다.
    static int stringConstruction(String s) {
    	
    	long cnt = s.chars().distinct().count();
    	
    	return (int)cnt;
    }
    
}
