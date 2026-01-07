import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int size = score.length;
        Arrays.sort(score);
        
        for(int i=size-1; i>=0;){
            if(i<(m-1)) break;
            int min = score[i-(m-1)];
            answer+=min*m;
            i-=m;
        }
        
        return answer;
    }
}