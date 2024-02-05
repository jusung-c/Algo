import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static char[] arr, selected;

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[N + 1];
        arr[0] = 'a';
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        selected = new char[M + 1];

    }

    public static void main(String[] args) throws IOException {
        init();

        func(1, 0);

        br.close();
        bw.close();
    }

    private static void func(int k, int prev) throws IOException {
        if (k == M + 1) {
            if (test()) {
                for (int i = 1; i <= M; i++) {
                    bw.write(selected[i]);
                }
                bw.write("\n");
            }
        } else {
            for (int i = prev + 1; i <= N; i++) {
                selected[k] = arr[i];

                func(k + 1, i);

                selected[k] = 0;
            }
        }
    }

    static boolean test() {
        int vowel = 0;
        int cons = 0;

        for (int i = 1; i <= M; i++) {
            char c = selected[i];

            if (c == 'a' || c == 'e'
                    || c == 'i' || c == 'o' || c == 'u') {
                vowel++;
            } else {
                cons++;
            }
        }

        if (vowel >= 1 && cons >= 2) {
            return true;
        }

        return false;
    }
}
