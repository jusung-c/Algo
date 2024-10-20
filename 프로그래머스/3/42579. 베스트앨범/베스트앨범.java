import java.util.*;

class Solution {
    static Map<String, ArrayList<Music>> map;
    
    static class Music {
        int num, cnt;
        Music(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 장르별로 가장 많이 재생된 노래 2개씩 모으려고 해
        // 만약 같은 횟수로 재생된 경우는 고유 번호가 낮은 노래가 우선이야
        
        // 1. 장르별로 곡을 분류한다.
        map = new LinkedHashMap<>();
        for (int i=0; i<genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                ArrayList<Music> mList = new ArrayList<>();
                mList.add(new Music(i, plays[i]));
                
                map.put(genres[i], mList);
            } else {
                ArrayList<Music> mList = map.get(genres[i]);
                mList.add(new Music(i, plays[i]));
                
                map.put(genres[i], mList);
            }
        }
        
        // 2. 장르별로 수록곡의 재생 횟수가 높은 순으로, 
        // 재생 횟수가 같다면 고유 번호가 낮은 순으로 정렬한다.
        for (String s : map.keySet()) {
            ArrayList<Music> mList = map.get(s);
            
            Collections.sort(mList, (m1, m2) -> {
                if (m1.cnt != m2.cnt) {
                    return m2.cnt - m1.cnt;
                } else {
                    return m1.num - m2.num;
                }
            });
        }
        
        // 3. 총 재생횟수가 높은 장르부터 앞에서부터 최대 2곡을 선정한다. 
        // 장르별 총 횟수 계산하기
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        
        Collections.sort(keys, (s1, s2) -> {
            ArrayList<Music> m1 = map.get(s1);
            ArrayList<Music> m2 = map.get(s2);
            
            int sum1 = 0;
            int sum2 = 0;
            
            for (Music m : m1) sum1 += m.cnt;
            for (Music m : m2) sum2 += m.cnt;
            
            return sum2 - sum1;
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String s : keys) {
            ArrayList<Music> mList = map.get(s);
            
            if (mList.size() >= 2) {
                answer.add(mList.get(0).num);
                answer.add(mList.get(1).num);
            } else {
                answer.add(mList.get(0).num);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}