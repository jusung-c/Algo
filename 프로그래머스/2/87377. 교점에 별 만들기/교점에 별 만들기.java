import java.util.*;

// 주어진 n개 직선들의 교점 중 정수 좌표에 별을 그려라
// 별은 "*"로 빈공간은 "."으로 표현하고, 모든 별을 포함하는 최소한의 크기로 나타내라
// 직선은 Ax + By + C = 0 형태이며, A, B, C가 직선별로 이차원 배열로 주어진다.
class Solution {
    static class Pair {
        long x, y;
        
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public String[] solution(int[][] line) {
        
        // 주어진 직선 정보를 2중 for문으로 돌면서 정수 좌표를 찾는다.
        List<Pair> pairList = findPairList(line);
        
        // 좌표를 String[]으로 변환하기
        return changeMap(pairList);
    }
    
    public String[] changeMap(List<Pair> pairs) {
        // map의 사이즈 구하기
        long maxR = Long.MIN_VALUE;
        long maxC = Long.MIN_VALUE;
        long minR = Long.MAX_VALUE;
        long minC = Long.MAX_VALUE;
        
        for (Pair p : pairs) {
            maxR = Math.max(maxR, p.y);
            maxC = Math.max(maxC, p.x);
            minR = Math.min(minR, p.y);
            minC = Math.min(minC, p.x);
        }
        
        int r = (int) (maxR - minR);
        int c = (int) (maxC - minC);
        
        String[][] map = new String[r+1][c+1];
        for (int i = 0; i <= r; i++) Arrays.fill(map[i], ".");
        
        for (Pair p : pairs) {
            int nr = (int) (maxR - p.y);
            int nc = (int) (p.x - minC);
            
            map[nr][nc] = "*";
        }
        
        String[] answer = new String[map.length];
        
        for (int i=0; i<map.length; i++) {
            answer[i] = "";
            for (int j=0; j<map[0].length; j++)
                answer[i] += map[i][j];
        }
        
        return answer;
    }
    
    public List<Pair> findPairList(int[][] line) {
        List<Pair> pairList = new ArrayList<>();
        
        for (int i=0; i<line.length; i++) {
            long A = line[i][0];
            long B = line[i][1];
            long E = line[i][2];
            
            for (int j=i+1; j<line.length; j++) {
                double C = line[j][0];
                double D = line[j][1];
                double F = line[j][2];
                
                // 평행 또는 일치하는 경우
                if (A*D - B*C == 0) continue;
                
                // 교점 구하기
                double x = (B*F - E*D) / (A*D - B*C);
                double y = (E*C - A*F) / (A*D - B*C);
                
                // 교점이 정수인지 판단
                if (x % 1 != 0 || y % 1 != 0) continue;
                
                // 교점 리스트 추가
                pairList.add(new Pair((long) x, (long)y));
            }
        }
        
        return pairList;
    }
}