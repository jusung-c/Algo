// begin에서 한 개의 알파벳만 바꿔가면서 target을 만든다.
// 알파벳을 바꿀 때에는 바꾸고 난 뒤의 단어가 words안에 포함될 때만 가능하다.

// 각 단어는 알파벳 소문자로만 이루어져 있다.
// 모든 단어의 길이는 같으며 3 이상 10 이하이다.
// begin != target
// 변환할 수 없는 경우는 0을 반환

import java.util.*;

class Solution {
    Map<String, Integer> dist;
    
    public List<String> findChangeList(String text, String[] words) {
        List<String> cList = new ArrayList<>();
        
        for (String w : words) {
            int cnt = 0;
            char[] tc = text.toCharArray();
            char[] wc = w.toCharArray();
            
            // 동일한 위치에 동일한 문자가 있는 경우 카운트
            for (int i=0; i<tc.length; i++) if (tc[i] == wc[i]) cnt++;
            
            if (cnt + 1 == text.length()) cList.add(w);
        }
        
        return cList;
    }
    
    public void bfs(String text, String target, String[] words) {
        Queue<String> que = new LinkedList<>();
        que.add(text);
        dist.put(text, 0);
        
        while(!que.isEmpty()) {
            text = que.poll();
            
            // begin에서 한글자만 바꿔서 만들 수 있는 words 단어 리스트를 찾는다.
            List<String> cList = findChangeList(text, words);
            
            // System.out.println(text +"가 변경될 수 있는 단어들은 다음과 같습니다.");
            // for (String s : cList) System.out.print(s + " ");
            // System.out.println();
            
            for (String change : cList) {
                // // 가능한 문자열들 중 변경한 횟수가 더 적을 경우에만 고려한다.    
                // if (dist.get(change) > dist.get(text) + 1) {
                //     System.out.println(change  +" 로 변경합니다!");
                //     que.add(change);
                //     dist.put(change, dist.get(text) + 1);
                // }
                
                if (dist.get(change) != -1) continue;
                que.add(change);
                dist.put(change, dist.get(text) + 1);
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        // words에 target이 없으면 0을 반환한다.
        boolean exist = false;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(target)) {
                exist = true;
                break;
            }
        }
        if (!exist) return 0;
        
        // 거리 배열 초기화
        dist = new HashMap<>();
        for (int i=0; i<words.length; i++) dist.put(words[i], -1);
        
        // begin에서 시작해서 한글자씩 바꿔보면서 words에 있는 단어인지 확인한다.
        bfs(begin, target, words);
        
        // target에 해당하는 단어까지 얼마나 걸렸는지 출력한다.
        return dist.get(target) == -1 ? 0 : dist.get(target);
    }
}