import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        Arrays.sort(arr);
        ArrayList<Integer> ds = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        rec(ans, ds, 0, arr);
        return ans;
    }

    private static void rec(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> ds, int index, int[] arr) {
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < arr.length; i ++) {
            if (i != index && arr[i] == arr[i - 1]) continue;
            ds.add(arr[i]);
            rec(ans, ds, i + 1, arr);
            ds.remove(ds.size() - 1);
        }
    }
}
