class Solution {
    private int[] fibo;

    public int solution(int n) {
        fibo = new int[n + 2];
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = getFibo(i);
        }

        return fibo[n];
    }

    public int getFibo(int n) {
        return (fibo[n - 1] + fibo[n - 2]) % 1234567;
    }
}