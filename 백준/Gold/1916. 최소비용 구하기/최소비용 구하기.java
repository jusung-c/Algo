import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();

        dist = new int[N + 1];

        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    private static void pro() throws IOException {
        dijkstra(start);

//        for (int i=1; i<=N; i++) {
//            bw.write(dist[i] + " ");
//        }
//        bw.newLine();
        bw.write(dist[end] + " ");
    }

    private static void dijkstra(int start) {
        // dist 배열 초기화 및 시작점 큐에 넣기
        for (int i=1; i<=N; i++) {
            if (i == start) dist[i] = 0;
            else dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Info> que = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        que.add(new Info(start, 0));

        // 큐가 빌 때까지 반복
        while (!que.isEmpty()) {
            // 가장 d가 작은 노드 추출
            Info info = que.poll();

            // 가치가 있는지 판단
            if (dist[info.idx] < info.dist) continue;

            // 연결된 간선들 확인
            for (Edge e : edges[info.idx]) {
                // 간선의 정보가 가치가 있는지 판단
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;

                // 최단거리 갱신 후 큐에 넣기
                dist[e.to] = dist[info.idx] + e.weight;
                que.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
