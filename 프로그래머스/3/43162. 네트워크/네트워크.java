// n(1~200)개의 컴퓨터와 연결 정보 주어진다.
// 연결된 네트워크의 개수를 구하라

import java.util.*;

class Solution {
    int cnt;
    boolean[] visit;
    
    public void bfs(int x, int[][] computers) {
        Queue<Integer> que = new LinkedList<>();
        que.add(x);
        
        while (!que.isEmpty()) {
            x = que.poll();

            for (int y=0; y<computers[x].length; y++) {
                if (y == x) continue;

                if (visit[y]) continue;
                if (computers[x][y] != 1) continue;

                // 방문 처리하고 큐에 넣어주기
                // System.out.println(y + "에 방문합니다.");
                visit[y] = true;
                que.add(y);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        // 1. 0번 컴퓨터부터 시작해서 방문 처리를 하면서 연결된 네트워크를 파악한다.
        cnt = 0;
        visit = new boolean[n];
        for (int i=0; i<n; i++) {
            if (visit[i]) continue;
            
            // 방문 처리하고 BFS 시작
            visit[i] = true;
            // System.out.println(i + "에 대해 BFS를 시작합니다.");
            bfs(i, computers);
            cnt++;
        }
        
        return cnt;
    }
}

// 1 1 0
// 1 1 1
// 0 1 1