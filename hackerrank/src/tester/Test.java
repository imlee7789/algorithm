package tester;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		// int 배열 > IntStream
		int[] arr = {43, 1, 62, 1, 71, 1, 94, 1, 39, 1, 47, 1, 20, 1, 95, 1, 84, 1, 49, 1, 51, 1, 80, 1, 96, 1, 96, 1, 72};
		int sum = Arrays.stream(arr).sum();
		int rangeSum = Arrays.stream(arr, 0, 4).sum();
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		double avg = Arrays.stream(arr).average().getAsDouble();
		/* arr를 리버스 정렬하는 stream.. 안쓸거같은데 */
		int[] arr2 = Arrays.stream(arr).mapToObj(n -> (Integer)n).sorted((a,b)->(b-a)).mapToInt(n->(int)n).toArray();
		
	}
}
