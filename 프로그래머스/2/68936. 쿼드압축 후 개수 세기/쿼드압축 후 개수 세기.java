class Solution {
    // 1. 상태 정의
    // (offsetX, offsetY)로 시작하고, 한 변의 길이가 size인 정사각형의 0과 1의 개수
    private class Count {
        int zero, one;

        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count o) {
            return new Count(zero + o.zero, one + o.one);
        }
    }

    private Count getCount(int offsetX, int offsetY, int size, int[][] arr) {

        // 2. 종료 조건 탈출
        // 정사각형 내의 원소가 모두 1이거나 모두 0일 때 종료
        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {

                if (arr[y][x] != arr[offsetY][offsetX]) {
                    int h = size / 2;

                    // 3. 점화식 정의
                    // 4개의 정사각형으로 쪼갠 뒤 재귀 호출로 압축된 결과를 더해주기
                    return getCount(offsetX, offsetY, h, arr)
                            .add(getCount(offsetX + h, offsetY, h, arr))
                            .add(getCount(offsetX, offsetY + h, h, arr))
                            .add(getCount(offsetX + h, offsetY + h, h, arr));
                }
            }
        }

        // 종료 조건 탈출
        return arr[offsetY][offsetX] == 1 ? new Count(0, 1) : new Count(1, 0);
    }

    public int[] solution(int[][] arr) {
        Count count = getCount(0, 0, arr.length, arr);
        return new int[]{count.zero, count.one};
    }
}