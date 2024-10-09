import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int V, E, start;
    static int[] dist;
    static ArrayList<Edge>[] edges;
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node {
        int idx, dist;
        public Node (int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }


    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());
        dist = new int[V + 1];
        edges = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
        }
    }

    private static void pro() throws IOException {
        dijkstra(start);

        for (int i = 1; i <= V; i++) {
            bw.write(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i] + " ");
            bw.newLine();
        }
    }

    private static void dijkstra(int start) {
        // dist 배열 초기화
        for (int i = 1; i <= V; i++) dist[i] = Integer.MAX_VALUE;
        dist[start] = 0;

        // 시작점 큐에 넣기
        PriorityQueue<Node> que = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        que.add(new Node(start, 0));

        // 큐가 빌 때까지 반복
        while (!que.isEmpty()) {
            // d가 제일 작은 노드 하나 꺼내기
            Node node = que.poll();

            // 가치 있는 노드인지 확인
            if (dist[node.idx] < node.dist) continue;

            // 가치가 있다면 연결된 간선들 확인해서 최단 거리 갱신
            for (Edge e : edges[node.idx]) {
                // 연결된 간선이 가치가 있는지 확인
                if (dist[e.to] <= node.dist + e.weight) continue;

                // 가치가 있다면 최단거리 갱신 후 큐에 넣기
                dist[e.to] = node.dist + e.weight;
                que.add(new Node(e.to, dist[e.to]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
