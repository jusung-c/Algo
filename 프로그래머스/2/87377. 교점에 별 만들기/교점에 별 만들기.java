import java.util.*;

class Solution {
    private static class Point {
        public final long x, y;
        
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        int n = line.length;
        
        ArrayList<Point> points = new ArrayList<>();
        
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        // 1. 주어진 직선들의 모든 교점 찾기
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                
                // 정수인 교점 구하기
                Point p = func(line[i][0], line[i][1], line[i][2]
                    ,line[j][0] ,line[j][1] ,line[j][2]);
                
                if (p != null) points.add(p);
            }
        }
        
        // 2. 교점들의 최대x, 최소x, 최대y, 최소y 값 찾기
        for (Point p : points) {
            maxX = Math.max(maxX, p.x);
            minX = Math.min(minX, p.x);
            maxY = Math.max(maxY, p.y);
            minY = Math.min(minY, p.y);
        }
        
        // 최소 사각형의 가로, 세로 길이
        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);
        
        // 사각형 배열 초기에 "." 으로 초기화
        String[][] angle = new String[height][width];
        
        for (String[] list : angle) {
            Arrays.fill(list, ".");
        }
        
        // 교점을 돌면서 별찍기
        for (Point p : points) {
            
            // 사분면 위 좌표 기준인 p를 
            // (0, 0) ~ (-width, height) 범위의 사각형으로 변환
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            angle[y][x] = "*";
        }
        
        String[] answer = new String[angle.length];
        for (int i=0; i<angle.length; i++) {
            answer[i] = "";
            for (int j=0; j<angle[i].length; j++) {
                answer[i] += angle[i][j];
            }
        }
        
        return answer;
    }
    
    public Point func(double A, double B, double E
                      , double C, double D, double F) {
        
        if (A*D - B*C == 0) return null;
        
        double x = (B*F-E*D) / (A*D-B*C);
        double y = (E*C-A*F) / (A*D-B*C);
        
        // 정수인 좌표만 사용
        if (x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long) x, (long) y);
    }
}