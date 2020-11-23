package WeekOne;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 题号 20
 * 有效的括号
 * 使用
 */
public class Number20有效的括号 {

    // ()[]{}
    public static void main(String[] args) {
        // System.out.println(isValid("{[]}"));

        LinkedList<String> list = new LinkedList<String>();

        list.push("A");
        list.push("B");
        list.push("C");
        System.out.println(list.toString());

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());

        System.out.println(newIsValid("{[]}"));
    }

    public static boolean newIsValid(String s) {
        LinkedList<Character> list = new LinkedList<Character>();
        for (char c : s.toCharArray()) {
            System.out.println("c 的数据进行遍历" + c);
            if (newIsLeft(c)) {
                // 利用 堆的道理  或者 deque
                System.out.println("push 加入数据" + c);
                list.push(c);
            } else {
                if (list.isEmpty() || !newIsMatch(list.pop(), c)) {
                    return false;
                }
            }
        }
        return list.isEmpty();
    }

    private static boolean newIsMatch(Character pop, char c) {
        switch (pop) {
            case '(':
                return c == ')';
            case '[':
                return c == ']';
            case '{':
                return c == '}';
            default:
                return false;
        }
    }

    private static boolean newIsLeft(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}
