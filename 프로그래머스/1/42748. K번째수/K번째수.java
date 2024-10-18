import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        // 배열의 i~j번째 숫자까지 자르고 정렬했을 때 k번째에 있는 수를 구하라
        int[] newArray;
        int[] answer = new int[commands.length];
        
        for (int t=0; t<commands.length; t++) {
            int i = commands[t][0];
            int j = commands[t][1];
            newArray = new int[j-i+1];
            for (int index=0, k=i-1; k<j; k++) {
                newArray[index++] = array[k];
            }
            
            Arrays.sort(newArray);
            answer[t] = newArray[commands[t][2] - 1];
        }   
        
        return answer;
        
    }
}