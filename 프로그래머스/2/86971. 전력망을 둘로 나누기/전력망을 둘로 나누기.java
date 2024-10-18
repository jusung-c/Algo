import java.util.*;

class Solution {
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    
    public int bfs(int x, int no1, int no2) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        visit[x] = true;
        int cnt = 1;
        
        while (!que.isEmpty()) {
            x = que.poll();
            
            for (int y : adj[x]) {
                if ((x==no1 && y==no2)||(x==no2 && y==no1)) continue;
                if (visit[y]) continue;
                
                visit[y] = true;
                cnt++;
                que.add(y);
            }
        }
        
        return cnt;
    }
    
    public int solution(int n, int[][] wires) {
        // n개의 정점, n-1개의 간선
        // 간선 하나를 삭제하면 분리되는 두 트리의 개수 차이가 가장 작은 경우를 고르시오
        adj = new ArrayList[n+1];
        for (int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        
        for (int i=0; i<wires.length; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            
            adj[u].add(v);
            adj[v].add(u);
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int i=0; i<wires.length; i++) {
            visit = new boolean[n+1];
            
            int u = wires[i][0];
            int v = wires[i][1];
            
            int a = bfs(u, u, v);
            int b = n - a;
            
            // System.out.println(a);
            
            answer = Math.min(answer, Math.abs(a - b));
        }
        
        return answer;
    }
}