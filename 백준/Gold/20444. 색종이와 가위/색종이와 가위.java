import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static long K;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

    }

    static void pro() throws IOException {
        int L = 0;
        int R = N / 2;

        while (L <= R) {
            int mid = (L + R) / 2;

            if (paper(mid) > K) {
                R = mid - 1;
            } else if(paper(mid) < K){
                L = mid + 1;
                
            // 찾은 경우    
            } else if(paper(mid) == K){
                bw.write("YES"+" ");
                return;
            }
        }

        bw.write("NO"+" ");
    }

    static long paper(long mid) {
        long row = mid;
        long col = N - row;

        return (row + 1) * (col + 1);
    }

    public static void main(String[] args) throws IOException {
        init();

        pro();

        bw.close();
    }

}