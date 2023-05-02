import java.util.*;

class Solution {
    public int solution(String s) {

        return removeStringFair(s);
    }

    public int removeStringFair(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
                continue;
            }

            // 스택이 비어있지 않고, stack 마지막 글자와 같다면
            stack.pop();
        }

        return stack.isEmpty() ? 1 : 0;
    }
}