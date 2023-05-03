class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);

            answer++;
        }

        return answer;
    }
}

/*
 * 1-2 3-4 5-6 7-8
 * 1 2 3 4 으로 합쳐준다.
 * 
 * 1-2 3-4
 * 1 2 으로 합쳐준다.
 * 
 * 1 으로 합쳐진다.
 * 
 * 같은 대진표에 있을 때까지 합쳐준다.
 * 참고 블로그 : https://ilmiodiario.tistory.com/121
 */