class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for(int i=1; i<=n; i++) {
            answer += 1;
            
            if (checkThree(answer)) {
                while (checkThree(answer)) {
                    System.out.println("저주의 숫자: " + answer);
                    answer += 1;
                }
            }
            
            System.out.println("i: " + i + " answer: " + answer);
        }
        
        return answer;
    }
    
    public boolean checkThree(int answer) {
        if (String.valueOf(answer).contains("3")) return true;
        
        if (answer % 3 == 0) return true;
        
        return false;
    }
}