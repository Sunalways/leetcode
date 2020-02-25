package cn.lee983.Apple;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: liweifeng
 * Date: 2020/02/24 14:22
 * @description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 **/
public class LC0020ValidParentheses {

    /**
     * String s = "(";  // ERROR 直接返回true, 应该要判断当前栈有无数据 41: return true -> return stack.isEmpty()
     * String s = "]";  // ERROR 判断条件传入为map, 应为stack         31: if (map.isEmpty()) -> if (stack.isEmpty())
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        char[] arrs = s.toCharArray();
        for (int i = 0; i < arrs.length; i++) {
            if (!map.containsKey(arrs[i])) {
                stack.push(arrs[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character popChar = stack.pop();
                Character mapChar = map.get(arrs[i]);
                if (!popChar.equals(mapChar)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
//        String s = "()[]{}";
//        String s = "([)]";
//        String s = "(";   // ERROR
        String s = "]";
        System.out.println(LC0020ValidParentheses.isValid(s));
    }
}
