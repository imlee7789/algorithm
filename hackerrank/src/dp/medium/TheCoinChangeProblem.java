package dp.medium;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

	
    public static long getWays(int n, List<Long> c) {

    	long[] numways = new long[n+1];
    	
    	numways[0] = 1;
    	
    	for (int i = 0; i < c.size(); i++) {
    		int cn = (int) (long) c.get(i);
    		
    		for (int j = cn; j <= n; j++) {
    			numways[j] += numways[j - cn];
    		}
    	}
    
    	return numways[n];
    }

}

public class TheCoinChangeProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Long> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = Result.getWays(n, c);

        System.out.println(String.valueOf(ways));

        bufferedReader.close();
    }
}
