import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, menu, target, coupon;
    static int[] arr;

    public static void init() throws IOException {
        // 번호 k개를 연속해서 선택 + 추가 번호 1개(k개 중에 없으면 +1)
        // 가능한 다양한 종류의 번호를 가져야 한다.
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        menu = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            arr[i] = value;
        }
    }

    private static void pro() throws IOException {
        int size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int R = -1, L = 0; L < N; L++) {
            if (L != 0) {
                map.put(arr[L - 1], map.getOrDefault(arr[L - 1], 0) - 1);
                if (map.get(arr[L - 1]) == 0) map.remove(arr[L - 1]);
                size--;
            }

            while (size < target) {
                R = (R + 1) % N;
                map.put(arr[R], map.getOrDefault(arr[R], 0) + 1);
                size++;
            }

            // 가짓수 체크
            if (size == target) {
                max = Math.max(max, findCnt(map));
            }

//            for (int i : map.keySet()) bw.write(i + " ");
//            bw.newLine();
        }

        bw.write(max + " ");
    }

    private static int findCnt(Map<Integer, Integer> map) {
        if (map.containsKey(coupon)) return map.size();
        else {
            return map.size() == menu ? map.size() : map.size() + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro();

        bw.close();
    }
}
