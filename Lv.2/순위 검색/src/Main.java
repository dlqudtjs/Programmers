import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(solution(new String[] { "java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
                "python backend senior chicken 50" },
                new String[] { "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150", "- and - and - and chicken 100",
                        "- and - and - and - 150" }));
    }

    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};

        String[][] newInfo = new String[info.length][5];
        StringTokenizer st;

        for (int i = 0; i < info.length; i++) {
            st = new StringTokenizer(info[i]);
            newInfo[i][0] = st.nextToken(); // 개발언어
            newInfo[i][1] = st.nextToken(); // 직군
            newInfo[i][2] = st.nextToken(); // 경력
            newInfo[i][3] = st.nextToken(); // 소울푸드
            newInfo[i][4] = st.nextToken(); // 코딩테스트 점수
        }

        Arrays.sort(newInfo, new Comparator<String[]>() {

            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o2[4]) - Integer.parseInt(o1[4]);
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < query.length; i++) {
            int sum = 0;

            st = new StringTokenizer(query[i]);
            String lang = st.nextToken(); // 개발언어
            st.nextToken(); // and
            String position = st.nextToken(); // 직군
            st.nextToken(); // and
            String career = st.nextToken(); // 경력
            st.nextToken(); // and
            String food = st.nextToken(); // 소울푸드
            int score = Integer.parseInt(st.nextToken()); // 점수

            for (int j = 0; j < newInfo.length; j++) {
                if (score > Integer.parseInt(newInfo[j][4])) {
                    break;
                }
                if (!lang.equals("-") && !lang.equals(newInfo[j][0])) {
                    continue;
                }
                if (!position.equals("-") && !position.equals(newInfo[j][1])) {
                    continue;
                }
                if (!career.equals("-") && !career.equals(newInfo[j][2])) {
                    continue;
                }
                if (!food.equals("-") && !food.equals(newInfo[j][3])) {
                    continue;
                }

                sum++;
            }

            sb.append(sum).append(" ");
        }

        st = new StringTokenizer(sb.toString());
        answer = new int[st.countTokens()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        return answer;
    }
}
