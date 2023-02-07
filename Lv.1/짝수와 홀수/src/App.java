public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = new int[] { 1, 2, 3, 4 };

        System.out.println(solution(arr));
    }

    public static double solution(int[] arr) {
        double answer = 0;

        for (int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }

        answer = answer / arr.length;

        return answer;
    }
}
