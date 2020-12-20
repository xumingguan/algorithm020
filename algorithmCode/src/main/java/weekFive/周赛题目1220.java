package weekFive;

import java.util.ArrayList;

public class 周赛题目1220 {

    public static void main(String[] args) {
        // 测试用例
        /**
         "1-23-45 6"
         "123 4-567"
         "123 4-5678"
         "12"
         "--17-5 229 35-39475 "
          参考地址
         https://leetcode-cn.com/problems/reformat-phone-number/solution/java-mo-ni-jiu-hao-liao-zhong-xin-ge-shi-9jy6/
         * */
        System.out.println(8 / 3);

    }

    public String reformatNumber(String number) {
        // 子问题 一定要超过3个
        // 去空格
        // 第一步 每 3 个一组 分块
        /*
         2 个数字：单个含 2 个数字的块。
         3 个数字：单个含 3 个数字的块。
         4 个数字：两个分别含 2 个数字的块。
         * */

        // for 循环 去空格  扩折号(计数处理)
        // 数组移动到 数组中进行转string 处理

        char space = ' ';
        char sign = '-';
        int count = 0;
        char[] charArray = number.toCharArray();
        ArrayList<String> list = new ArrayList<String>();
        for (char c : charArray) {
            if (space != c) {
                if (sign == c) {
                    count++;
                    continue;
                }
                list.add(c + "");
            }
        }
        // 长度的处理
        // 第一步 每 3 个一组 分块
        /*
         2 个数字：单个含 2 个数字的块。
         3 个数字：单个含 3 个数字的块。
         4 个数字：两个分别含 2 个数字的块。
         * */
        if (list.size() <= 3) {
            return list.toString();
        }

        int size = list.size() - 3;
        // 利用贪心进行处理
        int threeCount = 0;
        int twoCount = 0;
        int i1 = size / 3;
        for (int i = 0; i < size / 3; i++) {
            threeCount = i1;
            if (size == i1*3){
                break;
            }
            twoCount= size-i1*3 / 2;
            if (size-i1*3 -2*twoCount == 0)break;
            
        }




        return "";
    }

}
