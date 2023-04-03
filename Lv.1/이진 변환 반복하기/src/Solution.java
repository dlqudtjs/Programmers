public class Solution {
    public static void main(String[] args) throws Exception {

        int[] arr = solution("1111111");

        for (int a : arr) {
            System.out.println(a);
        }

    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while (s.length() > 1) {
            answer[0]++;

            int cntOne = 0;

            for (char c : s.toCharArray()) {

                if (c == '0') {
                    answer[1]++;
                } else {
                    cntOne++;
                }
            }

            s = Integer.toBinaryString(cntOne);
        }

        return answer;
    }
}
