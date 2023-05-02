class Solution {
    public int solution(int n) {
        int answer = 0;

        int num = 0;
        for (int i = 1; i <= n; i++) {
            // i 부터 n까지 더하면서 num이 같거나, num 이 n보다 커지면 break
            for (int j = i; j <= n; j++) {
                num += j;

                if (num == n) {
                    answer++;
                    break;
                }
                if (num > n) {
                    break;
                }
            }

            num = 0;
        }

        return answer;
    }
}