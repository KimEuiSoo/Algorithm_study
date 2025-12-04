import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++){
            String cloth = clothes[i][1];
            map.merge(cloth, 1, Integer::sum);
        }
        
        for(int cnt : map.values()){
            answer *= cnt+1;
        }
        
        return answer - 1;
    }
}