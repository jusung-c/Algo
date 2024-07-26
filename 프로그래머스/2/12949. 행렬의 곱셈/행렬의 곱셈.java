class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        
        // 행렬곱의 결과는 첫번째 행렬의 행 수와 두번째 행렬의 열 수를 크기로 가진다.
        int[][] answer = new int[arr1.length][arr2[0].length];

        for (int row = 0; row < answer.length; row++) {
            for (int col = 0; col < answer[row].length; col++) {

                for (int k = 0; k < arr1[row].length; k++) {
                    // arr1은 행 단위로 하나씩 arr2는 열 단위로 하나씩
                    answer[row][col] += arr1[row][k] * arr2[k][col];
                }
            }
        }
        
        return answer;
    }
}