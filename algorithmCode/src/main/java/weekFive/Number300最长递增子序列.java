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
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        //  处理 数据 利用归纳思想
        for (int i = 0; i < nums.length; i++) {
            //  后者和 前者进行比较 大小  设置  dp[i]的值
            for (int x = 0; x < i; x++) {
                if (nums[i] > nums[x]) {
                    dp[i] = Math.max(dp[i], dp[x] + 1);
                }
            }
        }
        // dp  寻找max 值
        int max = 1;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i], max);
        }
        // 返回结果
        return max;
    }


    /**
     * 二分查找
     *
     * @param nums 数组
     * @return 返回结果
     */
    public static int lengthOfLISTwo(int[] nums) {
        // 创建数组
        int[] top = new int[nums.length];
        // 设置 牌堆的 设置默认值 0
        int piles = 0;
        // int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];
            // 左侧边界的二分搜索
            int left = 0, right = piles;

            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 找到  合适的牌堆,新建一堆
            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }


}
