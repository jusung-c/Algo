class Solution {
    public class State {
        int zero, one;
        
        State(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }
        
        State add(State os) {
            return new State(this.zero + os.zero, this.one + os.one);
        }
    }
    
    public State press(int startX, int startY, int length, int[][] map) {
        // 1. 현재 상태가 압축할 수 있는 상태인지 확인
        for (int r=startX; r<startX + length; r++) {
            for (int c=startY; c<startY + length; c++) {
                if (map[r][c] != map[startX][startY]) {
                    int nLength = length / 2;
                    
                    // 2. 압축이 불가능한 경우 쪼개서 다시 압축 시도
                    return press(startX, startY, nLength, map)
                        .add(press(startX + nLength, startY, nLength, map))
                        .add(press(startX, startY + nLength, nLength, map))
                        .add(press(startX + nLength, startY + nLength, nLength, map));
                }
            }
        }
        
        // 3. 압축이 가능하다면 압축
        return map[startX][startY] == 1 ? new State(0, 1) : new State(1, 0);
    }
    
    public int[] solution(int[][] arr) {        
        // 이차원 배열 쿼드 압축
        // 내부의 모든 수가 같은 값이라면 그 하나의 수로 압축
        // 내부의 수가 다르다면 4개의 정사각형으로 쪼개 압축 시도
        
        // 재귀적으로 압축 시도
        State answer = press(0, 0, arr.length, arr);
            
        return new int[] {answer.zero, answer.one};
    }
}