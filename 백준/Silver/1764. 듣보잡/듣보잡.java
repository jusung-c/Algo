import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;
    static String[] A, B;
    static ArrayList<String> result;

    private static void BSearch(String target) {
        int start = 1;
        int end = N;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (A[mid].equals(target)) {
                result.add(target);
            }

            // A[mid] - target < 0 -> A[mid] < target
            if (A[mid].compareTo(target) < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    public static void init() throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N + 1];

        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            A[i] = br.readLine();
        }

        Arrays.sort(A, 1, N + 1);

        for (int i = 0; i < M; i++) {
            BSearch(br.readLine());
        }
    }

    public static void main(String[] args) throws Exception {
        init();

        Collections.sort(result);
        bw.write(result.size()+"\n");

        Iterator<String> iter = result.iterator();
        while (iter.hasNext()) {
            bw.write(iter.next()+"\n");
        }

        br.close();
        bw.close();
    }
}
