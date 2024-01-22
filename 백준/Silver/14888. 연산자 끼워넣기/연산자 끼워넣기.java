import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static int[] nums, operators, order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        operators = new int[5];
        for (int i = 1; i < 5; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        order = new int[N];

        rec_func(1, nums[1]);

        bw.write(max + "\n" + min);

        br.close();
        bw.close();
    }

    static void rec_func(int k, int sum) throws IOException {
        if (k == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
        } else {
            for (int i = 1; i < 5; i++) {
                if (operators[i] >= 1) {
                    operators[i]--;
                    order[k] = i;


                    // 다음 연산자 뽑기
                    rec_func(k + 1, calc(sum, i, nums[k + 1]));

                    // 초기화
                    operators[i]++;
                    order[k] = 0;
                }
            }
        }
    }

    static int calc(int sum, int i, int num) {
        if (i == 1) {
            sum += num;
        }
        if (i == 2) {
            sum -= num;
        }
        if (i == 3) {
            sum *= num;
        }
        if (i == 4) {
            sum /= num;
        }
        
        return sum;
    }

}

