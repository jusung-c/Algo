import java.util.*;

class Solution {
    static int[][] pattern = new int[][] {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    public int[] solution(int[] answers) {
        // 정답을 찍는 3개의 패턴이 있을 때 주어진 답지와 비교해 가장 많이 맞춘 사람을 고르자
        int[] result = new int[3];
        
        // 채점 결과
        for (int index=0; index<answers.length; index++) {
            for (int i=0; i<3; i++)
                if (answers[index] == pattern[i][index % pattern[i].length]) 
                    result[i]++;
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i=0; i<3; i++) max = Math.max(max, result[i]);
        for (int i=0; i<3; i++) if (result[i] == max) answer.add(i+1);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}