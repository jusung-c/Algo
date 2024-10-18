class Solution {    
    public int solution(int[][] sizes) {
        // 각 명함마다 가로, 세로 길이 중 하나를 택하고,
        // 지갑 크기를 계산해 최소값 갱신하기
        
        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;
        
        // 1. 가로, 세로 중 긴 길이를 가로로, 짧은 길이를 세로로 설정하기
        for (int i=0; i<sizes.length; i++) {
            int temp = 0;
            
            if (sizes[i][1] > sizes[i][0]) {
                temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            // 2. 각 명함의 가로, 세로의 최댓값 구하기
            maxA = Math.max(maxA, sizes[i][0]);
            maxB = Math.max(maxB, sizes[i][1]);
        }
        
        return maxA * maxB;
    }
}