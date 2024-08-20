import java.util.*;
import java.util.function.Consumer;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // 1. 모든 조건에 해당하는 정렬된 점수 리스트를 미리 사전처럼 만들어두기
        Map<String, List<Integer>> scoreMap = getScoreMap(info);

        // 2. 이분탐색으로 조건에 해당하면서 X 점수 이상인 경우의 수 찾기
        for (int i = 0; i < query.length; i++) {
            answer[i] = count(query[i], scoreMap);
        }

        return answer;
    }

    private int count(String query, Map<String, List<Integer>> scoreMap) {
        String[] tokens = query.split(" (and )?");

        // 점수는 빼고 토큰들을 합쳐 검색할 수 있는 key 형태로 만들기
        String key = String.join("", Arrays.copyOf(tokens, tokens.length - 1));

        // key에 해당하는 점수 리스트 조회
        if (!scoreMap.containsKey(key)) return 0;
        List<Integer> scores = scoreMap.get(key);

        // 이분탐색으로 target 점수 이상의 원소 개수 구하기
        int target = Integer.parseInt(tokens[tokens.length - 1]);
        return scores.size() - binarySearch(target, scores);
    }

    private int binarySearch(int target, List<Integer> scores) {
        int start = 0;
        int end = scores.size() - 1;

        while (end > start) {
            int mid = (start + end) / 2;

            if (scores.get(mid) >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // 범위 안에 마지막 남은 원소가 조건을 만족하는지 확인
        if (scores.get(start) < target) {
            return scores.size();
        }

        return start;
    }

    private Map<String, List<Integer>> getScoreMap(String[] info) {

        Map<String, List<Integer>> scoreMap = new HashMap<>();

        for (String s : info) {
            String[] tokens = s.split(" ");
            int score = Integer.parseInt(tokens[tokens.length - 1]);

            getCases(0, "", tokens, key -> {
                // key에 해당하는 값이 존재하지 않으면 새 리스트 넣기
                scoreMap.putIfAbsent(key, new ArrayList<>());

                // 리스트에 점수 넣어주기
                scoreMap.get(key).add(score);
            });
        }

        // 오름차순 정렬
        for (List<Integer> list : scoreMap.values()) {
            Collections.sort(list);
        }

        return scoreMap;
    }

    private void getCases(int index, String prefix, String[] tokens, Consumer<String> action) {

        if (index == tokens.length - 1) {
            // prefix가 만들어진 검색 조건
            action.accept(prefix);
            return;
        }

        // 모든 경우의 수 탐색
        getCases(index + 1, prefix + tokens[index], tokens, action);
        getCases(index + 1, prefix + "-", tokens, action);

    }

}