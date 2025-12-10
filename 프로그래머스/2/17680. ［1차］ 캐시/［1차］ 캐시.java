import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        
        LinkedList<String> cache = new LinkedList<>();
        
        int time=0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.remove(city)) {
                cache.add(city);
                time += 1;
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
                }
                cache.add(city);
                time += 5;
            }
        }
        
        return time;
    }
    
    
}