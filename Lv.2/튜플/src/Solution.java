import java.util.*;

class Solution {
    public int[] solution(String s) {
        // "},{"를 을 -으로 변환한다. ex) 2-2,1-4,1 으로 변환된다.
        String sliceString = s.substring(2, s.length() - 2)
                .replace("},{", "-");

        String[] stringArray = sliceString.split("-");

        // 배열 크기 기준으로 오름차순한다.
        Arrays.sort(stringArray, (o1, o2) -> o1.length() - o2.length());

        List<Integer> list = new LinkedList<>();

        for (String str : stringArray) {
            String[] temp = str.split(",");

            for (String tempStr : temp) {
                if (!list.contains(Integer.parseInt(tempStr))) {
                    list.add(Integer.parseInt(tempStr));
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}