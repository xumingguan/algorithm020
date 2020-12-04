package weekThree;

import java.util.Arrays;

/**
 * Number 34
 * 可以 for  或者map
 *
 * @author Ye-Ma
 */
public class Number34在排序数组中查找元素的第一个和最后一个位置 {
/*
    public static void main(String[] args) {

        */

    /**
     * 注意 审题  不让
     * 测试用例
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]  结果是坐标
     *//*

        int[] ints = searchRangeTwo(new int[]{5, 7, 7, 8, 8, 10}, 8);
        System.out.println(Arrays.toString(ints));
    }
*/
    public static int[] searchRange(int[] nums, int target) {
        // 使用map来做
        int[] ii = {-1, -1};
        if (nums.length == 1) {
            return nums[0] != target ? ii : new int[]{0, 0};
        }
        int start = -1, coordinates = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                    coordinates = i;
                } else coordinates = i;
            }
        }
        return coordinates == -1 ? ii : new int[]{start, coordinates};
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

    public int[] searchRangeFour(int[] nums, int target) {
        int[] i = {-1, -1};
        // 考虑  nums == 1 的时候
        if (nums.length == 1) {
            if (i[0] == target) {
                return new int[]{0, 0};
            } else {
                return i;
            }
        }

        // 正常的for 循环开始
        int low = 0, high = nums.length - 1;

        while (low < high) {

            if (nums[low] == target && nums[high] == target) {
                i[0] = low;
                i[1] = high;
            }

            if (nums[low] < target) {
                low++;
            } else if (nums[high] > target) {
                high--;
            }
        }

        if (nums[low] == target && nums[high] == target) {
            i[0] = low;
            i[1] = high;
        }

        return i;
    }


    /**
     * 国际站
     *
     * @param nums   入参的数组
     * @param target 目标值
     * @return 坐标地址
     */
    public int[] searchRangeFive(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int targetIdx = binarySearch(nums, target, 0, nums.length - 1);
        if (targetIdx == -1) {
            return new int[]{-1, -1};
        } else {
            int sIdx = targetIdx;
            int eIdx = targetIdx;

            // 考虑 两种情况  比如   1234456789   4是从5  -开始的
            while (sIdx >= 1 && nums[sIdx - 1] == target) {
                sIdx--;
            }
            //   1234567889   如果 从正开始排  8的时候开始处理
            while (eIdx <= nums.length - 2 && nums[eIdx + 1] == target) {
                eIdx++;
            }
            return new int[]{sIdx, eIdx};
        }
    }





    public static int[] searchRangeTest(int[] nums, int target) {
        // 非空情况处理

        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        // 套路递归
        int searchThreeValue = binarySearchThree(nums, target, 0, nums.length);
        // 结果判断   多种情况
        if (searchThreeValue == -1) {
            return new int[]{-1, -1};
        } else if (nums.length == 1) {
            return new int[]{searchThreeValue, searchThreeValue};
        } else if (nums[searchThreeValue + 1] == target) {
            // 考虑 +1  和 -1 的情况
            return new int[]{searchThreeValue, searchThreeValue + 1};
        } else if (nums[searchThreeValue - 1] == target) {
            return new int[]{searchThreeValue - 1, searchThreeValue};
        }
        return new int[]{searchThreeValue, searchThreeValue};
    }


    private int binarySearch(int[] nums, int target, int sIdx, int eIdx) {
        if (sIdx > eIdx) {
            return -1;
        }
        // 开始二分查找
        int midIdx = (sIdx + eIdx) / 2;

        if (nums[midIdx] == target) {
            return midIdx;
        } else if (nums[midIdx] > target) {
            return binarySearch(nums, target, sIdx, midIdx - 1);
        } else {
            return binarySearch(nums, target, midIdx + 1, eIdx);
        }
    }


    /**
     * 1 终止条件
     * 2 业务逻辑
     * 3 自套
     * 4 售后处理
     */

    private int binarySearchTwo(int[] nums, int target, int sIdx, int eIdx) {
        //
        if (sIdx > eIdx) {
            return -1;
        }
        if (nums[sIdx] == target) {
            return sIdx;
        }
        //  开始折中计算  sidx  + eidx /2 midIdx
        int midIdx = (sIdx + eIdx) / 2;
        // 如果相等  直接返回 target
        if (nums[midIdx] == target) {
            return midIdx;
        } else if (nums[midIdx] < target) {
            // 如果 < target  sidx++
            return binarySearchTwo(nums, target, midIdx + 1, eIdx);
        }
        // 如果 > target  eidx--
        return binarySearchTwo(nums, target, sIdx, midIdx - 1);
    }


    private static int binarySearchThree(int[] nums, int target, int sIdx, int eIdx) {
        /**
         * 1 终止条件
         * 2 业务逻辑
         * 3 自套
         * 4 售后处理
         */
        // 1
        if (sIdx > eIdx) {
            return -1;
        }

        // 业务逻辑   二分开始查找
        int midValue = (sIdx + eIdx) / 2;

        if (nums[midValue] == target) {
            return midValue;
        } else if (nums[midValue] < target) {
            return binarySearchThree(nums, target, midValue + 1, eIdx);
        } else {
            return binarySearchThree(nums, target, sIdx, midValue - 1);
        }
    }


    public static int[] searchRangeSix(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int targetIdx = binarySearchSix(nums, target, 0, nums.length - 1);
        if (targetIdx == -1) {
            return new int[]{-1, -1};
        } else {
            int sIdx = targetIdx;
            int eIdx = targetIdx;
            while (sIdx >= 1 && nums[sIdx - 1] == target) {
                sIdx--;
            }
            while (eIdx <= nums.length - 2 && nums[eIdx + 1] == target) {
                eIdx++;
            }
            return new int[]{sIdx, eIdx};
        }
    }

    private static int binarySearchSix(int[] nums, int target, int sIdx, int eIdx) {
        if (sIdx > eIdx) {
            return -1;
        }
        int midIdx = (sIdx + eIdx) / 2;
        if (nums[midIdx] == target) {
            return midIdx;
        } else if (nums[midIdx] > target) {
            return binarySearchSix(nums, target, sIdx, midIdx - 1);
        } else {
            return binarySearchSix(nums, target, midIdx + 1, eIdx);
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRangeSix(new int[]{1, 3}, 1)));
    }

}
