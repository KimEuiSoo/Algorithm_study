import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] s = str.split("");
        Arrays.sort(s, Collections.reverseOrder());
        str = String.join("", s);
        answer = Long.parseLong(str);
        
        return answer;
    }
}