package weekThree;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Number  15  三数之和
 *
 * @author Ye-Ma
 */
public class Number15三数之和 {

    /**
     * 给你一个包含 n 个整数的数组 nums，
     * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     */
    public static void main(String[] args) {
        // 重点  结果等于 0的情况  返回的是list  所有结果情况 不重复情况
        // 考虑 递归解决这个问题  规律     三数  是基于两数
        // 使用双指针 一个不动 利用其他的两位   居中位移动

        // [-1,0,1,2,-1,-4]

        List<List<Integer>> lists = threeSums(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("结果是:->" + lists.toString());
        //

    }

    /**
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * <p>
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        // hash
        // 计算 是否有0
        // 木有零的情况  分析是否  两数 = 0 的情况

        // 结果
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
     /*   HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sky = 0;
        for (int num : nums) {
            if (num == 0) {
                sky++;
            }
            map.put(num, 0);
        }
        // 判断是否  key>0的时候
        if (sky > 0) {
            for (int num : nums) {
                if (map.containsKey(-num)) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(0);
                    list.add(num);
                    list.add(-num);
                    lists.add(list);
                }
            }
        }
        if (sky == 3) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(0);
            list.add(0);
            list.add(0);
            lists.add(list);
        }*/
        
      /*  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sky = 0;
        for (int num : nums) {
            if (num == 0) {
                sky++;
            }
            map.put(num, 0);
        }*/

        for (int i = 0; i < nums.length; i++) {
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                int i2 = nums[i1] + nums[i];
                for (int i3 = i1 + 1; i3 < nums.length; i3++) {
                    if (nums[i3] + i2 == 0) {
                        if (nums[i] != nums[i1] || nums[i1] != nums[i3]) {

                        }
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[i1]);
                        list.add(nums[i3]);
                        lists.add(list);
                    }
                }
            }
        }
        // 判断 是否其他的  两数字等于 + 自己=0
        return lists;
    }


    public static List<List<Integer>> threeSums(int[] nums) {
        // 优先进行排序
        Arrays.sort(nums);
        ArrayList<List<Integer>> ls = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过可能重复的答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }
        }
        return ls;
    }


    /**
     * 三数之和
     *
     * @param nums 数组
     * @return 结果集合
     */
    public List<List<Integer>> threeSumTwo(int[] nums) {
        // 排序
        // 计算  两数之和   + i =0
        // 双指针  引用
        // 符合条件的合并


        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums == null) {
            return lists;
        }

        Arrays.parallelSort(nums);
        System.out.println(Arrays.toString(nums));

/*        for (int i = 0; i < nums.length; i++) {
            // 判断 开始的起点   i>0  和 [i] != [i-1]
            if (nums[i] > 0 && (nums[i] != nums[i - 1])) {
                // 双指针
                int ii = 0, i2=nums.length-1,sum = - nums[i];
                while (ii
                6668888)


            }
        }*/

        return lists;
    }

}
