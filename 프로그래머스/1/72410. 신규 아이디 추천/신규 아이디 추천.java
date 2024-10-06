class Solution {
    public String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9.\\-_]", "");
        answer = answer.replaceAll("[.]+", ".");
        answer = answer.replaceAll("^[.]|[.]$", "");
        answer = answer.isEmpty() ? "a" : answer;
        answer = answer.length() >= 16 ? answer.substring(0, 15) : answer;
        answer = answer.replaceAll("[.]$", "");
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += String.valueOf(answer.charAt(answer.length() - 1));
            }
        }

        
        
        
        System.out.println(answer);
        
        return answer;
    }
}