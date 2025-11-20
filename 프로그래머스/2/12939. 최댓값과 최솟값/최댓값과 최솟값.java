import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int min = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).min().getAsInt();
        int max = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).max().getAsInt();
        answer=String.valueOf(min)+" "+String.valueOf(max);
        
        return answer;
    }
}