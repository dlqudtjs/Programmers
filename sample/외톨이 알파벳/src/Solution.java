class Solution {

    public String solution(String input_string) {
        input_string = "." + input_string + ".";

        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {

            // c + ""이 아닌 c + "+"로 나누는 이유는 "+"가 정규 표현식에서 "1개 이상"을 나타내는 메타 문자이기 때문이다.
            // 따라서 split(c + "+")는 c 문자가 1개 이상 반복되는 문자열을 기준으로 문자열을 분리하게 된다.
            // "a", "aa", "aaa", "aaaa" 등과 같은 연속적인 문자열을 기준으로 문자열을 분리하게 된다.
            if (input_string.split(c + "+").length < 3) {
                continue;
            }

            sb.append(c);
        }

        return sb.length() == 0 ? "N" : sb.toString();
    }
}

// "edeaaabbccd" "de"