import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> scoresMap = buildScoresMap(info);

        return Stream.of(query)
                .mapToInt(q -> count(q, scoresMap))
                .toArray();
    }

    // qeury에 맞는 지원자 수 세기
    private int count(String query, Map<String, List<Integer>> scoresMap) {
        String[] tokens = query.split(" (and )?");

        // scoresMap에서 검색할 수 있는 키 형태로 만들기
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        if (!scoresMap.containsKey(key)) return 0;
        List<Integer> scores = scoresMap.get(key);
        
        int score = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(score, scoresMap.get(key));
    }

    // 이진탐색으로 target 보다 크거나 같은 값 중 가장 작은 값의 인덱스 구하기
    private int binarySearch(int score, List<Integer> scores) {
        int start = 0;
        // 조건을 만족하는 값 중 가장 작은 값이므로 마지막 범위 포함
        int end = scores.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= score) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        if (scores.get(start) < score) {
            return scores.size();
        }

        return start;
    }

    private Map<String, List<Integer>> buildScoresMap(String[] info) {
        // key: 검색 조건 | value: 검색 조건에 들어있는 점수들의 리스트
        Map<String, List<Integer>> scoresMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);

            // 모든 조건 탐색
            forEachKey(0, "", tokens, key -> {
                scoresMap.putIfAbsent(key, new ArrayList<>());
                scoresMap.get(key).add(score);
            });
        }

        for (List<Integer> list : scoresMap.values()) {
            Collections.sort(list);
        }

        return scoresMap;
    }

    private void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
        if (index == tokens.length - 1) {
            // prefix가 만들어진 검색 조건
            action.accept(prefix);

            return ;
        }

        // 가능한 모든 검색 조건 탐색
        forEachKey(index + 1, prefix + tokens[index], tokens, action);
        forEachKey(index + 1, prefix + "-", tokens, action);
    }
}