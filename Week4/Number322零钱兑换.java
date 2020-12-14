package weekFour;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Number322 零钱兑换
 *
 * @author Ye-Ma
 */
public class Number322零钱兑换 {

/*    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        Arrays.sort(coins);
       //  Arrays.sort(coins, (o1, o2) -> o1 > o2 ? -1 : 1);

        System.out.println(Arrays.toString(coins));

        for (int i = coins.length-1; i >= 0; i--) {
            System.out.println(coins[i]);
        }

    }*/

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        // 考虑 coins 长度只有一的情况
        if (coins.length == 1) {
            int coin = coins[0];
            int value = amount / coin;
            if (value % 1 == 0) {
                return value;
            }
            return -1;
        }
        // amount 查看是否可以被整除(最大的数字) 拉其他的
        Arrays.sort(coins);

        int coin = coins[coins.length - 1];
        int maxValue = amount / coin;
        amount--;


        return -1;

    }


    static class Solution {
        public static void main(String[] args) {
            int[] ints = {1, 2, 5};
            coinChange(ints, 11);
        }


        public static int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            recursion(coins, amount, 0, coins.length - 1);
            return minCount == Integer.MAX_VALUE ? -1 : minCount;
        }

        static int minCount = Integer.MAX_VALUE;

        /**
         * 1、按金额从大到小，从多到少（排序，用余数一步到位）
         * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
         * 3、能整除即可返回
         */
        static void recursion(int[] coins, int amount, int count, int index) {
            // 终止条件
            if (index < 0 || count + amount / coins[index] >= minCount) return;
            // amount  除以 最大值  可以被整除的情况
            if (amount % coins[index] == 0) {
                minCount = Math.min(minCount, count + amount / coins[index]);
                return;
            }
            // 不能被整除  用零钱来凑单
            for (int i = amount / coins[index]; i >= 0; i--) {
                recursion(coins, amount - i * coins[index], count + i, index - 1);
            }
        }
    }

    static class SolutionTwo {

        public static void main(String[] args) {

        }

        public static int coinChangeTwo(int[] coins, int amount) {
            // 排序
            Arrays.sort(coins);
            // 递归
            // 零钱集合  目标值
            recursion(coins, amount, 0, coins.length - 1);
            return minCount == Integer.MAX_VALUE ? -1 : minCount;
        }

        // 零时变量
        static int minCount = Integer.MAX_VALUE;

        /**
         * 1、按金额从大到小，从多到少（排序，用余数一步到位）
         * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
         * 3、能整除即可返回
         */
        static void recursion(int[] coins, int amount, int count, int index) {
            if (index < 0 || count + amount / coins[index] >= minCount) return;

            // 可以直接解决
            if (amount / coins[index] == 0) {
                minCount = Math.min(minCount, count + amount / coins[index]);
                return;
            }

            for (int i = amount / coins[index]; i >= 0; i--) {

            }


        }


    }


}
