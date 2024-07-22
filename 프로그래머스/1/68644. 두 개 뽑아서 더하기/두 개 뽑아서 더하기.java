import java.util.HashSet;
import java.util.Set;

class Solution {
    private Set<Integer> set;
    private int[] numbers;

    private void combine(int start, int count, int currentSum) {
        // Base case: if we have selected 2 numbers, add the sum to the set
        if (count == 2) {
            set.add(currentSum);
            return;
        }
        
        // Iterate through the numbers array starting from 'start' index
        for (int i = start; i < numbers.length; i++) {
            // Recursively call combine to pick the next number
            combine(i + 1, count + 1, currentSum + numbers[i]);
        }
    }
    
    public int[] solution(int[] numbers) {
        set = new HashSet<>();
        this.numbers = numbers;
        
        // Start the recursive combination process
        combine(0, 0, 0);
        
        return set.stream().mapToInt(i -> i).sorted().toArray();
    }
}
