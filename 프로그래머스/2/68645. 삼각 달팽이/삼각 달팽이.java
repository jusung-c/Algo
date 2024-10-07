import java.util.*;

class Solution {
    // 1. 방향 순서 정의 하 -> 우 -> 왼쪽위 대각선
    static int[][] dir = new int[][] {
            {1, 0}, {0, 1}, {-1, -1}
    };

    public int[] solution(int n) {

        // nxn map을 선언하고 사용하지 않는 부분은 -1 처리
        int[][] map = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) map[i][j] = -1;
        }

        // (0, 0)에서 시작해서 숫자 채우기
        int index = 1;
        int r = 0;
        int c = 0;
        int d = 0;

        while (true) {
            map[r][c] = index++;

            // 다음 위치 후보
            int nr = r + dir[d][0];
            int nc = c + dir[d][1];

            // 범위를 벗어났거나 빈칸이 아닌 경우 방향 변경
            if (nr<0||nc<0||nr>=n||nc>=n|| map[nr][nc]!=0) {
                // 다음 방향 선정
                d = (d+1) % 3;
                nr = r + dir[d][0];
                nc = c + dir[d][1];

                // 다음 방향으로도 이동 못하는 경우 제외
                if (nr<0||nc<0||nr>=n||nc>=n|| map[nr][nc]!=0)
                    break;

                // 이동
                r = nr;
                c = nc;
            } else {
                // 이동 가능한 경우 이동
                r = nr;
                c = nc;
            }
        }

        // 하나의 배열로 반환하기
        List<Integer> answer = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++)
                answer.add(map[i][j]);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}