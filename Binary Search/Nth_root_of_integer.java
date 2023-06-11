public class Solution {
    public static int NthRoot(int n, int m) {
        int start = 1;
        int end = m;
        int mid = (start + end) / 2;

        while(start <= end) {
            mid = (start + end) / 2;
            int pow = (int)Math.pow(mid, n);
            if (pow == m) return mid;
            if (pow > m) end = mid - 1;
            if (pow < m) start = mid + 1;
        }
        return -1;
    }
}
