import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String s) {
        int min = Integer.MAX_VALUE;

        // 문자열의 길이가 n이라면 n/2 길이로 압축하는 것이 최대
        // 1~n/2 반복하면서 압축하고 제일 최소의 길이를 구하기
        for (int n = 1; n <= s.length(); n++) {

            // 문자열을 압축 단위로 쪼개서 토큰 배열 생성
            List<String> tokens = split(s, n);

            // 토큰을 돌면서 문자열 압축
            String compressed = compress(tokens);

            min = Math.min(min, compressed.length());
        }

        return min;
    }

    private List<String> split(String s, int n) {
        List<String> tokens = new ArrayList<>();

        for (int i = 0; i < s.length(); i += n) {
            // 남은 원소의 개수가 n보다 작은 경우
            if (i + n >= s.length()) {
                tokens.add(s.substring(i));
            } else {
                // n 길이만큼 잘라서 토큰으로 추가
                tokens.add(s.substring(i, i + n));
            }
        }

        return tokens;
    }

    private String compress(List<String> tokens) {
        StringBuilder sb = new StringBuilder();

        String last = "";
        int cnt = 0;

        for (String token : tokens) {
            // 카운팅
            if (token.equals(last)) {
                cnt++;
            } else {
                // 이전 토큰 정보 압축
                if (cnt > 1) sb.append(cnt);
                sb.append(last);

                // 새로운 토큰 기준으로 다시 카운팅 시작
                last = token;
                cnt = 1;
            }
        }

        // 남은 마지막 토큰 처리
        if (cnt > 1) sb.append(cnt);
        sb.append(last);

        return sb.toString();
    }
}