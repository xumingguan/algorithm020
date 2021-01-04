package weekSix;

public class Number121买卖股票的最佳时机 {
    public static void main(String[] args) {

    }

    /*
    1 最低的时候的购买
    2 最高的时候出售
    寻找最低的值    在后找最高的值 计算后面的差价
    还是  DP 的题目



    记录【今天之前买入的最小值】
    计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
    比较【每天的最大获利】，取最大值即可

    *
    * */

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public int maxProfitTwo(int[] prices) {
        //长度的判断
        if (prices.length <= 1) {
            return 0;
        }
        int min = prices[0], max = 0;

        // 设置  max dp[0] 和 min
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(prices[i], min);
        }
        return max;
    }

    /*
    DP的思路： 利用原问题与子问题的关系，
    将其变成 大问题的解 = 小问题的解的函数，
    从而将问题变成size的扩展即可，当size到达最大后，原问题解决了
    DP的keypoint
    转移方程（大问题与小问题的关系）
    * */

    public int maxProfitThree(int[] prices) {
        return 1;
    }

    public static class Solution {

        public static void main(String[] args) {
            // 7,1,5,3,6,4
            System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

            System.out.println("打印结果的值是"+3 % 2);

        }


        /**
         * 使用 二维数组来设计
         *
         * @param prices 股票的价格
         * @return 结果
         */
        public static int maxProfit(int[] prices) {
            int len = prices.length;
            // 特殊判断
            if (len < 2) {
                return 0;
            }
            int[][] dp = new int[len][2];

            // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
            // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

            // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            // 从第 2 天开始遍历
            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
            return dp[len - 1][0];
        }

        // 滚动数组
        public static int maxProfitTwo(int[] prices) {

            int len = prices.length;
            if (len < 2) {
                return 0;
            }

            int[][] dp = new int[2][2];
            dp[0][0] = 0;
            dp[0][1] = -prices[0];
            for (int i = 1; i < len; i++) {
                dp[i % 2][0] = Math.max(dp[(i - 1) % 2][0], dp[(i - 1) % 2][1] + prices[i]);
                dp[i % 2][1] = Math.max(dp[(i - 1) % 2][1], -prices[i]);
            }
            return dp[(len - 1) & 1][0];
        }


    }


}

