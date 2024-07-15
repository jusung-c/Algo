class Solution {
    // 0과 1의 개수를 한 번에 담을 수 있는 Count 클래스 작성
    private static class Count {
        public final int zero;
        public final int one;
        
        public Count(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        // 두 Count 객체 합치는 메서드
        public Count add(Count other) {
            return new Count(zero + other.zero, one + other.one);
        }
    }
    
    // 재귀
    private Count count(int offsetX, int offsetY, int size, int[][] arr) {
        int h = size / 2;
        
        // 종료 조건 : 모든 원소가 동일한 값을 가질 때
        for (int x=offsetX; x<offsetX+size; x++) {
            for (int y=offsetY; y<offsetY+size; y++) {
                
                // 모든 원소가 같은 값이 아닐 경우
                if (arr[y][x] != arr[offsetY][offsetX]) {
                    return count(offsetX, offsetY, h, arr)
                        .add(count(offsetX + h, offsetY, h, arr))
                        .add(count(offsetX, offsetY + h, h, arr))
                        .add(count(offsetX + h, offsetY + h, h, arr));
                }
            }
        }
        
        // 모든 원소가 같은 값인 경우
        return arr[offsetY][offsetX] == 1 ? 
            new Count(0, 1) : new Count(1, 0);
        
    }
    
    public int[] solution(int[][] arr) {
        
        Count count = count(0, 0, arr.length, arr);
        return new int[] {count.zero, count.one};
        
    }
}