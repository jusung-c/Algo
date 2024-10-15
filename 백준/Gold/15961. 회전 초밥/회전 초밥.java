import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, d, k, c;
    static int[] arr;

    public static void init() throws IOException {
        // 원형의 수열
        // 연속해서 k개를 선택
        // 선택한 숫자 종류에 따라 정답 갱신

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
    }

    private static void pro() throws IOException {
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        int max = 0;

        for (int R = -1, L = 0; L < N; L++) {
            if (L != 0) {
                map.put(arr[L - 1], map.getOrDefault(arr[L - 1], 0) - 1);
                if (map.get(arr[L-1]) == 0) map.remove(arr[L - 1]);
                size--;
            }

            while (size < k) {
                R = (R + 1) % N;
                map.put(arr[R], map.getOrDefault(arr[R], 0) + 1);
                size++;
            }

            if (size == k) {
                max = Math.max(max, findCnt(map));
            }
        }

        bw.write(max + " ");
    }

    private static int findCnt(Map<Integer, Integer> map) {
        int size = map.size();
        if (size == d) return size;
        return map.containsKey(c) ? size : size + 1;
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
