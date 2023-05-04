import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        String rotatedString = s;
        for (int i = 0; i < s.length(); i++) {
            // 괄호가 정상적인지 확인
            if (checkString(rotatedString)) {
                answer++;
            }

            // String 회전
            rotatedString = getRotateString(rotatedString);
        }

        return answer;
    }

    public boolean checkString(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            // checkBracket 매개변수로 기존 괄호와 새로운 괄호를 넘겨준다.
            if (stack.isEmpty() || !checkBracket(stack.peek(), c)) {
                stack.add(c);
                continue;
            }

            if (checkBracket(stack.peek(), c)) {
                stack.pop();
                continue;
            }
        }

        return stack.isEmpty();
    }

    public boolean checkBracket(char oldBracket, char newBracket) {
        if (oldBracket == '(' && newBracket == ')') {
            return true;
        }
        if (oldBracket == '[' && newBracket == ']') {
            return true;
        }
        if (oldBracket == '{' && newBracket == '}') {
            return true;
        }

        return false;
    }

    public String getRotateString(String str) {
        return new String(str.substring(1) + str.charAt(0));
    }
}