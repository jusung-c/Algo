import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        // n개 중 h번 이상 인용된 논문이 h개 이상
        // 나머지 논문이 h번 이하 인용되었을 때 h의 최댓값을 구하라

        Arrays.sort(citations);
        // 0, 1, 3, 5, 6

        for (int h = citations.length; h >= 1; h--) {
            if (isHIndex(citations, h)) return h;
        }

        return 0;
    }

    private boolean isHIndex(int[] citations, int h) {
        // 뒤에서부터 h번째는
        return citations[citations.length - h] >= h;
    }
}