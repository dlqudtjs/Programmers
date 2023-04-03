public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        boolean[] skipAlpha = new boolean[26];

        for (char c : skip.toCharArray()) {
            skipAlpha[(c - 'a')] = true;
        }

        int cnt = 0;

        for (char c : s.toCharArray()) {
            cnt = 0;

            while (cnt < index) {
                ++c;
                c = c <= 'z' ? c : (char) ('a' + (c - 'z') - 1);

                if (!skipAlpha[((c) - 'a')]) {
                    cnt++;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}
