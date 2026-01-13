class Solution {
    String[] pos = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String word : babbling){
            boolean isPos = possibleWord(word);
            if(isPos){
                answer++;
            }
        }
        return answer;
    }
    
    public boolean possibleWord(String str){
        String prev = ""; // 직전에 사용한 단어   
        
        while (!str.isEmpty()) {
            boolean matched = false;

            for (String p : pos) {
                // 같은 단어 연속 방지
                if (str.startsWith(p) && !p.equals(prev)) {
                    prev = p;
                    str = str.substring(p.length());
                    matched = true;
                    break;
                }
            }

            if (!matched) return false;
        }

        return true;
    }
}