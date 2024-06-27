import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        
        int arr[] = new int[7];
        arr[a]++;
        arr[b]++;
        arr[c]++;
        arr[d]++;
        
        int size = 0;
        ArrayList<Integer> cnt = new ArrayList<>();
        for (int i = 1; i<=6; i++) {
            if (arr[i] != 0) {
                size++;
                if (!cnt.contains(i)) cnt.add(i);
            }
        }
        
        if (size == 1) {
            return 1111 * a;
        } else if (size == 2) {
            System.out.println(cnt.size());
            if (arr[cnt.get(0)] != 2) {
                int sum = arr[cnt.get(0)] == 3 ? 10*cnt.get(0)+cnt.get(1) : 10*cnt.get(1)+cnt.get(0);
                
                System.out.println(sum);
                return (int) Math.pow(sum, 2);
                
            } else {
                System.out.println("hi");
                return (cnt.get(0)+cnt.get(1)) * Math.abs(cnt.get(0)-cnt.get(1));
            }
            
            
        } else if (size == 3) {
            return IntStream.rangeClosed(1,6)
                        .filter(i -> arr[i] == 1)
                        .reduce(1, (q, w) -> q * w);
        } else {
            // return IntStream.rangeClosed(1, 6)
            //         .filter(i -> arr[i] > 0)
            //         .boxed()
            //         .min((i, j) -> Integer.compare(arr[i], arr[j]))
            //         .orElse(-1);
            
            return cnt.stream().mapToInt(i->i).min().getAsInt();

        }
        
    }
}