package weekThree;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角
 *
 * @author Ye-Ma
 */
public class Number118杨辉三角 {

    public static void main(String[] args) {
        System.out.println(generate(3));
        System.out.println(generateTwo(3));
        System.out.println(generateThree(3));
    }

    /**
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     *
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i1 = 0; i1 <= i; i1++) {
                if (i1 == 0 || i1 == i) {
                    list.add(1);
                } else {
                    list.add(ret.get(i - 1).get(i1 - 1) + ret.get(i - 1).get(i1));
                }
            }
            ret.add(list);
        }
        return ret;
    }

    static class Solution {

        public static void main(String[] args) {
            List<List<Integer>> generate = generate(3);
            System.out.println(generate);
            System.out.println(generateTwo(3));

        }

        public static List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ret = new ArrayList<List<Integer>>();
            for (int i = 0; i < numRows; ++i) {
                List<Integer> row = new ArrayList<Integer>();
                for (int j = 0; j <= i; ++j) {
                    if (j == 0 || j == i) {
                        row.add(1);
                    } else {
                        row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    }
                }
                ret.add(row);
            }
            return ret;
        }
    }

    public static List<List<Integer>> generateTwo(int numRows) {
        // 三角本身是一个  移位到数组的
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i1 = 0; i1 <= i; i1++) {
                // 如果i =0 是 1的返回  还有 头和尾的时候是1
                if (i1 == 0 || i1 == i) {
                    list.add(1);
                } else {
                    //row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                    list.add(ret.get(i - 1).get(i1 - 1) + ret.get(i - 1).get(i1));
                }
            }
            ret.add(list);
        }
        return ret;
    }


    public static List<List<Integer>> generateThree(int numRows) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i1 = 0; i1 <= i; i1++) {
                if (i1 == 0 || i == i1) {
                    list.add(1);
                } else {
                    list.add(ret.get(i - 1).get(i1 - 1) + ret.get(i - 1).get(i1));
                }
            }
            ret.add(list);
        }
        return ret;
    }


}
