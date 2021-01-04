package weekSix;

public class everyDaySubjectNum746使用最小花费爬楼梯 {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{0, 0, 0, 0}));
    }

    /**
     * 你可以选择继续爬一个阶梯或者爬两个阶梯。
     * 一次可以  一阶级  还是 二阶级   初始也是  索引为 0 或 1 的元素作为初始阶梯
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        //  需要定义  dp[i] 数组

        //  设置值
        int prev = 0, curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = next;
        }
        //  返回结果的数据从哪里获取
        return curr;
    }

    /**
     * @param cost
     * @return
     */
    public static int minCostClimbingStairsOne(int[] cost) {
        // 创建数组  一维
        int[] dp = new int[cost.length + 1];
        // 设置值
        for (int i = 0; i <= cost.length; i++) {
            if (i <= 1) {
                dp[i] = 0;
                continue;
            }
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        // 获取返回的值
        return dp[cost.length];
    }


}
