package cn.eamon.leetcode001_100;

import java.util.HashMap;

/**
 * @Author: Eamon
 * @Description: 无重复字符的最长子串
 * @Date: 2020/12/1 20:23
 */
public class Num003LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // 滑动窗口
        for (int start = 0, end = 0; end < len; end++) {
            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }
            max = Math.max(max, end - start + 1);
            map.put(c, end + 1);
        }
        return max;
    }
}
