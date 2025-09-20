import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};
        Set<String> set = new HashSet<>();
        int size = words.length;
        
        String end = words[0].substring(words[0].length()-1);
        
        for(int i=0; i<size; i++){
            String start = words[i].substring(0,1);
            if(i==0){
                set.add(words[i]);
                continue;
            }
            if(!start.equals(end) || !set.add(words[i])){
                answer = new int[] {i%n+1, i/n+1};
                return answer;
            }
            end = words[i].substring(words[i].length()-1);
        }
        
        return new int[] {0, 0};
    }
}