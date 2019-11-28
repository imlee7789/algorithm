package sorting.easy;

import java.io.IOException;
import java.util.Arrays;

public class BigSorting {

//	이 문제는 Scanner의 속도가 느려 case6가 계속 틀리는 문제였다.
//	private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		String[] unsorted = { "1", "2", "100", "12303479849857341718340192371", "12303479849857341718340192370",
				"3084193741082937", "3084193741082938", "111", "200" };

		String[] sorted = bigSorting(unsorted);

		System.out.println(Arrays.toString(sorted));

	}

	static String[] bigSorting(String[] unsorted) {

		Arrays.sort(unsorted, (s1, s2) -> {
			if (s1.length() != s2.length()) {
				return s1.length() - s2.length();

			} else {
				int r = 0;
				for (int i = 0; i < s1.length(); i++) {
					if (s1.charAt(i) != s2.charAt(i)) {
						r = s1.charAt(i) - s2.charAt(i);
						break;
					}
				}
				return r;
			}

		});

		return unsorted;
	}

}
