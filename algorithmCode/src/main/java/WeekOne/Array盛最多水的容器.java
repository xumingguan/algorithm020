package WeekOne;

import java.util.ArrayList;

public class Array盛最多水的容器 {

    // LeetCode  questionNumber 11

    /*
    给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
    在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器。
    * */

    public static void main(String[] args) {
        // 盛最多水的容器
      /*  int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));*/

        // 移动零  0,1,0,3,12
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroe(nums);
    }




    public static void moveZeroe(int[] nums) {

        // 第一次写的时候是 开辟新的数组空间 然后!= 0 的加入 最后尾部加入0  效率非常的低

        // 这是最快的  时间复杂度 n
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }



    /**
     * 计算容器
     *
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        // 方案一   n*n  两次的for
      /*
              int maxValue = 0;
      for (int i = 0; i < height.length; i++) {
            for (int iTwo = 0; iTwo < height.length; iTwo++) {
                int waterHeight = Math.min(height[i], height[iTwo]);
                System.out.println("高度的差是" + waterHeight);
                System.out.println("iTwo - i的值是" +"iTwo  "+iTwo+" i的值是 "+i+ (iTwo - i));
                int maxValueCapacity = (iTwo - i) * waterHeight;
                System.out.println("maxValue 的值是" + maxValueCapacity);
                maxValue = Math.max(maxValueCapacity, maxValue);
            }
        }
        return maxValue;
        */
        // 方案二   折中 计算  时间复杂度  n
        // 起始的地址
        int i = 0,
                // 末尾开始
                j = height.length - 1,
                // 标记值
                res = 0;

        // max   (a >= b) ? a : b
        while (i < j) {
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }






}
