public class Main {
    public static int solution(String[] babbling) {
        int answer = 0;

        for (String bab : babbling) {
            if (bab.contains("ayaaya") || bab.contains("yeye") || bab.contains("woowoo") || bab.contains("mama")) {
                continue;
            }

            bab.replaceAll(bab, bab)
            bab = bab.replace("aya", " ");
            bab = bab.replace("ye", " ");
            bab = bab.replace("woo", " ");
            bab = bab.replace("ma", " ");
            bab = bab.replace(" ", "");

            if (bab.equals("")) {
                answer++;
            }
        }

        return answer;
    }
}
