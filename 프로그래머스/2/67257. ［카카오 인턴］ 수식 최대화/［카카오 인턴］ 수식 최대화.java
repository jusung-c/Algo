import java.util.*;

class Solution {
    private static final String[][] orders = {
        "+-*".split(""),
        "+*-".split(""),
        "-+*".split(""),
        "-*+".split(""),
        "*-+".split(""),
        "*+-".split("")
    };
    
    private long calculate(long a, long b, String op) {
        switch(op) {
            case "+": return a+b;
            case "-": return a-b;
            case "*": return a*b;
            default: return 0;
        }
    }
    
    private long calculate(List<String> tokens, String[] order) {
        
        // 연산자 우선순위에 따라 계산
        for (String op : order) {
            for (int i=1; i<tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    
                    // 수식 계산
                    long a = Long.parseLong(tokens.get(i-1));
                    long b = Long.parseLong(tokens.get(i+1));
                    long value = calculate(a, b, op);
                    
                    // 배열 당겨오기
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(value));

                    // 인덱스도 당겨주기
                    i-=2;
                }
                
            }
        }
        
        return Long.parseLong(tokens.get(0));
    }
    
    public long solution(String expression) {
        
        StringTokenizer st = new StringTokenizer(expression, "+-*", true);
        List<String> tokens = new LinkedList<>();
        
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }
        
        long max = 0;
        
        // 우선순위에 따라 계산
        for (String[] order : orders) {
            long value = Math.abs(calculate(new ArrayList<>(tokens), order));
            System.out.println(value);
            
            max = value > max ? value : max;
        }
        
        return max;
            
    }
}