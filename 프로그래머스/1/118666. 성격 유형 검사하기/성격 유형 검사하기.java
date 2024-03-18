import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] type = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        int[] num = {3,2,1,0,1,2,3};
        HashMap<Character, Integer> mbti = new HashMap<>();
        
        for(int i=0; i<8; i++){
            mbti.put(type[i], 0);
        }
        
        for(int i=0; i<choices.length; i++){
            char c0 = survey[i].charAt(0);
            char c1 = survey[i].charAt(1);
            if(choices[i]>4){
                int cur = mbti.get(c1);
                mbti.put(c1, cur+num[choices[i]-1]);
            }
            else if(choices[i]<4){
                int cur = mbti.get(c0);
                mbti.put(c0, cur+num[choices[i]-1]);
            }
        }
        
        for(int i=0; i<type.length; i+=2){
            if(mbti.get(type[i]) > mbti.get(type[i+1])){
                answer+=type[i];
            }
            else if(mbti.get(type[i]) < mbti.get(type[i+1])){
                answer+=type[i+1];
            }
            else answer+=type[i];
        }
        
        return answer;
    }
}