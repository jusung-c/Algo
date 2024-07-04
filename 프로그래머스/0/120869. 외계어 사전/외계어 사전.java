import java.util.stream.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for (int i=0; i<dic.length; i++) {
            if (dic[i].length() != spell.length) continue;
            
            boolean isExist = true;
            for(int j=0; j<spell.length; j++) {
                if (!dic[i].contains(spell[j]))
                    isExist = false;
            }
            
            if (isExist) return 1;
        }   
        
        return 2;
    }
}