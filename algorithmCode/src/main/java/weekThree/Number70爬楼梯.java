package weekThree;

/**
 * @author Ye-
 * 爬楼梯 问题  目前先只用 递归解决
 */
public class Number70爬楼梯 {

    public static void main(String[] args) {
        System.out.println(climbStairsFour(4));
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


}
