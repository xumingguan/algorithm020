package weekOne.renewCode;

/**
 * 再次做题   原速度已经很快了
 *
 * @author Ye-Ma
 */
public class Number11盛最多水的容器 {

    public static void main(String[] args) {
        /* * 1 确定题目意思 * 2 使用的数据结构   * 3 code  * 4 test  * 5 提交  查看别人的优秀的方法  * */
        /*
         * 输入：[1,8,6,2,5,4,8,3,7]
         * 输出：49
         * */

        // 折中 计算方法   两边向中间计算
        // 高度  看那边比较低 * 长度的差的值
        // 时间复杂度 O(n)
        // 遇到的问题  i++ 的坑  是先赋值原来的值 然后再+1
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        maxArea(ints);

    }

    public static int maxArea(int[] height) {
        int i = 0,
                // 末尾开始
                j = height.length - 1,
                // 标记值
                res = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                 res = Math.max(res, (j - i) * height[i++]);
            } else {
                 res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }
}
