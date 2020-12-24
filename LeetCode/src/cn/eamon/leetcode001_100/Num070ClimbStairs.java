package cn.eamon.leetcode001_100;

/**
 * @Author: Eamon
 * @Description:
 * @Date: 2020/12/24 14:39
 */
public class Num070ClimbStairs {

    /**
     *  动态规划
     */
    public int climbStairs(int n) {
        if( n <= 3){
            return n;
        }
        int x = 1, y = 2 , z = 3;
        for(int i = 3; i <= n; i++){
            z = x + y;
            x = y;
            y = z;
        }
        return z;
    }
}
