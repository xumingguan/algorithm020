package WeekOne;

public class Number70爬楼梯梯 {
    public static void main(String[] args) {
        // 波切数列




    }

    public int climbStairs(int n) {
        if (n == 1 || n== 2 ){
            return n;
        }
        return  (n-1)* (n-2);
    }
}
