import java.util.*;

class Solution {

    // 중복없이 순서없이 2개를 뽑는 조합 문제
    private void getNumbers(int k, int prev, int[] selected, int[] numbers, Set<Integer> answer) {
        if (k == 2) {
            int sum = selected[0] + selected[1];
            answer.add(sum);
            return;
        }

        for (int i = prev; i < numbers.length; i++) {
            selected[k] = numbers[i];

            getNumbers(k + 1, i + 1, selected, numbers, answer);

            selected[k] = 0;
        }
    }

    public int[] solution(int[] numbers) {

        int[] selected = new int[2];
        Set<Integer> answer = new LinkedHashSet<>();

        getNumbers(0, 0, selected, numbers, answer);

        return answer.stream()
                .sorted()
                .mapToInt(i -> i)
                .toArray();
    }
}