import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long M;
    static int[] trees;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 나무 개수
        N = Integer.parseInt(st.nextToken());

        // 필요한 나무의 길이
        M = Long.parseLong(st.nextToken());

        // 나무 리스트
        trees = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() throws IOException {

        // H의 범위인 L과 R 설정 H (1 ~ 20억)
        long L = 0;
        long R = 2000000000;
        
        long ans = 0;
        
        // 이분탐색 진행
        while (L <= R) {
            long mid = (L + R) / 2;
            
            // mid가 Yes면
            if (YesOrNo(mid) == true) {
                // ans 갱신
                ans = mid;
                
                // 범위 좁히기
                L = mid + 1;
            } else {
                // 범위 좁히기
                R = mid - 1;
            }
        }
        
        bw.write(ans+" ");
    }

    // Yes or No 채우기
    static boolean YesOrNo(long H) {
        // H 높이로 잘라서 M만큼 얻을 수 있는가? Yes or No?
        long sum = 0;

        // 자른 나무 길이 계산 
        for (int i = 1; i <= N; i++) {
            if (trees[i] > H) {
                sum += trees[i] - H;
            }
        }

        if (sum >= M) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }

}