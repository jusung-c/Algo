import java.util.stream.*;

class Solution {
    public int solution(String before, String after) {
        
        int cnt[] = new int[26];
        int result = 1;
        
        IntStream.range(0, after.length())
            .forEach(i -> {
                cnt[after.charAt(i) - 'a']++;
            });
        
        for(int i=0; i<before.length(); i++) {
            if (cnt[before.charAt(i)-'a'] == 0)
                return 0;
            else cnt[before.charAt(i)-'a']--;
        }
            
        return result;
        
    }
}