class Solution {
    public int[] solution(int brown, int yellow) {
        // 테두리는 갈색, 나머지는 노란색으로 칠해진 카펫
        // 갈색, 노란색 격자의 개수가 주어질 때 카펫의 가로, 세로 길이를 구하라 (가로 >= 세로)
        
        // 가로 x, 세로 y일 때 brown: 2x + 2y - 4이고, yellow: (x-2)(y-2)이다. 
        // brown: 2(x + y) - 4
        // yellow: x*y -2(x + y) + 4
        // brown + yellow = x * y
        
        // yellow가 1이상 -> 가로 세로가 최소 3 이상
        // brown은 8이상 5000이하 -> 가로 세로는 5000이하
        
        for (int x=3; x<=5000; x++) {
            for (int y=3; y<=x; y++) {
                int brownCnt = 2*x + 2*y - 4;
                int yellowCnt = (x-2)*(y-2);
                
                if (brownCnt == brown && yellowCnt == yellow) {
                    return new int[] {x, y};
                }
            }
        }
        
        return null;
    }
}