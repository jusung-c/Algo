import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
        // 있으면 false, 없으면 true 반환
        
        // 1. 정렬
        Arrays.sort(phone_book);
        
        // 2. 앞뒤로 접두사 비교
        for (int i=0; i<phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])) return false;
        }
        
        return true;
    }
}