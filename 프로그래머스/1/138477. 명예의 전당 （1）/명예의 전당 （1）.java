import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        
        List<Integer> award = new ArrayList<>();
        
        for(int i=0; i<score.length; i++){
            award.add(score[i]);
            Collections.sort(award);
            if(award.size()>k){
                award.remove(0);
            }
            answer[i] = award.get(0);
        }
        return answer;
    }
}