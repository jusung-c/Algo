class Solution {
    public int solution(String binomial) {
        String[] operand = binomial.split(" ");
        int op1 = Integer.parseInt(operand[0]);
        int op2 = Integer.parseInt(operand[2]);
        String op = operand[1];
        
        if (op.equals("+")) return op1 + op2;
        else if (op.equals("-")) return op1 - op2;
        else return op1 * op2;

    }
}