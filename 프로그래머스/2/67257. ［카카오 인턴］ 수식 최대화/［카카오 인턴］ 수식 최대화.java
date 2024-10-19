import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
    // 동일한 우선순위는 될 수 없다. 연산자의 종류가 3가지이므로 총 3! = 6 가지의 조합이 가능하다.
    private static final String[][] orders = {
            "+-*".split(""),
            "+*-".split(""),
            "-+*".split(""),
            "-*+".split(""),
            "*+-".split(""),
            "*-+".split("")
    };

    private long calculate(long a, long b, String op) {
        switch(op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            default: return 0;
        }
    }

    public long solution(String expression) {

        // 연산자, 피연산자 토큰으로 분리
        StringTokenizer st = new StringTokenizer(expression, "[+-*]", true);
        List<String> tokens = new LinkedList<>();

        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        // 우선순위에 따라 계산
        long max = 0;

        for (String[] order : orders) {
            long result = Math.abs(calculate(new LinkedList<>(tokens), order));

            max = Math.max(max, result);
        }

        return max;
    }

    private long calculate(List<String> tokens, String[] order) {

        for (String op : order) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {

                    long a = Long.parseLong(tokens.get(i - 1));
                    long b = Long.parseLong(tokens.get(i + 1));
                    long value = calculate(a, b, op);

                    // 50 * 6 - 3 * 2
                    // 0  1 2 3 4 5 6

                    // 50 * 3 * 2
                    // 0  1 2 3 4

                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(value));

                    // 인덱스도 당겨주기
                    i = i - 2;
                }
            }
        }

        return Long.parseLong(tokens.get(0));
    }
}