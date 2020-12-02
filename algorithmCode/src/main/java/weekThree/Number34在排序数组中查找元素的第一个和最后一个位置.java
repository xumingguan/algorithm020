package weekThree;

import java.util.Arrays;

/**
 * 可以 for  或者map
 *
 * @author Ye-Ma
 */
public class Number34在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {

        /**
         * 注意 审题  不让
         * 测试用例
         * 输入：nums = [5,7,7,8,8,10], target = 8
         * 输出：[3,4]  结果是坐标
         * */
        int[] ints = searchRangeTwo(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] searchRange(int[] nums, int target) {
        // 使用map来做
        if (nums.length == 1) {
            return nums[0] != target ? new int[]{-1, -1} : new int[]{0, 0};
        }
        int start = -1, coordinates = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                    coordinates = i;
                } else coordinates = i;
            }
        }
        return coordinates == 0 ? new int[]{-1, -1} : new int[]{start, coordinates};
    }

    public static int[] searchRangeTwo(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] != target ? new int[]{-1, -1} : new int[]{0, 0};
        }
        int start = 0, end = nums.length - 1, coordinate = -1, coordinateTwo = -1;
        //  使用while
        while (start < end && nums[start] <= target) {
            if (nums[start] < target) {
                start++;
            }
            if (nums[start] == target) {
                if (nums[start + 1] == target) {
                    return new int[]{start, start + 1};
                }
                return new int[]{-1, -1};
            }
        }
        return new int[]{-1, -1};
    }


    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int leftIdx = binarySearch(nums, target, true);
            int rightIdx = binarySearch(nums, target, false) - 1;
            if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
                return new int[]{leftIdx, rightIdx};
            }
            return new int[]{-1, -1};
        }

        public int binarySearch(int[] nums, int target, boolean lower) {
            int left = 0, right = nums.length - 1, ans = nums.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] > target || (lower && nums[mid] >= target)) {
                    right = mid - 1;
                    ans = mid;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }
    }


    public int[] searchRangeThree(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int[] i = new int[]{-1, -1};
        if (high == -1) {
            return i;
        }
        while (low < high) {
            // 两位指针都指向结果
            if (nums[low] == target & nums[high] == target) {
                return new int[]{low, high};
            }
            // 左指针 小于结果
            if (nums[low] < target) {
                low++;
            }
            // 右指针的进行判断  小于结果
            if (nums[high] > target) {
                high--;
            }
        }
        if (nums[low] == target & nums[high] == target) {
            i[0] = low;
            i[1] = high;
        }
        return i;
    }

}
