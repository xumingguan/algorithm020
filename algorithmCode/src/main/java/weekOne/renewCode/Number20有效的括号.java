package weekOne.renewCode;

import java.util.Stack;

/**
 *
 */
public class Number20有效的括号 {

    public static void main(String[] args) {
        boolean b = testStack("()");
        System.out.println(b);
    }

    private static boolean testStack(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            System.out.println(c+"");
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ' ':
                    System.out.println("不符合");
                    return false;
                default:
                    if (stack.isEmpty() || !stack.pop().equals(c)) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }


/*    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.peek()) {
                return false;
            }
        }
        return stack.isEmpty();
    }*/

}
