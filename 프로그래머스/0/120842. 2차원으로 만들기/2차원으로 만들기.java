class Solution {
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int k = 0;
        
        for (int i=0; i<num_list.length; i += n) {
            System.out.println("i: " + i);
            
            int index = 0;
            System.out.println("index: " + index);
            
            for(int j=i; j<i+n; j++) {
                System.out.println("j: " + j + " value: " + num_list[j]);
                answer[k][index++] = num_list[j];
            }
            
            k++;
        }
        
        return answer;
    }
}