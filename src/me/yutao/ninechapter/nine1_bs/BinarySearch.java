package me.yutao.ninechapter.nine1_bs;

/**
 * Created by yutao on 6/27/15.
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] nums = new int[] {0, 1, 4, 5, 6, 7, 8, 24};
        int target = 1;

        System.out.println(bs.binarySearch_3(nums, target));
    }

    /*
    3 problems
    index out of bound
    dead loop
    return before finding the target
    */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle;
            } else {
                end = middle;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    public int binarySearch_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        return -1;
    }

    public int binarySearch_3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        return binarySearch_3(nums, start, end, target);
    }

    public int binarySearch_3(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] == target) {
            return middle;
        } else if (nums[middle] < target) {
            return binarySearch_3(nums, middle + 1, end, target);
        } else {
            return binarySearch_3(nums, start, middle - 1, target);
        }

    }
}
