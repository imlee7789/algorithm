package search.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SherlockAndArray {

	public static void main(String[] args) {
		
		List<Integer[]> arr = new ArrayList<>();
			arr.add(new Integer[] {1, 1, 4, 1, 1});
			arr.add(new Integer[] {2, 0, 0, 0});
			arr.add(new Integer[] {0, 0, 2, 0});
			arr.add(new Integer[] {1, 2, 3});
			arr.add(new Integer[] {1, 2, 3, 3});
			
		String[] a = {
				"YES",
				"YES",
				"YES",
				"NO",
				"YES"
			};
		
		for(int i=0; i<a.length; i++) {
			
			String r = balancedSums(Arrays.asList(arr.get(i)));
			System.out.println(r);
			System.out.println(a[i]);
		}
		
	}

    static String balancedSums2(List<Integer> arr) {
    	
        for(int pivot=0; pivot<arr.size(); pivot++){
            int presum = 0;
            int aftersum = 0;
            
            for(int i=0; i<pivot; i++){
                presum += arr.get(i);
            }
            for(int j=pivot+1; j<arr.size(); j++){
                aftersum += arr.get(j);
                if(aftersum > presum) {
                	break;
                }
            }
            if(presum == aftersum){
                return "YES";
            }
        }

        return "NO";
    }
    
    static String balancedSums(List<Integer> arr) {
    	int presum = 0;
    	int aftsum = arr.subList(1, arr.size()).stream().mapToInt(n->(int)n).sum();
    	
        for(int pivot=0; pivot<arr.size(); pivot++){
            if(presum == aftsum){
                return "YES";
                
            }
            if(presum > aftsum){
            	break;
            	
            }else{
            	presum += arr.get(pivot);
            	aftsum -= arr.get(pivot+1); 
            }
        }

        return "NO";
    }
}
