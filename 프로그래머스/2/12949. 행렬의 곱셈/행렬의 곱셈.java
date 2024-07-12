class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row=0; row<answer.length; row++) {  // arr1 row 수
            for (int col=0; col<answer[row].length; col++) {   // arr2 col 수
                // answer[row][col] 값 구하기
                for (int k=0; k<arr1[row].length; k++) {
                    
                    // arr1은 행 단위로 하나씩, arr2는 열 단위로 하나씩
                    answer[row][col] += arr1[row][k] * arr2[k][col];
                }
            }
        }
        
        return answer;
    }
}