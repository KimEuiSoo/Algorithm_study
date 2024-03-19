import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int hit = 1;
        int miss = 5;
        
        if(cacheSize==0) return cities.length * 5;
        
        Queue<String> qu = new LinkedList<>();
        
        for(String city : cities){
            city = city.toUpperCase();
            if(qu.size() < cacheSize){
                if(qu.contains(city)){
                    qu.remove(city);
                    qu.add(city);
                    answer++;
                }
                else {
                    qu.add(city);
                    answer+=5;
                }
            }
            else{
                if(qu.contains(city)){
                    qu.remove(city);
                    qu.add(city);
                    answer++;
                }
                else {
                    qu.poll();
                    qu.add(city);
                    answer+=5;
                }
            }
        }
        
        return answer;
    }
}