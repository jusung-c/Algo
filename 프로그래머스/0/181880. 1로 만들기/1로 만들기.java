class Solution {
    public int solution(int[] num_list) {
        int cnt = 0;
        
        for(int n : num_list) {
            while (n != 1) {
                switch (n % 2) {
                    case 1:
                        n = (n-1)/2;
                        break;
                    case 0:
                        n /= 2;
                        break;
                }
                
                cnt++;
            }
        }
        
        return cnt;
    }
}