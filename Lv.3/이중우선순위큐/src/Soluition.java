import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	public int[] solution(String[] operations) {
		Queue<Integer> minHeap = new PriorityQueue<>(); // 최소힙
		Queue<Integer> maxHeap = new PriorityQueue<>(); // 최대힙

		for (int i = 0; i < operations.length; i++) {
			// 데이터 삽입
			if (operations[i].charAt(0) == 'I') {
				int data = Integer.parseInt(operations[i].split(" ")[1]);
				minHeap.add(data);
				maxHeap.add(-data); // 최대힙은 부호를 바꿔서 넣기
			}
			// 최대값 삭제
			
			else if (!minHeap.isEmpty() && operations[i].equals("D 1")) {
				// 서로 부호가 반대이므로 poll할 때 부호 전환
				minHeap.remove(-maxHeap.poll());
			}
			// 최소값 삭제
			else if (!minHeap.isEmpty() && operations[i].equals("D -1")) {
				// 서로 부호가 반대이므로 poll할 때 부호 전환
				maxHeap.remove(-minHeap.poll());
			}
		}

		// 최대힙은 poll할 때 부호를 원래 부호로 바꿔줌
		return minHeap.isEmpty() ? new int[] { 0, 0 } : new int[] { -maxHeap.poll(), minHeap.poll() };
	}
}