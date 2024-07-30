class Solution {
    public int solution(int n) {
        // 1. n을 3진법으로 표현
        String s = Integer.toString(n, 3);

        System.out.println("s = " + s);

        // 2. 문자열 뒤집기
        s = new StringBuilder(s).reverse().toString();

        System.out.println("s = " + s);

        // 3. 10진법으로 표현
        int answer = Integer.parseInt(s, 3);

        System.out.println("answer = " + answer);
        
        return answer;
    }
}