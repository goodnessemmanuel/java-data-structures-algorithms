package com.ocheejeh.common;

import java.util.Deque;
import java.util.LinkedList;

public class Algorithm {

    /**
     * takes a string and checks if the brackets
     * are balanced else returns invalid
     * e.g:
     * abc[](){} -> invalid
     * {{[]()}}}} -> invalid
     * {[(])} -> invalid
     *
     * () -> valid
     * [()] -> valid
     * {[()]} -> valid
     * ([{{[(())]}}]) -> valid
     *
     * @param s
     * @return
     */
    public static String balancedBracket(String s){
        //edge case
        if(null == s || s.isEmpty()) return "invalid";

        while (s.contains("{}") || s.contains("()") || s.contains("[]")){
           s = s
                   .replaceAll("\\{}", "")
                    .replaceAll("\\[]", "")
                    .replaceAll("\\(\\)", "");
        }

        if(s.isEmpty()){
            return "valid";
        }

        return "invalid";
    }

    public static String balancedBracketWithDeque(String s){
        Deque<Character> deque = new LinkedList<>();
        if(s.length() != 0) {
            for (char ch : s.toCharArray()) {
                if (ch == '{' || ch == '(' || ch == '[') {
                    deque.addFirst(ch);
                } else if (!deque.isEmpty() && (
                    deque.peekFirst() == '{' && ch == '}' ||
                    deque.peekFirst() == '(' && ch == ')' ||
                    deque.peekFirst() == '[' && ch == ']'
                )) {
                    deque.removeFirst();
                } else return "invalid";
            }

            if (deque.isEmpty()) return "valid";
        }

        return "invalid";
    }
}
