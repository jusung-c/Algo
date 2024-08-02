import java.util.ArrayList;
import java.util.List;

class Solution {

    // 1. 상태 정의
    // 원판 n개를 from에서 to로 이동
    private void hanoi(int n, int from, int to, List<int[]> answer) {

        // 2. 종료 조건 탈출
        // 원판은 하나씩만 옮길 수 있으므로 원판을 옮기는 과정을 담기 위해 n이 1인 경우 답 리스트에 추가
        if (n == 1) {
            answer.add(new int[]{from, to});
            return;
        }

        // 3. 점화식 정의
        int empty = 6 - (from + to);

        hanoi(n - 1, from, empty, answer);
        hanoi(1, from, to, answer);
        hanoi(n - 1, empty, to, answer);
    }

    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();

        hanoi(n, 1, 3, answer);

        return answer.toArray(new int[0][]);
    }
}