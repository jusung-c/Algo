import java.util.stream.*;
import java.util.*;

class Solution {
    public String[] solution(String[] str_list) {
        int index = IntStream.range(0, str_list.length)
            .filter(i -> str_list[i].equals("l") || str_list[i].equals("r"))
            .findFirst()
            .orElse(-1);
        
        if (index == -1) return new String[]{};
        
        if (str_list[index].equals("l"))
            return Arrays.copyOfRange(str_list, 0, index);
        else if (str_list[index].equals("r"))
            return Arrays.copyOfRange(str_list, index + 1, str_list.length);
        
        return null;
    }
}