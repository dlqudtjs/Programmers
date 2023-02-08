public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("banana"));
    }

    public static int solution(String s) {
        int answer = 0;
        char init = s.charAt(0);
        int count = 0;

        for (char c : s.toCharArray()) {
            // count가 0일 땐 처음 시작했거나, 두 횟수가 같아서 다음 시작 지점을 찾는 것이다.
            if (count == 0) {
                init = c;
            }

            if (init == c) { // 첫 글자와 그 다음 글자가 같은지 확인 후 count를 증감한다.
                count++; // 첫 글자의 개수
            } else {
                count--; // 첫 글자와 다른 글자의 개수
            }

            if (count == 0) { // 증감 변수를 count 하나만 쓰기 때문에 0이 된다는 것은 수가 같다는 뜻이다.
                answer++;
            }
        }

        if (count > 0) { // 문자열이 딱 맞아 분해되지 않고 남아 있을 때도(문자열 크기가 1일 때 포함) 문자열이기 때문에 증가해준다.
            answer++;
        }

        return answer;
    }
}
