package weekFour;

/**
 * Number 860 柠檬水找零
 *
 * @author Ye-Ma
 */
public class Number860柠檬水找零 {
    public static void main(String[] args) {
        int five = 3, ten = 0;
        int bill = 20;
        if (bill == 5) {
            five++;
        } else if (bill == 10) {
            five--;
            ten++;
        } else if (ten > 0) {
            ten--;
            five--;
        } else {

            five -= 3;
        }
        System.out.println("5元剩余的值的数量   " + five);
        System.out.println("5元剩余的值的数量   " + ten);
    }


    /**
     * 结果是否可以  找零
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
/**
 本文我们一起用高阶函数完成1行解，看先赋值和先比较谁更快，尝试分析原因
 解题思路

 n5记录5美元数量，n10记录10美元数量。遍历bills
 遇5：n5 + 1
 遇10：n10 + 1，找零 n5 - 1
 遇20：贪心策略找零优先大额：因为10美元找零只能用5美元，20找零10 5都可
 有10：找零 n10 - 1，n5 - 1
 没10：找零 n5 - 3
 5美元不够找零，返回false
 方案1：先找零，比较找零后n5 < 0
 方案2：先比较n5<需要找零的数量``


 重点模型 5 10 20
 * */
        int five = 3, ten = 0;
        int bill = 20;
        if (bill == 5) {
            five++;
        } else if (bill == 10) {
            five--;
            ten++;
        } else if (ten > 0) {
            ten--;
            five--;
        } else {

            five -= 3;
        }
        if (five < 0 || ten < 0) {
            return false;
        }
        return false;
    }

}
