package weekSix.everyDay;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Number387字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(firstUniqChar(s));
    }


    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] chars = s.toCharArray();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], -1);
                continue;
            }
            map.put(chars[i], i);
        }

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (map.get(chars[i]) != -1 && map.get(chars[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    class Solution {
        public int firstUniqChar(String s) {
            Map<Character, Integer> position = new HashMap<Character, Integer>();
            Queue<Pair> queue = new LinkedList<>();
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                char ch = s.charAt(i);
                if (!position.containsKey(ch)) {
                    position.put(ch, i);
                    queue.offer(new Pair(ch, i));
                } else {
                    position.put(ch, -1);
                    while (!queue.isEmpty() && position.get(queue.peek().ch) == -1) {
                        queue.poll();
                    }
                }
            }
            return queue.isEmpty() ? -1 : queue.poll().pos;
        }

        class Pair {
            char ch;
            int pos;

            Pair(char ch, int pos) {
                this.ch = ch;
                this.pos = pos;
            }
        }
    }

}
