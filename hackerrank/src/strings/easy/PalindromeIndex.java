package strings.easy;

public class PalindromeIndex {

	public static void main(String[] args) {
		String[] s = {
				"aaab",
				"baa",
				"aaa",
				"quyjjdcgsvvsgcdjjyq",
				"hgygsvlfwcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcflvsgygh",
				"fgnfnidynhxebxxxfmxixhsruldhsaobhlcggchboashdlurshxixmfxxxbexhnydinfngf",
				"bsyhvwfuesumsehmytqioswvpcbxyolapfywdxeacyuruybhbwxjmrrmjxwbhbyuruycaexdwyfpaloyxbcpwsoiqtymhesmuseufwvhysb",
				"fvyqxqxynewuebtcuqdwyetyqqisappmunmnldmkttkmdlnmnumppasiqyteywdquctbeuwenyxqxqyvf",
				"mmbiefhflbeckaecprwfgmqlydfroxrblulpasumubqhhbvlqpixvvxipqlvbhqbumusaplulbrxorfdylqmgfwrpceakceblfhfeibmm",
				"tpqknkmbgasitnwqrqasvolmevkasccsakvemlosaqrqwntisagbmknkqpt",
				"lhrxvssvxrhl",
				"prcoitfiptvcxrvoalqmfpnqyhrubxspplrftomfehbbhefmotfrlppsxburhyqnpfmqlaorxcvtpiftiocrp",
				"kjowoemiduaaxasnqghxbxkiccikxbxhgqnsaxaaudimeowojk",
				"hgygsvlfcwnswtuhmyaljkqlqjjqlqkjlaymhutwsnwcwflvsgygh"
				};
		
		int[] r = {
				3,
				0,
				-1,
				1,
				8,
				33,
				23,
				25,
				44,
				20,
				-1,
				14,
				-1,
				44
				};
		
		for(int i=0; i<s.length; i++) {
			System.out.println(palindromeIndex(s[i]) + " ?= " + r[i]);
		}
		
	}

    static int palindromeIndex(String s) {
    	
    	int idx = -1;
    	boolean isFound = false;
    	
    	for(int i=0, j=s.length()-1; 
    			i<s.length()/2; 
    			i++, j--) {
    		
    		if(s.charAt(i) != s.charAt(j)) {
    			
    			if(isFound) {
    				// 2-1. i+1+n, j+n�� ������ ���Ѵ�.
    				//      �� �߿� Ʋ������ �ϳ� �� �ִٸ� (1)���� j�� ����� �ߴٴ� �ǹ̴�.
    				//      �׷��Ƿ� Ʋ���� ��� idx������ j(s.length()-1-i)�� ��ȯ�Ѵ�.
    				idx = s.length()-1-idx;
    				break;
    				
    			}else {
    				// 1. ó�� Ʋ����ġ iȤ�� j�� ���ŵž��� �ε�����.
    				//    j�� �����Ͽ� ���� �ݺ� ������ i+1�� j�� ���ϵ��� �Ѵ�.
    				isFound = true;
    				idx = i;
    				j++;
    			}
    		}
    	}

    	return idx;
    }
	
}
