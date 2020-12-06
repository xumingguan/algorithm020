package weekThree;

import java.util.ArrayList;
import java.util.List;

/**
 * Number 22 括号生成
 *
 * @author Ye-Ma
 */
public class Number22括号生成 {
    public static void main(String[] args) {
        // recursion(0, 3, "");
        List<String> list = generateParenthesis(3);
        System.out.println(list);

    }

    public static void recursion(int n, int max, String s) {
        if (n >= max) {
            System.out.println(s);
            return;
        }
        recursion(n + 1, max, s + "左");
        System.out.println(s);
        recursion(n + 1, max, s + "右");
        System.out.println(s);
    }

    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private static void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }
        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }

    static class Number22括号生成2 {
        public static void main(String[] args) {
            List<String> list = generateParenthesis(3);
            System.out.println(list.toString());
        }

        public static List<String> generateParenthesis(int n) {
            dfsTest(n, n, "");
            return res;
        }

        private static void dfsTest(int left, int right, String s) {
            if (left == 0 && right == 0) {
                res.add(s);
                return;
            }
            if (left > 0) {
                dfsTest(left - 1, right, s + "(");
            }
            if (left < right) {
                dfsTest(left, right - 1, s + ")");
            }
        }

        private static void dfs(int left, int right, String curStr) {
            // 左右括号都不剩余了，递归终止
            if (left == 0 && right == 0) {
                res.add(curStr);
                return;
            }
            if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
                dfs(left - 1, right, curStr + "(");
            }
            if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
                dfs(left, right - 1, curStr + ")");
            }
        }


    }

}
