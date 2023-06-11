public class Solution {
    public static double median(int[] a, int[] b) {
    	// using 3rd array -- Gives TLE
        // return method1(a, b);

        return method2(a, b);
    }



    private static double method2(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        if (n1 > n2) return method2(b, a);
        int half = (n1 + n2 + 1) / 2;
        int start = 0;
        int end = n1;
        int mid = (start + end) / 2;
        double median = 0d;
        
        while (start <= end) {
            mid = (start + end) / 2;
            int cut1 = mid;
            int cut2 = half - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : a[cut1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
            int right2 = cut2 == n2 ? Integer.MIN_VALUE : b[cut2];
            
            // VALID PARTITION
            if (left1 <= right2 && left2 <= right1) {
                // if even, there are 2 medians
                if ((n1 + n2) % 2 == 0) {
                    median = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else median = Math.max(left1, left2);
                return median;
            }
            
            if (left1 > right2) end = cut1 - 1;
            else if (left2  > right1) start = cut1 + 1;
        } // while
        return median;
    }


    private static double method1(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int sum = n1 + n2;
        int pos1 = 0;
        int pos2 = 0;
        int[] c = new int[sum];
        int pos = 0;
        
        while (pos1 < n1 && pos2 < n2) {
            if (a[pos1] < b[pos2]) {
                c[pos] = a[pos1];
                pos1 ++;
                pos ++;
            } else {
                c[pos] = b[pos2];
                pos2 ++;
                pos ++;
            }
        } // while
        if (pos1 >= n1) { // a is exhusted
            while (pos2 < n2) {
                c[pos] = b[pos2];
                pos2 ++;
                pos ++;   
            }
        } else if (pos2 >= n2) { // b is exhausted
            while (pos1 < n1) {
                c[pos] = a[pos1];
                pos1 ++;
                pos ++;   
            }
        }
        int medianPos = sum / 2; 
        // even has 2 medians
        if (sum % 2 == 0) {
            double m = c[medianPos - 1] + c[medianPos];
            m = m / 2;
            return m;
        }
        return c[medianPos];
    }
}
