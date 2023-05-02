
class Solution {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
    }

    public static String solution(String s) {
        s = s.toLowerCase();

        char[] str = s.toCharArray();

        if (Character.isLetter(str[0])) {
            // Character.toUpperCase 알기
            str[0] = Character.toUpperCase(str[0]);
        }

        for (int i = 1; i < str.length; i++) {
            if (str[i - 1] == ' ' && Character.isLetter(str[i])) {
                str[i] = Character.toUpperCase(str[i]);
            }
        }

        String answer = new String(str);

        return answer;
    }
}