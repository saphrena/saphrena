package com.saphrena.LeetCode;

import com.saphrena.Utils.PrintUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author 热河
 * @created 2022/5/10 13:37
 * @project saphrena
 * @Description
 */

/**
 * 算法原理
 * 栈先入后出特点恰好与本题括号排序特点一致，即若遇到左括号入栈，
 * 遇到右括号时将对应栈顶左括号出栈，则遍历完所有括号后 stack 仍然为空；
 * 建立哈希表 dic 构建左右括号对应关系：key左括号，value右括号；
 * 当我们遇到一个右括号时，我们需要将一个相同类型的左括号闭合。
 * 此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。
 * 如果不是相同的类型，或者栈中并没有左括号，那么字符串 ss 无效，返回False。
 * @author saphrena
 */

@Slf4j
public class ValidBrackets {
    public boolean isValid(String s) {
        int n = s.length();
        if(s.length() == 0 || n % 2 != 0){
            return false;
        }

        Map<Character, Character> map = new HashMap<>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char charAt = s.charAt(i);
            if (map.containsKey(charAt)) {
                if (stack.isEmpty() || !stack.peek().equals(map.get(charAt))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(charAt);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        if(new ValidBrackets().isValid("[{(})]")){
            PrintUtils.printlnGreen("Succeeded",System.err);
        }
    }
}
