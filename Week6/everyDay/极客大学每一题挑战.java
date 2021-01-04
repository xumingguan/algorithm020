package weekSix.everyDay;

import java.util.HashMap;
import java.util.HashSet;

public class 极客大学每一题挑战 {

    public static void main(String[] args) {
        /*
        输入 “aabcc” 和 “adcaa” ，输出应该是 3 。两个字符串有三个公共字符，分别是 2 个“a”和 1 个“c”。

        输入 “abc” 和 “adcaa”


        状态
        输入
        "zzzz"
        "zzzzzzz"
        输出
        1
        预期结果
        4
        * */
    }

    public int commonCharacterCount(String s1, String s2) {
        HashSet<Character> charOne = new HashSet<>();
        HashSet<Character> charTwo = new HashSet<>();
        for (char c : s1.toCharArray()) {
            charOne.add(c);
        }
        for (char c : s2.toCharArray()) {
            charTwo.add(c);
        }
        int count= 0;
        for (Character character : charOne) {
            if (charTwo.contains(character)){
                count++;
            }
        }
        return count;
    }

}
