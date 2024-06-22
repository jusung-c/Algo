class Solution {
    public int solution(int[][] arr) {
        int answer = 1;
        
        for (int i=0; i<arr.length; i++) {
            for (int j = i + 1; j<arr[0].length; j++) {
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        
        return answer;
    }
}