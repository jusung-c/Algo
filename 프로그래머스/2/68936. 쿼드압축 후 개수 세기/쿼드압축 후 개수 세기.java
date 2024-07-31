class Solution {
    class Count {
        private int zeroCnt;
        private int oneCnt;

        public Count(int zeroCnt, int oneCnt) {
            this.zeroCnt = zeroCnt;
            this.oneCnt = oneCnt;
        }

        public Count add(Count other) {
            return new Count(this.zeroCnt + other.zeroCnt, this.oneCnt + other.oneCnt);
        }
    }

    // 재귀 함수
    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;

        // 정사각형의 원소를 다 돌면서 체크
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {

                // 정사각형의 모든 원소가 같은 값이 아닐 경우
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                            .add(count(offsetX + h, offsetY, h, arr))
                            .add(count(offsetX, offsetY + h, h, arr))
                            .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        // 정시각형의 모든 원소가 다 같은 경우
        return arr[offsetY][offsetX] == 1 ? new Count(0, 1) : new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = count(0, 0, arr.length, arr);

        return new int[]{count.zeroCnt, count.oneCnt};
    }
}