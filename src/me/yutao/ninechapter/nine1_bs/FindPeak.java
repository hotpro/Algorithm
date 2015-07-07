package me.yutao.ninechapter.nine1_bs;

/**
 * Created by yutao on 7/6/15.
 *
 * Find Peek
 *
 * 查找峰值。假设有一个数组,相邻两数都不相等，且A[0]<A[1], A[length-2] > A[length-1] 。
 * 如果A[i] > A[i-1] && A[i] > A[i+1]，那么认为A[i]是一个峰值。数组中可能存在多个峰值。
 * 给定A，找到任意一个峰值。
 */
public class FindPeak {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 20, 4, 1, 0};
        FindPeak find = new FindPeak();
        System.out.println(find.findPeakValue(nums));

    }

    public int findPeakValue(int[] nums) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        if (nums.length == 3) {
            return nums[1];
        }

        int start = 1;
        int end = nums.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > nums[start - 1] && nums[start] > nums[start + 1]) {
            return nums[start];
        }

        if (nums[end] > nums[end - 1] && nums[end] > nums[end + 1]) {
            return nums[end];
        }

        return -1;
    }
}
