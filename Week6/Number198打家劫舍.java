package weekSix;

public class Number198打家劫舍 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        // 非空的判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 长度的判断
        int length = nums.length;
        // 特殊情况的处理
        if (length == 1) {
            return nums[0];
        }
        // 创建dp 数组
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }

}
