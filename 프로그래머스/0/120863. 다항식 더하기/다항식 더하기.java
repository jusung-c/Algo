class Solution {
    public String solution(String polynomial) {
        String answer = "";
        String front = "";
        String mid = "";
        String end = "";
        int a = 0;
        int b = 0;
        
        String[] arr = polynomial.split(" \\+ ");
        
        for(String s : arr) {
            if (s.charAt(s.length()-1) == 'x')
                if (s.length() == 1) a+=1;
                else a += Integer.parseInt(s.substring(0, s.length()-1));
            else
                b += Integer.parseInt(s);
        }
        
        if (a == 1) front = "x";
        else if (a > 1) front = String.valueOf(a) + "x";
        
        if (b != 0) end = String.valueOf(b);
        
        if (!front.isEmpty() && !end.isEmpty())
            mid = " + ";
        
        return front + mid + end;
    }
}