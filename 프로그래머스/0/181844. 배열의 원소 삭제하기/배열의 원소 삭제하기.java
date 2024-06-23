import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {

        for (int a : delete_list) {
            arr = Arrays.stream(arr)
                .filter(i -> i != a)
                .toArray();
            
            
            for (int b : arr) {
                System.out.println(b);    
            }
            
        }
        
        return arr;
        
    }
}