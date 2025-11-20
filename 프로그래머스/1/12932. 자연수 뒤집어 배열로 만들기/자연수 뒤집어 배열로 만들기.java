import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        int size = str.length();
        int[] answer = new int[size];
        int j=0;
        for(int i=size-1; i>=0; i--){
            answer[j] = str.charAt(i)-'0';
            j++;
        }
        return answer;
    }
}