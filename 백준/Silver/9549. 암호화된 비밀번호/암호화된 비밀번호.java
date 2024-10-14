import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;
    static String after, before;


    public static void init() throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            after = br.readLine();
            before = br.readLine();

            bw.write(pro() ? "YES" : "NO");
            bw.newLine();
        }
    }

    private static boolean pro() throws IOException {
        int[] beforeCnt = new int[26];
        for (int i = 0; i < before.length(); i++) {
            beforeCnt[before.charAt(i) - 'a']++;
        }

        int size = 0;
        int[] afterCnt = new int[26];

        for (int R = -1, L = 0; L < after.length(); L++) {
            if (L != 0) {
                afterCnt[after.charAt(L - 1) - 'a']--;
                size--;
            }

            while (R + 1 < after.length() && size < before.length()) {
                R++;
                afterCnt[after.charAt(R) - 'a']++;
                size++;
            }

//            if (size == before.length()) {
//                System.out.println("========");
//                if (checkEq(afterCnt, beforeCnt)) {
//                    System.out.println("*********");
//                    return true;
//                }
//            }

            if (size == before.length() && checkEq(afterCnt, beforeCnt)) return true;
        }

        return false;
    }

    private static boolean checkEq(int[] after, int[] before) {
        for (int i = 0; i < 26; i++) {
            if (before[i] == 0) continue;
//            System.out.println("원본: " + before[i] + " 암호본: " + after[i]);
            if (before[i] != after[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        init();

        bw.close();
    }
}
