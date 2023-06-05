class Solution {
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) {
        solution(new int[][] { { 40, 10, 10 }, { 20, 5, 0 }, { 30, 30, 30 }, { 70, 0, 70 }, { 100, 100, 100 } });
    }

    public static int solution(int[][] ability) {
        visited = new boolean[ability.length];

        dfs(0, 0, ability);

        return max;
    }

    private static void dfs(int depth, int sum, int[][] ability) {
        if (depth == ability[0].length) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            // depth = 종목의 깊이 i = 사람의 깊이
            dfs(depth + 1, sum + ability[i][depth], ability);
            visited[i] = false;
        }
    }
}