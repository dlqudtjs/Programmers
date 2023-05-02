import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] completedDay = getCompletedDay(progresses, speeds);

        return getDistributeCnt(completedDay);
    }

    public static int[] getDistributeCnt(int[] completedDay) {
        ArrayList<Integer> list = new ArrayList<>();

        int maxNum = completedDay[0];
        int distributeCnt = 1;

        for (int i = 1; i < completedDay.length; i++) {
            // 앞선 최대값보다 작업 시간이 적다면 같이 배포할 수 있으므로 distributeCnt++ 해준다.
            if (maxNum >= completedDay[i]) {
                distributeCnt++;
            }

            // 앞선 최대값보다 작업 시간이 적다면 같이 배포할 수 있는 수를 list에 넣는다.
            if (maxNum < completedDay[i]) {
                list.add(distributeCnt);
                // 다시 배포 수를 1로 초기화하며, maxNum을 현재 작업시간으로 교체한다.
                distributeCnt = 1;
                maxNum = completedDay[i];
            }

            // 만약 현재 자신이 마지막 작업이라면 지금까지 배포가능한 모든 수를 list에
            if (i == completedDay.length - 1) {
                list.add(distributeCnt);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] getCompletedDay(int[] progresses, int[] speeds) {
        int[] completedDay = new int[progresses.length];

        for (int i = 0; i < progresses.length; i++) {
            completedDay[i] = (100 - progresses[i]) / speeds[i];

            if ((completedDay[i] * speeds[i]) + progresses[i] < 100) {
                completedDay[i] += 1;
            }
        }

        return completedDay;
    }
}
