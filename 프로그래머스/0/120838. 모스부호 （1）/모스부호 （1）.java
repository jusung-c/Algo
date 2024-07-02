import java.util.*;

class Solution {
    public String solution(String letter) {
        String answer = "";
        String morse = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f','--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l','--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r','...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'";
        
        String morseList[] = morse.split(",");
        String letterList[] = letter.split(" ");
        
        Map<String, String> morseMap = new HashMap<String, String>();
        
        for (int i=0; i<morseList.length; i++) {
            morseList[i] = morseList[i].replaceAll("'", "");
            
            int index = morseList[i].indexOf(":");
            
            morseMap.put(morseList[i].substring(0, index), morseList[i].substring(index+1));
        }
        
        for (int i=0; i<letterList.length; i++) {
            answer += morseMap.get(letterList[i]);
        }
                      
        return answer;
    }
}