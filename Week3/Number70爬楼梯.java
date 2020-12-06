package weekThree;

/**
 * @author Ye-
 * 爬楼梯 问题  目前先只用 递归解决
 */
public class Number70爬楼梯 {

    public static void main(String[] args) {
        System.out.println(climbStairsFive(4));
    }

    public static int climbStairsFour(int n) {
        if (n <= 2) return n;
        int[] i = new int[n + 1];
        i[1] = 1;
        i[2] = 2;
        for (int i1 = 3; i1 <= n; i1++) {
            i[i1] = i[i1 - 1] + i[i1 - 2];
        }
        return i[n];
    }

    public static int climbStairsFive(int n) {
        if (n <= 2) return n;
        int i = climbStairsFive(n - 1);
        int i1 = climbStairsFive(n - 2);
        int i2 = i + i1;
        return i2;
        // return recursion(n);
    }

    public static int recursion(int n) {
        // 结果肯定大于2了
       /* if (n<=0){
            return n;
        }*/
        return recursion(n - 1) + recursion(n - 2);

    }


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 使用 动态规划解决这个问题
        if (n <= 2) return n;
        int[] i = new int[n + 1];
        i[1] = 1;
        i[2] = 2;
        for (int i1 = 3; i1 <= n; i1++) {
            i[i1] = i[i1 - 1] + i[i1 - 2];
        }
        return i[n];
    }


    public int climbStairsTwo(int n) {
        // 使用 动态规划解决这个问题
        if (n <= 2) return n;
        return climbStairsTwo(n-1)+climbStairsTwo(n-2);
    }


}
