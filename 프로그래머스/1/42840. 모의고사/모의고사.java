import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[] {1, 2, 3, 4, 5};
        int[] b = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int ac = 0;
        int bc = 0;
        int cc = 0;
        
        for (int i=0; i<answers.length; i++) {
            // a 수포자
            if (answers[i] == a[i % a.length]) ac++;
            if (answers[i] == b[i % b.length]) bc++;
            if (answers[i] == c[i % c.length]) cc++;
        }
        
        System.out.println("a: " + ac + " b: " + bc + " c: " + cc);
        
        int[] answer = new int[] {ac, bc, cc};
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<answer.length; i++) {
            max = Math.max(answer[i], max);
        }
        
        for (int i=0; i<answer.length; i++) {
            if (max == answer[i]) arr.add(i+1);
        }
        
        return arr.stream().mapToInt(i -> i).toArray();
    }
}