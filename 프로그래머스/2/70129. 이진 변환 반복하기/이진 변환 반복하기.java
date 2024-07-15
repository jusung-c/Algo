class Solution {
    public int[] solution(String s) {
        int del = 0;
        int cnt = 0;
        
        while (!s.equals("1")) {
            // 0 제거
            String nonZero = s.replace("0", "");
            
            // 제거한 0 개수 업데이트
            del += s.length() - nonZero.length();
            
            // nonZero의 길이를 이진 변환
            s = Integer.toString(nonZero.length(), 2);
            cnt++;
        }
        
        return new int[]{cnt, del};
    }
}