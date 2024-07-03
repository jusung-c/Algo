class Solution {
    public int solution(int[] numbers, int k) {
        return numbers[2*(k-1) % numbers.length];
    }
}

// 1 2 3 4 1 2 3 4 1 2 3 4
// 1 3

// 1 2 3 4 5 6 1 2 3 4 5 6
// 1 3 5 1 3 

// 1 2 3 1 2 3 1
// 1 3 2 

// 2 * (k-1) % numbers.length