import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] selected, used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M + 1];
        used = new int[N + 1];

        rec_func(1);

        bw.close();
    }

    private static void rec_func(int k) throws IOException {
        // 한 케이스 찾았으면 출력
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) {
                bw.write(selected[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            // 중복 체크
            if(used[i] == 1) continue;

            // k번째에 i가 올 수 있으면 선택
            selected[k] = i;
            // 선택한 값 중복 체크를 위해 1로 설정
            used[i] = 1;

            // 재귀 호출
            rec_func(k + 1);

            // 다시 선택하기 전으로
            selected[k] = 0;
            used[i] = 0;
        }

    }

}
