import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            aQueue.add(A[i]);
            bQueue.add(B[i]);
        }

        int answer = 0;
        while (!aQueue.isEmpty()) {
            answer += aQueue.poll() * bQueue.poll();
        }

        return answer;
    }
}