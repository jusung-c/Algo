class Solution {
    public String solution(String bin1, String bin2) {
        String answer = "";
        
        int a = toDemical(bin1);
        int b = toDemical(bin2);
        
        return toBinary(a+b);
    }
    
    public String toBinary(int demical) {
        if (demical == 0) return "0";
        
        StringBuilder binary = new StringBuilder();        
        while (demical >= 1) {
            binary.append(demical % 2);
            demical /= 2;
        }
        
        return binary.reverse().toString();
    }
    
    public int toDemical(String binary) {
        int result = 0;
        
        for(int i=0; i<binary.length(); i++) {
            if (binary.charAt(i) % 2 == 0) continue;
            else result += (int) Math.pow(2, binary.length() - i - 1);
        }
        
        return result;
    }
}