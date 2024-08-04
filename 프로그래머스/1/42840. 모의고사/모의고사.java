import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {
        // 1. 각 수포자들의 패턴 정의
        int[][] pattern = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] cnt = new int[3];

        // 2. 모든 답을 돌면서 각 수포자들이 답을 맞췄는지 확인
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            for (int j = 0; j < pattern.length; j++) {
                if (answer == pattern[j][i % pattern[j].length]) cnt[j]++;
            }
        }


        // 3. 가장 많은 답을 맞춘 수포자를 배열에 담아 반환
        List<Integer> answer = new ArrayList<>();

        int max = Arrays.stream(cnt).max().getAsInt();
        for (int i = 0; i < cnt.length; i++) {
            if(cnt[i] == max) answer.add(i + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}