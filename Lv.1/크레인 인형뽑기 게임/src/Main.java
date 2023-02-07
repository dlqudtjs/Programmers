import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println(solution(new int[][] { { 3, 3, 3, 3, 3 }, { 3, 3, 3, 3, 3 }, { 3, 3, 3, 3, 3 },
                { 3, 3, 3, 3, 3 }, { 3, 3, 3, 3, 3 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for (int move : moves) { // 첫 뽑기 대상은 board[][move - 1]로 행이 고정되며 행을 탐색하며 인형을 찾는다.
            for (int i = 0; i < board.length; i++) { // 고정된 열에서 행을 위에서 부터 탐색한다. (맨 위가 board[0])
                if (board[i][move - 1] != 0) {
                    if (!stack.empty() && stack.peek() == board[i][move - 1]) { // 바구니의 맨 위와 방금 잡은 인형을 비교한다.
                        stack.pop(); // 같다면 바구니 맨 위에 인형을 꺼낸 후 answer 값을 2 증가한다. (두 개를 터뜨려서)
                        answer += 2;
                    } else { // 같지 않다면 바구니에 방금 잡은 인형을 맨 위로 넣는다.
                        stack.push(board[i][move - 1]);
                    }

                    board[i][move - 1] = 0; // 방금 잡은 인형을 0으로 바꿔준다. (다음 탐색 때 인형이 없는 것을 구현하기 위해)
                    break;
                }
            }
        }

        return answer;
    }
}
