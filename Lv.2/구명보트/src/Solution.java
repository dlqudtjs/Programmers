import java.util.*;

class Solution {
    public static void main(String[] args) {
        solution(new int[] { 1 }, 1);
    }

    public static int solution(int[] people, int limit) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(people);

        for (int n : people) {
            list.add(n);
        }

        Deque<Integer> deque = new ArrayDeque<>(list);

        while (!deque.isEmpty()) {
            int sum = deque.peekFirst() + deque.peekLast();
            if (sum <= limit) {
                deque.pollFirst();
                deque.pollLast();
                answer++;
            }

            if (sum > limit) {
                deque.pollLast();
                answer++;
            }
        }

        return answer;
    }
}