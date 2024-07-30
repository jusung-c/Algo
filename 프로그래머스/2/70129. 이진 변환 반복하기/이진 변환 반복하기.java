class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int changeCnt = 0;

        // s가 "1"이 될때까지 반복한다.
        while (!s.equals("1")) {
            // 1. x에서 0 제거
            String after = s.replaceAll("0", "");
            zeroCnt += s.length() - after.length();

            System.out.println("after = " + after);

            // 2. x의 길이를 이진변환
            s = Integer.toString(after.length(), 2);
            changeCnt++;

            System.out.println("s = " + s);
        }

        return new int[]{changeCnt, zeroCnt};
    }
}