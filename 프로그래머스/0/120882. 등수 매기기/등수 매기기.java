import java.util.stream.*;

class Solution {
    public int[] solution(int[][] score) {
        double[] aver = IntStream.range(0, score.length) 
            .mapToDouble(i -> (score[i][0] + score[i][1]) / 2.0)
            .toArray();
        
        int[] answer = new int[aver.length];
        
        for (int i=0; i<aver.length; i++) {
            int cnt = 1;
            
            for (int j=0; j<aver.length; j++) {
                if (aver[i] < aver[j]) cnt++;
            }
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}

// [1, 1]