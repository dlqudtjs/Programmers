import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;

        Queue<String> queue = new LinkedList<>();

        for (String city : cities) {
            city = city.toLowerCase();

            if (queue.contains(city)) {
                // cache가 5 일 때 1, 3, 4, 3, 5 일 때 4번 요소 3이 나오면
                // 3을 삭제한 후 3을 맨 뒤에 넣어줘야 한다. LRU이기 때문에 ()
                queue.remove(city);
                queue.add(city);
                answer += 1;
                continue;
            }

            // 캐시가 다 차면 가장 늦게 사용된 queue를 삭제한다.
            if (queue.size() >= cacheSize) {
                queue.poll();
            }

            queue.add(city);
            answer += 5;
        }

        return answer;
    }
}
