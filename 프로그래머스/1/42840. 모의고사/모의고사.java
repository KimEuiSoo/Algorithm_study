import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] giveUp1 = {1,2,3,4,5};
        int[] giveUp2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] giveUp3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int cnt1 = correctCnt(answers,giveUp1);
        int cnt2 = correctCnt(answers,giveUp2);
        int cnt3 = correctCnt(answers,giveUp3);
        int max = Math.max(Math.max(cnt1,cnt2),cnt3);
        
        List<Integer> answer = new ArrayList<>();
        if(max==cnt1) answer.add(1);
        if(max==cnt2) answer.add(2);
        if(max==cnt3) answer.add(3);
        
        return answer;
    }
    
    public int correctCnt(int[] answers, int[] giveUp){
        int size = giveUp.length;
        int cnt = 0;
        for(int i=0; i<answers.length; i++){
            int patternValue = giveUp[i % giveUp.length];
            
            if(answers[i]==patternValue) cnt++;
        }
        return cnt;
    }
}