class Solution {
    public String solution(String new_id) {

        // step 1
        new_id = new_id.toLowerCase();

        // step 2
        new_id = new_id.replaceAll("[^a-z0-9\\-_.]", "");

        // step 3
        new_id = new_id.replaceAll("[.]+", ".");

        // step 4
        new_id = new_id.replaceAll("^[.]|[.]$", "");

        // step 5
        new_id = new_id.isEmpty() ? "a" : new_id;

        // step 6
        new_id = new_id.length() >= 16 ? new_id.substring(0, 15).replaceAll("[.]$", "") : new_id;

        // step 7
        while (new_id.length() <= 2) {
            new_id += new_id.charAt(new_id.length() - 1);
        }

        return new_id;
    }
}