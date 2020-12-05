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
        int i1= climbStairsFive(n - 2);
        int i2 = i+i1;
        return i2;
        // return recursion(n);
    }

    public static  int recursion(int n){
        // 结果肯定大于2了
       /* if (n<=0){
            return n;
        }*/
        return recursion(n-1)+recursion(n-2);

    }


    }
