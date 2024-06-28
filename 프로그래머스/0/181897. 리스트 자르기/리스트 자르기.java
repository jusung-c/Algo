import java.util.stream.*;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch(n) {
            case 1:
                return IntStream.rangeClosed(0, slicer[1]).map(i -> num_list[i]).toArray();
                
            case 2:
                return IntStream.range(slicer[0], num_list.length).map(i -> num_list[i]).toArray();
                
            case 3:
                return IntStream.rangeClosed(slicer[0], slicer[1]).map(i -> num_list[i]).toArray();
                
            case 4:
                return IntStream.rangeClosed(slicer[0], slicer[1])
                    .filter(i -> (i - slicer[0]) % slicer[2] == 0)
                    .map(i -> num_list[i])
                    .toArray();
            default:
                return null;
        }    
    }
}