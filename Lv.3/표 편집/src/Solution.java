import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // n = 행의 개수, k = 선택된 행의 번호, cmd = 명령 배열
        List<String> table = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            table.add(i + "");
        }

        List<String> executedTable = executeCmd(table, cmd, k);

        String answer = getChangedCheck(table, executedTable);

        return answer;
    }

    public String getChangedCheck(List<String> table, List<String> executedTable) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < table.size(); i++) {
            if (executedTable.contains(table.get(i))) {
                sb.append("O");
            } else {
                sb.append("X");
            }
        }

        return sb.toString();
    }

    public List<String> executeCmd(List<String> table, String[] cmd, int currentPoint) {
        List<String> executedTable = new LinkedList<>(table);
        Stack<String[]> saveRecentlyStack = new Stack<>();

        for (String command : cmd) {
            StringTokenizer st = new StringTokenizer(command);
            String firstCommand = st.nextToken();

            if (firstCommand.equals("C")) {
                // 최근 삭제한 값 저장
                saveRecentlyStack.add(new String[] { currentPoint + "", executedTable.get(currentPoint) });
                // 값 삭제
                executedTable.remove(currentPoint);

                int recentlyRemovePoint = Integer.parseInt(saveRecentlyStack.peek()[0]);
                if (recentlyRemovePoint >= executedTable.size()) {
                    currentPoint = executedTable.size() - 1;
                }
                continue;
            }
            if (firstCommand.equals("Z")) {
                // 가장 최근에 삭제된 행 복구 (단 선택된 행은 바뀌지 않는다.)
                String[] recentlyRemoveData = saveRecentlyStack.pop();
                int recentlyRemovePoint = Integer.parseInt(recentlyRemoveData[0]);
                String recentlyRemoveName = recentlyRemoveData[1];

                executedTable.add(recentlyRemovePoint, recentlyRemoveName);

                // 만약 위에 행이 복구 됐다면 현재 선택된 행은 바뀌지 않아야 하기 때문에 +1 를 해준다.
                if (recentlyRemovePoint <= currentPoint) {
                    currentPoint += 1;
                }
                continue;
            }
            if (firstCommand.equals("U")) {
                currentPoint -= Integer.parseInt(st.nextToken());
                continue;
            }
            if (firstCommand.equals("D")) {
                currentPoint += Integer.parseInt(st.nextToken());
                continue;
            }
        }

        return executedTable;
    }
}