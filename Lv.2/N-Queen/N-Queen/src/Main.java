class Solution {
    private int[] chess;
    private int answer = 0;

    public int solution(int n) {
        chess = new int[n];

        for (int i = 0; i < n; i++) {
            chess[0] = i;

            dfs(0, n);
        }

        return answer;
    }

    private void dfs(int depth, int n) {
        depth++;

        if (depth == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            // 해당 depth에 일단 착수 한 후 check한다.
            chess[depth] = i;

            if (!isCheck(depth)) {
                continue;
            }

            dfs(depth, n);
        }
    }

    private boolean isCheck(int depth) {
        for (int i = 0; i < depth; i++) {
            // dfs에서 depth에 이미 착수 한 후 다른 행에 같은 수가 있는지 확인한다.
            if (chess[depth] == chess[i]) {
                return false;
            }

            // 같은 열, 행을 확인하여 대각 체크함.
            if (Math.abs(depth - i) == Math.abs(chess[depth] - chess[i])) {
                return false;
            }
        }

        return true;
    }
}