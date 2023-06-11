import java.io.*;
import java.util.* ;

public class Solution {
	public static int findMajority(int[] arr, int n) {
		// Use Moore's Voting algorithm

		int count = 0;
		int major = arr[0];
		for (int i = 0; i < n; i ++) {
			// count can be zero when : 
			// a. The loop has just started. b. There is no majority element candidate till now
			// in either case, the current element should be chosen as major candidate
			if (count == 0) major = arr[i];
			
			// now, if the current element is same as the candidate, increae count. 
			// otherwise decrease it as it its > half criteria is at risk
			if (arr[i] == major) count ++;
			else count --;
		}

		// Moore's voting algo can give false answer, so we need to cross check
		int freq = 0;
		for (int i = 0; i < n; i ++) {
			if (arr[i] == major) freq ++;
		}

		if (freq > (n / 2)) return major;
		return -1;
	}
}
