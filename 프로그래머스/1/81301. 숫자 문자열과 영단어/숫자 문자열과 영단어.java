class Solution {
    String[] numbers = new String[]{
            "zero", "one", "two", "three", "four"
            , "five", "six", "seven", "eight", "nine"
    };

    public int solution(String s) {
        for (int i = 0; i <= 9; i++) {
            s = s.replaceAll(numbers[i].toString(), String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}