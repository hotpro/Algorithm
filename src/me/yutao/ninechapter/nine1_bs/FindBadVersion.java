package me.yutao.ninechapter.nine1_bs;

/**
 * Created by yutao on 7/6/15.
 *
 * 查找代码库的第一个坏版本。有一个SVN代码库，版本号从1到N，自从某个某人提交了他的代码之后，代码库就坏掉了程序跑不起来了，
 * 也就是自从某人提交的这个版本及之后的所有版本都是坏的代码版本。现在有一个接口，isBadVersion(int version)，
 * 可以用于判断version这个编号的代码是否是好的。请你利用这个接口，来找到某人提交的那个坏版本的编号。即，找到第一个i，
 * 使得isBadVersion(i-1) == false and isBadVersion(i) == true。
 */
public class FindBadVersion {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FindBadVersion find = new FindBadVersion();
        System.out.println(find.findBadVersion(nums));
    }

    public int findBadVersion(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (isBadVersion(nums[mid])) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isBadVersion(nums[start])) {
            return start;
        }

        if (isBadVersion(nums[end])) {
            return end;
        }

        return -1;
    }

    private boolean isBadVersion(int version) {
        return version >= 5;
    }
}
