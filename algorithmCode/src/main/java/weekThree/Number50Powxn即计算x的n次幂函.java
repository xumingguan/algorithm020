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
        System.out.println(myPowOne(2.1000d, 3));
        System.out.println(recursionMyPow(2.1000d, 2.1000d,3-1));
    }

    /**
     * 进行暴力破解  for 循环 但是没有考虑到 负数的情况  大部分场景是可以解决的
     * @param x
     * @param n
     * @return
     */
    public static double myPowOne(double x, int n) {
        return recursionMyPow(x,x,n-1);
    }

    public static double recursionMyPow(double x, double y,int n) {
        if (n == 0) {
            return y;
        }
        return recursionMyPow(x,x*y, n - 1);
    }





}
