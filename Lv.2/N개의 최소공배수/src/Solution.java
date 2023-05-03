class Solution {
    public int solution(int[] arr) {
        int max = 0;
        for (int n : arr) {
            max = max < n ? n : max;
        }

        while (true) {
            boolean flag = false;

            for (int i = 0; i < arr.length; i++) {
                if (max % arr[i] != 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                break;
            }
            max++;
        }

        return max;
    }
}