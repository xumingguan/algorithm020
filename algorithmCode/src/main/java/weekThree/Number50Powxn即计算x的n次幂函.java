package weekThree;

/**
 * Number 50 Powxn 即计算x的n次幂函
 */
public class Number50Powxn即计算x的n次幂函 {
    public static void main(String[] args) {
        /** 测试用例
         * 输入: 2.10000, 3
         * 输出: 9.26100
         * */
        // 来进行暴露破解
        System.out.println(myPowOne(2.00000, 10));
        // System.out.println(recursionMyPow(2.1000d, 2.1000d, 3 - 1));
    }

    /**
     * 进行暴力破解  for 循环 但是没有考虑到 负数的情况  大部分场景是可以解决的
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPowOne(double x, int n) {
        if (n==0){
            return 1.0;
        }

        double v = recursionMyPow(x, x, n>0 ? n - 1 : -n-1);
        return n >= 0 ? v : 1.0 / v;
    }

    public static double recursionMyPow(double x, double y, int n) {
        if (n == 0) {
            return y;
        }
        return recursionMyPow(x, x * y, n - 1);
    }


    /**
     * 官方题解
     */
    static class Solution {
        public static void main(String[] args) {
            double v = myPow(2.00000, 10);
            System.out.println(v);

        }

        public static double myPow(double x, int n) {
            long N = n;
            // 判断 n是大于0还是小于的情况
            return N >= 0 ? quickMul(x, N) :
                    1.0 / quickMul(x, -N);
        }

        public static double quickMul(double x, long N) {
            // 设置边界情况
            if (N == 0) {
                return 1.0;
            }
            // 考虑  n 是奇数还是偶数的情况
            double y = quickMul(x, N / 2);
            return N % 2 == 0 ? y * y : y * y * x;
        }

    }



}
