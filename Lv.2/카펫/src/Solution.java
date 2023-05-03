class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0;
        int height = 0;

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                width = yellow / i;
                height = i;
            }
            if (((width + 2) * 2) + (height * 2) == brown) {
                return new int[] { width + 2, height + 2 };
            }
        }

        return null;
    }
}

// return 1. 가로 2. 세로
// 가로 >= 세로
// 가로 = (yellow + 2) * 2
// 세로 = yellow * 2