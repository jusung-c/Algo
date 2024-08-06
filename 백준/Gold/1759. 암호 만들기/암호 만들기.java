import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M;
    static char[] arr;
    static Set<Character> vowels = new HashSet<>();

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = br.readLine().replaceAll(" ", "").toCharArray();

        Arrays.sort(arr);

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

    }

    private static void pro(int k, int prev, StringBuilder acc, int vowel, int consonant) throws IOException {

        if (k == M) {
            if (vowel >= 1 && consonant >= 2) {
                bw.write(acc.toString() + "\n");
            }
            return;
        }

        for (int i = prev; i < N; i++) {
            char c = arr[i];

            // 모음, 자음 개수 업데이트
            boolean isVowel = vowels.contains(c);
            if (isVowel) vowel++;
            else consonant++;

            pro(k+1, i + 1, acc.append(c), vowel, consonant);

            acc.deleteCharAt(acc.length() - 1);
            if (isVowel) vowel--;
            else consonant--;

        }
    }

    public static void main(String[] args) throws Exception {
        init();

        pro(0, 0, new StringBuilder(), 0, 0);

        bw.close();
    }
}
