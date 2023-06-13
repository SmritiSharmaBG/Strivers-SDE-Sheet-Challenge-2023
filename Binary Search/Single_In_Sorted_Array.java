// ACCEPTED CODE ON LEETCODE : https://leetcode.com/problems/single-element-in-a-sorted-array/description/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 2;
        int mid = (start + end) / 2;

        while (start <= end) {
            mid = (start + end) / 2;

            if (nums[mid] == nums[mid ^ 1]) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }
}
