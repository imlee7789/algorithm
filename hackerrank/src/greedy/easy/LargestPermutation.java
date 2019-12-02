package greedy.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LargestPermutation {

	public static void main(String[] args) {
		int[][] arr = {
				{145, 161, 11, 116, 64, 85, 158, 167, 125, 14, 104, 34, 15, 119, 51, 118, 63, 188, 166, 113, 114, 194, 126, 53, 133, 109, 48, 40, 32, 52, 108, 62, 153, 105, 44, 129, 89, 186, 45, 73, 115, 66, 130, 56, 141, 197, 36, 192, 107, 24, 22, 152, 81, 137, 111, 101, 100, 144, 9, 16, 31, 154, 198, 159, 70, 179, 50, 172, 39, 155, 79, 37, 87, 69, 121, 134, 93, 7, 5, 17, 110, 122, 96, 103, 177, 193, 95, 33, 164, 71, 143, 82, 77, 75, 162, 191, 102, 19, 91, 94, 157, 184, 35, 23, 99, 180, 182, 6, 59, 176, 146, 13, 165, 135, 3, 4, 195, 112, 189, 30, 27, 168, 123, 41, 57, 136, 190, 29, 132, 76, 38, 1, 10, 83, 124, 163, 20, 117, 178, 2, 42, 84, 12, 171, 67, 43, 58, 183, 8, 138, 68, 149, 131, 47, 74, 60, 80, 90, 78, 160, 169, 21, 61, 187, 92, 25, 181, 147, 88, 106, 55, 97, 150, 120, 128, 139, 140, 175, 26, 127, 173, 185, 65, 196, 86, 28, 98, 54, 142, 18, 151, 46, 49, 170, 174, 156, 148, 72}
			};
		
		int[] k = {
				162
			};
		
		for(int i=0; i<arr.length; i++) {
			int[] ma = largestPermutation(k[i], arr[i]);
			System.out.println(Arrays.toString(ma));
		}
	}
	
	// indexing의 중요성.
    static int[] largestPermutation(int k, int[] arr) {
    	
    	int[] indices = new int[arr.length+1];
        
        for(int i=0; i<arr.length; i++) {
        	indices[arr[i]] = i;
        }
        
        int idx = 0;
        int max = arr.length;
        while(k > 0 && idx < arr.length) {
        	if(arr[idx] < max) {
        		int maxIdx = indices[max];
        		int value = arr[idx];
        		// 값 변경
        		arr[maxIdx] = value;
        		arr[idx] = max;
        		
        		// indices 변경
        		indices[max] = idx;
        		indices[value] = maxIdx;
        		k--;
        	}
        	idx++;
        	max--;
        }
        
        return arr;

    }
    
    

	// original
    static int[] largestPermutation_original(int k, int[] arr) {
        
        int max = arr.length;
        
        List<Integer> list = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++) {
            list.add(arr[i]);
        }
        
        int idx = 0;
        while(k > 0 && idx<arr.length) {
        	if(list.get(idx) < max) {
        		int maxIdx = list.indexOf(max);
        		list.set(maxIdx, list.get(idx));
        		list.set(idx, max);
        		k--;
        	}
        	idx++;
        	max--;
        }

        for(int i=0; i<arr.length; i++) {
            arr[i] = list.get(i);
        }
        
        return arr;

    }
    
    
    // ref
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int n = input.nextInt();
//        int k = input.nextInt();
//        int[] a = new int[n];
//        int[] index = new int[n + 1];
//        for (int i = 0; i < n; i++) {
//            a[i] = input.nextInt();
//            index[a[i]] = i;
//        }
//        for (int i = 0; i < n && k > 0; i++) {
//            if (a[i] == n - i) {
//                continue;
//            }
//            a[index[n - i]] = a[i];
//            index[a[i]] = index[n - i];
//            a[i] = n - i;
//            index[n - i] = i;
//            k--; 
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(a[i] + " ");
//        }
//    }
//    }

}
