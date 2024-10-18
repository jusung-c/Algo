import java.util.*;

class Solution {
    static int answer;
    static boolean[] visit;
    
    public void dfs(ArrayList<Integer> order, int prevK, int[][] dList) {
        // 던전 수 갱신
        if (answer < order.size()) {
            // for (int i : order) System.out.print(i +" ");
            answer = Math.max(answer, order.size());
            // System.out.println("answer = " + answer);
        }
        
        // 8개의 던전을 다 고른 경우 탈출
        if (order.size() == dList.length) return;
        
        // 다음 경우의 수
        for (int i=0 ; i<dList.length; i++) {
            
            // 방문한 던전이면 패쓰
            if (visit[i]) continue;
            
            // 현재 피로도로 갈 수 없는 곳이면 패쓰
            if (prevK < dList[i][0]) continue;
            
            // 피로도 소모하고 다음 던전으로
            order.add(i);
            visit[i] = true;
            dfs(order, prevK - dList[i][1], dList);
            
            order.remove(order.size() - 1);
            visit[i] = false;
        }
    }
    
    public int solution(int k, int[][] dList) {
        visit = new boolean[dList.length];
        
        // 0 이상의 정수 피로도 (1 <= k <= 5000)
        // 각 던전마다 최소 필요 피로도 minK와 소모 피로 useK도 보유
        // 던전은 최대 8개, 1<= useK <= minK <= 1000
        
        // 완전탐색으로 가능한 던전 순서 경우의 수 구하기
        // 가능한 경로의 순서인지 판단한 후 가능하다면 던전의 최대 수 갱신하기
        
        dfs(new ArrayList<Integer>(), k, dList);
        
        return answer;
    }
}