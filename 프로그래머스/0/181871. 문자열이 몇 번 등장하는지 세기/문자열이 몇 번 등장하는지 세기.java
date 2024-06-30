class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        for (int i=0; i<myString.length(); i++) {
            if (myString.charAt(i) == pat.charAt(0)) {
                if (check(i, myString, pat)) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    public boolean check(int i, String myString, String pat) {
        if ((i + pat.length()) > myString.length()) return false;
        
        String answer = myString.substring(i, i + pat.length());
        return answer.contains(pat);
    }
}