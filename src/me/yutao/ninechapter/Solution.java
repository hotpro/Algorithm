package me.yutao.ninechapter;

import java.util.HashSet;

/**
 * Created by yutao on 7/6/15.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int max = solution.lengthOfLongestSubstring("pwwkew");
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int leftBound = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                while (leftBound < i && s.charAt(leftBound) != c) {
                    set.remove(s.charAt(leftBound));
                    leftBound++;
                }
                leftBound++;
            } else {
                max = Math.max(max, i - leftBound + 1);
                set.add(c);
            }
        }

        return max;
    }
}
