import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] my_strings, int[][] parts) {
//         return IntStream.range(0, my_strings.length)
//             .mapToObj(i -> {
//                 String str = my_strings[i];
//                 int[] arr = parts[i];

//                 return IntStream.range(arr[0], arr[1]+1)
//                     .mapToObj(index -> String.valueOf(str.charAt(index)))
//                     .collect(Collectors.joining());
//             }).collect(Collectors.joining());
        
        return IntStream.range(0, parts.length)
            .mapToObj(i -> my_strings[i].substring(parts[i][0], parts[i][1] + 1))
            .collect(Collectors.joining());
    }
}