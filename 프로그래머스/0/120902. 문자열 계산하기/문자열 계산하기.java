import java.util.*;

class Solution { // "1 + 2 - 3 + 4 - 3"
    public int solution(String my_string) {
        int[] operands = Arrays.stream(my_string.split(" [+-] ")) // 1 2 3 4 3
            .mapToInt(Integer::parseInt)
            .toArray();
        String[] opcodes = my_string.replaceAll("[0-9]", "").trim().split("[ ]+"); // + - + -
        
        for (int a : operands) System.out.println("rand: " + a);
        for (String a : opcodes) System.out.println("op: " + a);
        
        int answer = operands[0];
        
        for(int i=0; i<opcodes.length; i++) {
            switch (opcodes[i]) {
                case "+":
                    answer += operands[i+1];
                    break;
                case "-":
                    answer -= operands[i+1];
                    break;
            }
        }
        
        
        return answer;
    }
}