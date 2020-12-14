package weekFour;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * topic 649. Dota2 参议院
 */
public class everyDayTopic1211 {

    public static void main(String[] args) {
        System.out.println(getVoucherCostPerformmance(10, 5));
        System.out.println(getVoucherCostPerformmance(10, 10));
        System.out.println(getVoucherCostPerformmance(10, 7));
        System.out.println(getVoucherCostPerformmance(10, 20));


        System.out.println(getVoucherCostPerformmance(1000, 2000));
    }

    /**
     * @param senate
     * @return  输出应该是 Radiant 或 Dire
     */
    public String predictPartyVictory(String senate) {
        return null;
    }

    private static  BigDecimal getVoucherCostPerformmance(int money,int threshold) {
        BigDecimal b = new BigDecimal((float) money / threshold);
        b.compareTo()
        return b;
    }



}
