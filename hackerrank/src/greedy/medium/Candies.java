package greedy.medium;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Candies {

	// 풀이 방법
	// 1. 정방향으로 값이 커질 때 값이 커진 것을 기록.
	// 2. 역방향으로 값이 연속으로 작아질 때 값 보정
	// 효율성 = O(2N)

	// 개선 여지
	// descCnt를 기록하면 N번으로 가능하지 않을까 싶다.
	// 효율성 = O(N)
	static long candies(int n, int[] arr) {

		long[] candies = new long[n];
		candies[0] = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i - 1] < arr[i]) {
				candies[i] = candies[i - 1] + 1;
			} else {
				candies[i] = 1;
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			if (candies[i - 1] <= candies[i] && arr[i - 1] > arr[i]) {

				candies[i - 1] = candies[i] + 1;
			}
		}

		return Arrays.stream(candies).sum();
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			int arrItem = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			arr[i] = arrItem;
		}

		long result = candies(n, arr);

		System.out.println(String.valueOf(result));

		scanner.close();
	}
}
