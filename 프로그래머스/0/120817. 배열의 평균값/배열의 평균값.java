import java.util.stream.*;

class Solution {
    public double solution(int[] numbers) {
        return IntStream.range(0, numbers.length)
            .map(i -> numbers[i])
            .average()
            .getAsDouble();
    }
}