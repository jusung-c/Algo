import java.util.*;
import java.util.stream.*;

class Solution {
    long maxX = Long.MIN_VALUE;
    long maxY = Long.MIN_VALUE;
    long minX = Long.MAX_VALUE;
    long minY = Long.MAX_VALUE;

    private class Point {
        private final long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {

        List<Point> pointList = new ArrayList<>();

        // 1. 주어진 좌표의 교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point p = getPoint(line[i][0], line[i][1], line[i][2],
                        line[j][0], line[j][1], line[j][2]);

                if (p != null) pointList.add(p);
            }
        }

        // 2. 사각형 생성
        String[][] angle = makeAngle(pointList);

        // 3. 교점을 사각형에 찍기
        // 사분면의 교점을 배열로 옮기기 위해
        // x축은 (p.x - minX)로 음수 값들을 다 오른쪽으로 넘기고
        // y축은 (p.y - maxY)로 양수 값들을 다 아래쪽으로 넘긴다.
        // 이 때 배열에서의 y 좌표는 사분면과 부호가 반대이므로 -(p.y - maxY)로 처리한다.
        for (Point p : pointList) {
            int newX = (int) (p.x - minX);
            int newY = (int) (maxY - p.y);

            angle[newY][newX] = "*";
        }

        // 4. 문자열 배열로 변환
        String[] answer = new String[angle.length];
        for (int i = 0; i < angle.length; i++) {
            answer[i] = Arrays.stream(angle[i])                  // Stream<String>
                    .collect(Collectors.joining(""));   // String

        }

        return answer;
    }

    private String[][] makeAngle(List<Point> pointList) {
        for (Point p : pointList) {
            maxX = Math.max(maxX, p.x);
            maxY = Math.max(maxY, p.y);
            minX = Math.min(minX, p.x);
            minY = Math.min(minY, p.y);
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        String[][] angle = new String[height][width];

        // "."으로 초기화
        for (String[] list : angle) {
            Arrays.fill(list, ".");
        }

        return angle;
    }

    private Point getPoint(double A, double B, double E,
                           double C, double D, double F) {

        // 1-1. 평행 or 일치 확인
        if (A * D - B * C == 0) return null;


        // 1-2. 교점 구하기
        double x = (B * F - E * D) / (A * D - B * C);
        double y = (E * C - A * F) / (A * D - B * C);

        // 1-3. 정수인 경우만 사용
        if (x % 1 != 0 || y % 1 != 0) return null;

        return new Point((long) x, (long) y);
    }
}