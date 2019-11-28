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
    				// 2-1. i+1+n, j+n을 끝까지 비교한다.
    				//      그 중에 틀린곳이 하나 더 있다면 (1)에서 j를 뺏어야 했다는 의미다.
    				//      그러므로 틀렸을 당시 idx기준의 j(s.length()-1-i)를 반환한다.
    				idx = s.length()-1-idx;
    				break;
    				
    			}else {
    				// 1. 처음 틀린위치 i혹은 j가 제거돼야할 인덱스다.
    				//    j를 조정하여 다음 반복 차수에 i+1과 j를 비교하도록 한다.
    				isFound = true;
    				idx = i;
    				j++;
    			}
    		}
    	}

    	return idx;
    }
	
}
