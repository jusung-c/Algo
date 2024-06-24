class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int a = arr1.length;
        int b = arr2.length;
        int sa = 0;
        int sb = 0;
        
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        } else {
            for (int i=0; i<a; i++) {
                sa += arr1[i];
                sb += arr2[i];
            }
        }
        
        if (sa == sb) return 0;
        else return sa < sb ? -1 : 1;
    }
}