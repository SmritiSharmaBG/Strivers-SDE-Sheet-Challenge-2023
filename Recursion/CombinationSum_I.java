import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        rec(arr, n, ans, new ArrayList<Integer>(), k, 0, 0);
        return ans;
    }

    private static void rec(ArrayList<Integer> arr, int n, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int k, int index, int sum) {
        if (index == n) {
            if (sum == k) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // not take
        rec(arr, n, ans, ds, k, index + 1, sum);
        // take
        int element = arr.get(index);
        ds.add(element);
        rec(arr, n, ans, ds, k, index + 1, sum + element);
        ds.remove(ds.size() - 1);
    }
}
