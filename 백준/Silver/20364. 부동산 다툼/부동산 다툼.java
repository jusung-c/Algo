import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static int N, Q;
    static Set<Integer> banList;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        banList = new HashSet<>();

        for (int i = 0; i < Q; i++) {
            func(Integer.parseInt(br.readLine()));
        }
    }

    private static void func(int dream) throws IOException {
        int current = dream;
        int ans = 0;
        
        while (current > 0) {
            if (banList.contains(current)) {
                ans = current;
            }
            current /= 2;
        }

        if (ans == 0) {
            banList.add(dream);
        }

        bw.write(ans + "\n");
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
