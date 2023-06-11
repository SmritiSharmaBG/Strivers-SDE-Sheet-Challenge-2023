import java.io.*;
import java.util.* ;

public class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      Arrays.sort(arr);
      String yes = "Yes";
      String no = "No";
      
      for (int i = 0; i < (n - 3); i ++) {
        for (int j = i + 1; j < (n - 2); j ++) {
          int sum = arr[i] + arr[j];
          int rem = target - sum;
          //if (rem < 0) return no; // target is too small - this makes -ve TC fail.
          int left = j + 1;
          int right = n - 1;
          while (left < right) {
            int sum2 = arr[left] + arr[right];
            if (sum2 == rem) return yes;
            if (sum2 < rem) left ++;
            else if (sum2 > rem) right --;
          } // while
        } // j loop
      } // i loop
      return no;
  } // func
}
