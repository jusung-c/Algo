class Solution {
    public String[] solution(String[] picture, int k) {
        int n = picture.length;
        int m = n * k;
        
        String[] answer = new String[m];
        for(int i = 0; i < m; i++) {
            answer[i] = "";
        }
        
        int index = 0;
        
        for (int i=0; i<n; i++) {
            for (int j = 0 ; j < picture[i].length(); j++) {
                for(int z = 0; z < k; z++) {
                    answer[index] += picture[i].charAt(j);

                }
            }
            
            System.out.println(answer[index]);
            for (int j=1; j<k; j++) {
                answer[index + 1] = answer[index];
                index++;
            }
            
            index++;

        }
        
        
        return answer;
    }
}