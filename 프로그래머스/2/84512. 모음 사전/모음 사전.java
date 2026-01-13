class Solution {
    String[] alpha = {"A", "E", "I", "O", "U"};
    int count = 0;
    int answer = 0;
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    private void dfs(String current, String target) {
        
        if (current.length() > 5) return;

        if (!current.isEmpty()) {
            count++;

            if (current.equals(target)) {
                answer = count;
                return;
            }
        }

        for (String v : alpha) {
            dfs(current + v, target);
        }
    }
}