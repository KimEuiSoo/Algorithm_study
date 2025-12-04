import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int h=0; h<n; h++){
            if(citations[h]>=n-h){
                answer=n-h;
                break;
            }
        }
        
        return answer;
    }
}