package weekSeven.everyDay;

import java.math.BigDecimal;

/**
 * @author Ye-Ma
 */
public class EveryDay330按要求补齐数组 {

    public static void main(String[] args) {
        int i = minPatchesAnalysis(new int[]{1, 3}, 6);
        System.out.println(i);
    }


    /**
     * 官方题解   使用贪心进行处理   x-1 可以合并的数  在 2x-1也是可以进行合并的
     * 按要求补齐数组
     *
     * @param nums 数组
     * @param n    目标值  贪心解决问题
     * @return 返回结果
     */
    public static int minPatchesAnalysis(int[] nums, int n) {
        // 重点  组合的 数组和  目标值       区间里所有的数

        // 重点的 理论是 对于正整数 x，如果区间 [1,x−1] 内的所有数字都已经被覆盖，且 x 在数组中，
        // 则区间 [1,2x−1] 内的所有数字也都被覆盖。证明如下

        // 贪心的方案。每次找到未被数组 nums 覆盖的最小的整数 x，在数组中补充 x
        // 然后寻找下一个未被覆盖的最小的整数，
        // 重复上述步骤直到区间 [1,n] 中的所有数字都被覆盖。


        int patches = 0;
        // x从1开始
        long x = 1;
        // 长度= 数组的个数
        int length = nums.length, index = 0;
        // x从1 开始
        while (x <= n) {
            if (index < length && nums[index] <= x) {
                x += nums[index];
                index++;
            } else {
                x *= 2;
                patches++;
            }
        }
        return patches;
    }


    /**
     * 贪心进行处理
     *
     * @param nums
     * @param n
     * @return
     */
    public static int minPatchesOne(int[] nums, int n) {
        //累加的总和
        long total = 0;
        //需要补充的数字个数
        int count = 0;
        //访问的数组下标索引
        int index = 0;
        while (total < n) {
            if (index < nums.length && nums[index] <= total + 1) {
                //如果数组能组成的数字范围是[1,total]，那么加上nums[index]
                //就变成了[1,total]U[nums[index],total+nums[index]]
                //结果就是[1,total+nums[index]]
                total += nums[index++];
            } else {
                //添加一个新数字，并且count加1
                total = total + (total + 1);
                count++;
            }
        }
        return count;
    }

    public static int minPatchesTwo(int[] nums, int n) {
        // 累加的总和
        long total = 0;
        // 计数器       指标位置
        int count = 0, index = 0;
        while (total < n) {
            // 限制
            if (index < nums.length && nums[index] <= total+1) {
               total += nums[index++];
                continue;
            }
            // 数字进行增加
            total = total + (total + 1);
            count++;
        }
        return count;

    }


}
