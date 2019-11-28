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
	
	// �� ���� ���� �����Ѱ��� ���� ������.
	// 'abcd'�� �ִٸ� �� a,b,c,d�� ������ ���ڿ��� ���ԵǹǷ� �߰� ������ �ʿ䰡 ����.
	
	// ** ������ ����������, �ᱹ�� �� ���� ���ڷ� �Ǿ��ִ°� �̴�.
    static int stringConstruction(String s) {
    	
    	long cnt = s.chars().distinct().count();
    	
    	return (int)cnt;
    }
    
}
