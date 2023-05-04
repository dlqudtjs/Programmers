import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int size : tangerine) {
            // getOrDefault(key, setReturnValue)는 첫 번째 매개변수(key)의 value값이 있으면
            // value를 반환하고 반환 값이 없으면 두 번째 매개변수 값을 반환한다.
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        // 아래 sort를 위해 키 값을 list로 만든다.
        List<Integer> list = new LinkedList<>(map.keySet());

        // 키 set의 value가 큰 순으로 키 set를 내림차순 정렬한다.
        Collections.sort(list, (o1, o2) -> map.get(o2) - map.get(o1));

        int answer = 0;
        for (int i : list) {
            k -= map.get(i);
            answer++;

            if (k <= 0) {
                break;
            }
        }

        return answer;
    }
}