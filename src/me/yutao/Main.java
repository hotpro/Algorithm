package me.yutao;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] nums = new int[] {1, 2};
        changeArray(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void changeArray(int[] nums) {
        nums[0] = 3;
    }

}
