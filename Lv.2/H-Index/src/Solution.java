import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        int[] copyCitations = citations.clone();

        Arrays.sort(copyCitations);

        for (int i = 0; i < citations.length; i++) {
            // h = 해당 논문 인용 횟수 (copyCitations[i])보다 크거나 같은 논문
            // 오름차순으로 정렬했기 때문에 length - i를 해주면 된다.(자기 포함)
            // ex) i = 0 일 때 자기 뒤에 인덱스는 모두 자기보다 인용이 많이 됐기 때문에 length - i하면 배열 요소 전부이다.
            int h = citations.length - i;

            // 해당 논문 인용 수보다 더 크거나 같은 논문이 나온다면 그게 h의 최댓값이다. (오름차순을 했기 때문에)
            if (copyCitations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}

// citations[i] = 해당 논문 이용 횟수
// h = 해당 논문보다 인용횟수가 크거나 같은 논문 편수
// ex) 0, 1, 4, 5, 6 (sort까지 했다고 가정)
// i = 0, n = 5, h = 5, citations[i] = 0
// i = 1, n = 5, h = 4, citations[i] = 1
// i = 2, n = 5, h = 3, citations[i] = 4 이때 citations >= h 이기 때문에 해당 h 3이 최댓값이다.

// 참고 블로그 : https://bada744.tistory.com/94
