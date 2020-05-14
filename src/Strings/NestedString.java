package Strings;

import java.util.Stack;

public class NestedString {

    public int solution(String S) {
        // write your code in Java SE 8
        int len = S.length();
        if(len % 2 != 0){
            return 0;
        }
        if(S.isEmpty()){
            return 1;
        }
        else if (isProperlyNested(S)) {
            return 1;
        }

        return 0;

    }

    public boolean isBalanced(String S) {

        Stack<Character> stack = new Stack<>();
        for (Character ch : S.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(ch);
            }
            if (isClosing(ch)) {
                try {
                    stack.pop();
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isOpening(Character c) {
        return (c == '(' || c == '{' || c == '[');
    }

    public boolean isClosing(Character c) {
        return (c == ')' || c == '}' || c == ']');
    }

    public boolean isProperlyNested(String S) {

        if (S.charAt(0)== '(' && S.charAt(S.length()-1) == ')' || S.charAt(0) == '{' && S.charAt(S.length()-1) == '}'
                || S.charAt(0) == '[' && S.charAt(S.length()-1) == ']')
        {
            if (isBalanced(S.substring(0, S.length()-1))) {
                return true;
            } else {
                return false;
            }
        }
        else{
            return false;
        }
    }
}
