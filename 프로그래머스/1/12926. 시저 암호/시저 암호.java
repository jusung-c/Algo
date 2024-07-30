class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();

        // 1. char 배열로 분해
        char[] arr = s.toCharArray();

        // 2. 원소마다 거리 n 더해주기
        for (char c : arr) {
            // 시저 암호로 암호화
            sb.append(encrypt(c, n));
        }

        return sb.toString();
    }

    private char encrypt(char c, int n) {
        // 공백일 경우 그대로 공백
        if (!Character.isAlphabetic(c)) return c;

        // 0을 기준으로 맞추기 (대소문자 구별)
        int offset = Character.isUpperCase(c) ? 'A' : 'a';
        int index = c - offset;

        // n만큼 더해준 후 나머지 연산으로 인덱스 구하기
        index = (index + n) % 26;

        // offset에 index를 더해 실제 문자 반환
        return (char) (offset + index);
    }
}