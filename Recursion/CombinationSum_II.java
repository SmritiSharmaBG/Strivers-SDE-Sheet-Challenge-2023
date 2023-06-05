import java.util.ArrayList;
import java.util.*;

public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        Collections.sort(arr);
        rec(ans, ds, arr, 0, target, 0, n);
        return ans;
    }

    private static void rec(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, ArrayList<Integer> arr, int index, int target, int sum, int n) {
        if (sum == target || index == n) {
            if (sum == target) ans.add(new ArrayList<>(ds));
            return;
        }
        for (int i = index; i < n; i++) {
            if (i != index && arr.get(i) == arr.get(i - 1)) continue;
            int element = arr.get(i);
            if (element + sum > target) break;
            ds.add(element);
            rec(ans, ds, arr, i + 1, target, sum + element, n);
            ds.remove(ds.size() - 1);
        }
    }
}
