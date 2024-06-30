import java.util.stream.*;

class Solution {
    public String[] solution(String[] strArr) {
        IntStream.range(0, strArr.length)
            .forEach(i -> {
                if (i % 2 == 1) {
                    strArr[i] = strArr[i].toUpperCase();
                } else {
                    strArr[i] = strArr[i].toLowerCase();
                }
            });
        
        return strArr;
    }
}