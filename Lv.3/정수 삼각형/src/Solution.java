class Solution {

    public static void main(String[] args) {
        int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
        solution(triangle);
    }

    public static int solution(int[][] triangle) {
        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
            }
        }
        System.out.println(triangle[0][0]);

        return triangle[0][0];
    }
}

/*
 * 해당 예제
 * 7
 * 3 8
 * 7 1 0
 * 2 7 4 4
 * 4 5 2 6 4
 * 
 * 위 코드는 9번 줄 i는 triangle 배열의 length - 2부터 시작한다.
 * 예제는 length가 5이므로 3부터 시작한다. (0부터 시작함으로 triangle[3]은 마지막 바로 윗줄이다. 즉, -2는 마지막 바로
 * 윗줄부터 돌린다.)
 * 
 * 두번 째 for 10번째 줄은 해당 행의 열만큼 돈다.
 * 예제를 두번 째 for문을 돌리고 나면
 * 7
 * 3 8
 * 7 1 0
 * 7 12 10 10
 * 4 5 2 6 4
 * 가 된다. (즉 자신 행의 아래(triangle[i+1]) 왼쪽, 오른쪽 숫자를 비교 한 후 더 큰 숫자를 자신과 더한다.)
 * 
 * 이런 식으로 맨 윗줄을 가장 큰 숫자로 바꾼 후 출력하면 된다.
 */