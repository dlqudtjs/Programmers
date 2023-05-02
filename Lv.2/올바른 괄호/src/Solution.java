import java.util.Stack;

class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("(()()))"));
    }

    static boolean solution(String s) throws Exception {
        return check(s);
    }

    static boolean check(String str) {
        char[] strArray = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            // '(' 여는 괄호는 넣고, stack이 비어있으면 아무 괄호나 삽입
            if (strArray[i] == '(' || stack.isEmpty()) {
                stack.add(strArray[i]);
                continue;
            }

            // 닫는 괄호일 때 최근 stack이 여는 괄호라면 전에 있던 괄호 pop
            if (strArray[i] == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }

            // 위에 경우가 아닐경우 (전에 괄호가 닫는 괄호일 때)
            stack.add(strArray[i]);
        }

        return stack.isEmpty();
    }
}