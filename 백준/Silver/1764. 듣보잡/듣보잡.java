import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, cnt;
    static String[] list;
    static List<String> answer;

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;

        list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        Arrays.sort(list);

        answer = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String target = br.readLine();

            if(binarySearch(target)) {
                cnt++;
                answer.add(target);
            }
        }

    }

    private static boolean binarySearch(String target) {
        int start = 0;
        int end = list.length - 1;

        while (end > start) {
            int mid = (start + end) / 2;
            String value = list[mid];

            if (value.equals(target)) return true;
            else if (value.compareTo(target) > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (list[start].equals(target)) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.write(cnt + "\n");

        Collections.sort(answer);

        for (String s : answer) {
            bw.write(s + "\n");
        }

        bw.close();
    }
}