class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()==4 || s.length()==6){
            for(char c : s.toCharArray()){
                if(c >= 65 && c <= 122) answer = false;
            }
        }else return false;
        return answer;
    }
}