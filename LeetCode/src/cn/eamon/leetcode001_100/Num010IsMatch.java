package cn.eamon.leetcode001_100;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/7 17:28
 */
public class Num010IsMatch {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    } else {
                        if (matches(s, p, i, j)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        }
                    }
                }
            }
        }
        return dp[m][n];
    }

    private boolean matches(String s, String p, int left, int right) {
        if (left == 0) {
            return false;
        }
        if (p.charAt(right - 1) == '.') {
            return true;
        }
        return s.charAt(left - 1) == p.charAt(left - 1);
    }
}
