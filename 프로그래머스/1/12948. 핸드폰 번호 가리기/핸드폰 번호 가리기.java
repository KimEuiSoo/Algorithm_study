import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        String s = phone_number;
        answer = s.substring(0, s.length()-4)
            .replaceAll(".","*")+s.substring(s.length() - 4);
        
        return answer;
    }
}