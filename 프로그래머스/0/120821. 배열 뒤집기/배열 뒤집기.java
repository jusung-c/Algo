class Solution {
    public int[] solution(int[] num_list) {
        int size = num_list.length;
        int[] answer = new int[size];
        
        for(int i=0; i<size; i++) {
            int val = num_list[i];
            answer[size-i-1] = val;
        }
        
        return answer;
    }
}