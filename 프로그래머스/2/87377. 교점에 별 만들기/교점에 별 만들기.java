import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    long maxX = Long.MIN_VALUE;
    long minX = Long.MAX_VALUE;
    long maxY = Long.MIN_VALUE;
    long minY = Long.MAX_VALUE;

    class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();

        // 1. 모든 직선에 대해 정수인 교점을 구한다.
        for (int i=0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point p = getPoint(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                if (p != null) pointList.add(p);
            }
        }
//
//        for (Point p : pointList) {
//            System.out.print("x = " + p.x);
//            System.out.println(" y = " + p.y);
//        }

        // 2. 사각형의 가로, 세로 길이를 구한 뒤 사각형 이차원 배열을 선언한다.
        String[][] angle = makeAngle(pointList);

        for (String[] arr : angle) {
            Arrays.fill(arr, ".");
        }

        // 3. 사분면 상의 교점들을 이차원 배열에 옮긴다.
        for (Point p : pointList) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);

            angle[y][x] = "*";
        }

        String[] answer = new String[angle.length];

        for (int i = 0; i < angle.length; i++) {
            answer[i] = String.join("", angle[i]);
        }

        return answer;
    }

    private String[][] makeAngle(List<Point> pointList) {

        for (Point p : pointList) {
            maxX = Math.max(maxX, p.x);
            minX = Math.min(minX, p.x);
            maxY = Math.max(maxY, p.y);
            minY = Math.min(minY, p.y);
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        return new String[height][width];
    }

    private Point getPoint(double A, double B, double E,
                           double C, double D, double F) {
        // 1-1. 평행하거나 일치하는 경우 제외하기
        if (A * D - B * C == 0) return null;

        // 1-2. 교점 구하기
        double x = (B * F - E * D) / (A * D - B * C);
        double y = (E * C - A * F) / (A * D - B * C);

        // 1-3. 교점이 정수가 아닌 경우 제외하기
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }

    public static void main(String[] args) {
        int[][] array = {
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };

        Solution solution = new Solution();
        solution.solution(array);
    }
}