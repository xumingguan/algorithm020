package weekFive;

public class Number300最长递增子序列 {
    public static void main(String[] args) {
        int[] i = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLISOne(i));
    }

    public static int lengthOfLIS(int[] nums) {
        //  条件限制
        if (nums.length == 0) {
            return 0;
        }

        // 创建数组   设置默认的值
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 计算  动态规划的表格的值
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 设置  max 的值进行获取  dp 进行for 循环
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        // 返回结果
        return max;
    }

    public static int lengthOfLISOne(int[] nums) {
        // 条件限制
        if (nums.length == 0) return 0;
        // 创建 dp[i]

        return 1;


    }


}
