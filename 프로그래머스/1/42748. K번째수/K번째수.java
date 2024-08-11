import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {

            int start = commands[i][0];
            int end = commands[i][1];
            int index = commands[i][2];

            int[] sorted = IntStream.range(start - 1, end) // IntStream
                    .map(n -> array[n])     // IntStream
                    .sorted()               // IntStream
                    .toArray();// int[]


            answer[i] = sorted[index - 1];
        }

        return answer;
    }
}