import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int[] nums;
    static boolean[] used;
    static LinkedHashSet<String> set = new LinkedHashSet<>();
    static String numString = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        used = new boolean[10001];

        rec_func(1, numString);

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            bw.write(iterator.next() + "\n");
        }

        br.close();
        bw.close();
    }

    static void rec_func(int k, String numString) throws IOException {
        if (k == M + 1) {
            set.add(numString);
        } else {
            for (int i = 1; i <= N; i++) {
                if(used[i]) continue;

                used[i] = true;

                rec_func(k + 1, numString+nums[i] + " ");

                used[i] = false;
            }
        }
    }
}
