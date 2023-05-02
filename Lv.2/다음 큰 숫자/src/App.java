class Solution {
    public int solution(int n) {
        int nCnt = getBitCount(n);

        while (true) {
            if (nCnt == getBitCount(++n)) {
                break;
            }
        }

        return n;
    }

    public int getBitCount(int n) {
        int count = 0;

        while (n > 1) {
            count += n % 2;
            n /= 2;
        }

        return count;
    }
}