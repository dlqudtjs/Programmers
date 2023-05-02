class Solution {
    public int[] solution(int n, String[] words) {
        int no = 0;
        int turn = 0;

        for (int i = 1; i < words.length; i++) {
            String preString = words[i - 1];

            // 전 글자의 끝 글자와 같지 않거나, 이미 사용된 글자라면 게임을 종료한다.
            if ((preString.charAt(preString.length() - 1) != words[i].charAt(0)) || alreadyCheck(words, words[i], i)) {
                no = getNo(i, n);
                turn = getTurn(i, n);

                break;
            }
        }

        return new int[] { no, turn };
    }

    int getNo(int sequnceNum, int n) {
        return (sequnceNum % n) + 1;
    }

    int getTurn(int sequnceNum, int n) {
        return (sequnceNum / n) + 1;
    }

    boolean alreadyCheck(String[] words, String str, int current) {
        for (int i = 0; i < current; i++) {
            if (words[i].equals(str)) {
                return true;
            }
        }

        return false;
    }
}