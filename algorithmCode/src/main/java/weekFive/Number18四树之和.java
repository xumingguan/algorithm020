package weekFive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ye-Ma
 */
public class Number18四树之和 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int index1 = 0; index1 < length - 3; index1++) {
            if (index1 > 0 && nums[index1] == nums[index1 - 1]) {
                continue;
            }
            /*
                已经排序完成了
                判断条件：
                    1、当前最小和 > target，结束“当前层循环”
                    2、当前最大和 < target，跳过“当前循环”
             */
            int curMin = nums[index1] + nums[index1 + 1] + nums[index1 + 2] + nums[index1 + 3];
            if (curMin > target) {
                break;
            }
            int curMax = nums[index1] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (curMax < target) {
                continue;
            }
            for (int index2 = index1 + 1; index2 < length - 2; index2++) {
                if (index2 > index1 + 1 && nums[index2] == nums[index2 - 1]) {
                    continue;
                }
                int index3 = index2 + 1;
                int maxIndex = length - 1;

                /*
                    判断条件
                        1、当前最小和 > target，结束“当前层循环”
                        2、当前最大和 < target，跳过“当前循环”
                 */
                curMin = nums[index1] + nums[index2] + nums[index3] + nums[index3 + 1];
                if (curMin > target) {
                    break;
                }
                curMax = nums[index1] + nums[index2] + nums[maxIndex] + nums[maxIndex - 1];
                if (curMax < target) {
                    continue;
                }
                while (index3 < maxIndex) {
                    // index3 为结果中 第3个值
                    int curValue = nums[index1] + nums[index2] + nums[index3] + nums[maxIndex];
                    if (curValue == target) {
                        result.add(Arrays.asList(nums[index1], nums[index2], nums[index3], nums[maxIndex]));
                        index3++;
                        while (index3 < maxIndex && nums[index3] == nums[index3 - 1]) {
                            index3++;
                        }
                        maxIndex--;
                        while (index3 < maxIndex && nums[maxIndex] == nums[maxIndex + 1]) {
                            maxIndex--;
                        }
                    } else if (curValue > target) {
                        maxIndex--;
                    } else {
                        index3++;
                    }
                }
            }
        }
        return result;
    }


    public static class Solution {
        public static void main(String[] args) {
           // canJump(new int[]{2,3,1,1,4});


            System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        }

        public static boolean canJump(int[] nums) {
            int n = nums.length;
            int count = 0;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                count = count+1;
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        System.out.println(count);
                        return true;
                    }
                }

            }
            return false;
        }


        public static int jump(int[] nums) {
            int n = nums.length;
            int count = 0;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                count = count+1;
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return count;
                    }
                }

            }
            return count;
        }


    }




}
