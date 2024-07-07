class Solution {
    public int solution(int[] common) {
        int sub = common[common.length - 1] - common[common.length -2];
        
        if (sub == common[1] - common[0]) {
            return common[common.length - 1] + sub;
        } else {
            int mul = common[common.length - 1] / common[common.length -2];
            return common[common.length - 1] * mul;
        }
    }
}