import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int[] copyArray = emergency.clone();

        Arrays.sort(copyArray);

        for (int i = 0; i < emergency.length; i++) {
            int num = copyArray[i];

            for (int j = 0; j < emergency.length; j++) {
                if (num == emergency[j]) {
                    answer[i] = emergency.length - j;
                }
            }
        }

        return answer;
    }
}
/*
 * 오름차순으로 정한 후 오름차순과 맞는 숫자는
 * emergency.length - j으로 뒤에서부터 넣어준다.
 */