import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        double[] order = new double[numlist.length];

        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] - n < 0) {
                order[i] = ((int) Math.abs(numlist[i] - n)) + 0.5;
            } else {
                order[i] = numlist[i] - n;
            }
        }

        Arrays.sort(order);

        /*
         * 위에 order에서 음수는 +0.5 를 해주었기 때문에 0.5가 붙은 즉 정수가 아닌 수는
         * 0.5를 빼준 후 n 을 빼준다. n을 빼주는 이유는 n보다 작은 수는 n을 빼줘야 원래 수가 나오고
         * n보다 큰 수는 n을 더해줘야 원래 수가 나온다. (해보면 앎)
         */
        for (int i = 0; i < numlist.length; i++) {
            if (order[i] % 1 != 0) {
                answer[i] = n - (int) (order[i] - 0.5);
            } else {
                answer[i] = (int) order[i] + n;
            }
        }

        return answer;
    }
}