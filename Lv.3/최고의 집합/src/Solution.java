
class Solution {
    public static void main(String[] args) {

        System.out.println(solution(2, 1));
    }

    public static int[] solution(int n, int s) {

        if (s < n) {
            return new int[] { -1 };
        }

        int[] answer = new int[n];

        // n = 2, s = 9일 때 9 / 2는 4이다.
        int value = s / n;

        // 위에서 구한 4를 배열에 모두 집어넣는다.
        for (int i = 0; i < n; i++) {
            answer[i] = value;
        }

        // 9 % 2 = 1이다.
        value = s % n;

        // 나머지 value를 마지막 배열부터 1씩 나누어 더해준다.
        // i > (n - 1) - value은 i > 배열 크기 - 나머지 값 이기 때문에 남은 값이 없다면 for문이 돌지 않는다.
        for (int i = n - 1; i > (n - 1) - value; i--) {
            answer[i] += 1;
        }

        return answer;
    }
}