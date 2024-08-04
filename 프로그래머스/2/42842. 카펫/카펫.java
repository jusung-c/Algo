class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};

        // 가로 길이 x, 세로 길이 y일 때
        // brown: 2x + 2y - 4
        // yellow: (x-2) * (y-2)

        // 갈색과 노랑의 최소가 8, 1 이라는 것은 x와 y가 최소 3이라는 것. 즉, 3 <= y <= x
        // 갈색의 최대가 5_000 이므로 가로의 최대가 2500을 넘지 않는다.
        for (int x = 0; x < 2500; x++) {
            for (int y = 0; y <= x; y++) {
                if (brown == (2 * x + 2 * y - 4) && yellow == (x - 2) * (y - 2)) {
                    return new int[]{x, y};
                }

            }
        }

        return answer;
    }
}