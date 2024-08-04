import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String numbers) {
        int[] nums = numbers.chars()
                .map(c -> c - '0')
                .toArray();

        boolean[] isUsed = new boolean[numbers.length()];

        Set<Integer> primes = new HashSet<>();

        // 1. 주어진 종이 조각의 수로 만들 수 있는 모든 조합 구하기

        // 재귀로 모든 조합을 구해야 한다.
        // 상태: 지금까지 만든 숫자를 acc, 남은 숫자들을 numbers라고 할 때 (acc, numbers)
        // 종료 조건: 모든 숫자를 다 사용해서 더 이상 남은 숫자가 없는 경우. (acc, 0)
        // 재귀: (acc*10+n, numbers-n)

        getPrimes(0, nums, isUsed, primes);

        return primes.size();
    }

    // 재귀 호출
    private void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes) {
        // 소수인지 판단
        if (isPrime(acc)) primes.add(acc);

        // 숫자 이어 붙이기
        for (int i = 0; i < numbers.length; i++) {
            if (isUsed[i]) continue;

            int nextAcc = acc * 10 + numbers[i];
            isUsed[i] = true;

            getPrimes(nextAcc, numbers, isUsed, primes);

            isUsed[i] = false;
        }
    }

    private boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}
