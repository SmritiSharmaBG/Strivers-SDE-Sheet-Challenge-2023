import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        int n = num.length;
        ArrayList<Integer> ans = new ArrayList<>();
        rec(num, ans, 0, n, 0);
        Collections.sort(ans);
        return ans;
    }

    static void rec(int[] num, ArrayList<Integer> ans, int i, int n, int sum) {
        if (i == n) {
            ans.add(sum);
            return;
        }
        // not take
        rec(num, ans, i + 1, n, sum);
        // take
        rec(num, ans, i + 1, n, sum + num[i]);
    }
}
