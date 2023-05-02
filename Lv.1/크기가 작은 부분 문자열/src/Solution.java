class Solution {
    public int solution(String t, String p) {
        int answer = 0;

        long pNum = Long.parseLong(p);

        // 크기가 아닌 문자열이 10,000이 들어오기 때문에 Long으로 선언해야 된다.
        // i < (t.length() - p.length()) + 1 의 범위 설정이유는 5 - 3 일때 1까지 돌기 때문에
        // + 1을 해줘서 index 2까지 돌아줘야한다. (해보면 앎)
        for (int i = 0; i < (t.length() - p.length()) + 1; i++) {
            long tNum = Long.parseLong(t.substring(i, i + p.length()));
            if (tNum <= pNum) {
                answer++;
            }
        }

        return answer;
    }
}