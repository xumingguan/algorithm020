package weekTwo;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Number 242 有效的字母异位词
 *
 * @author Ye-Ma
 */
public class Number242有效的字母异位词 {

    public static void main(String[] args) {
        //"aacc"
        //"ccac"
        Integer i = 1;
        // System.out.println(i+1);
        // "ab"
        //"ba"

        System.out.println(isAnagram("ab", "ba"));
    }

    public static boolean isAnagram(String s, String t) {
        if (t.length() == 0 || s.length() == 0 || s.length() != t.length()) {
            return false;
        }
        // 使用map 类解决问题
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                System.out.println("map加入的数据 key的值是" + chars[i]);
                map.put(chars[i], 1);
                continue;
            } else {
                Integer integer = map.get(chars[i]);
                map.put(chars[i], integer + 1);
                System.out.println("map加入的数据 key的值是" + chars[i] + "   value 的值是" + map.get(chars[i]));
            }
        }
        System.out.println("map 的数据值是"+map.toString());

        char[] chars1 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            System.out.println("----------------------"+chars1[i]+"value 的值是"+map.get(chars1[i]));
            if (!map.containsKey(chars1[i])) {
                System.out.println("不包含的关系");
                return false;
            }
            if (map.get(chars1[i]) - 1 < 0) {
                System.out.println("已经被删除了数据"+chars1[i]+ map.get(chars1[i]));
                return false;
            }
            Integer integer = map.get(chars1[i]);
            System.out.println("key的值是" + chars1[i] + "结果是" + integer--);
            map.put(chars1[i], integer--);
        }
        return true;
    }


}
