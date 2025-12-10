import java.util.*;

class Solution {
    boolean[] vi;
    int max = 0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        int size = dungeons.length;
        vi = new boolean[size];
        dfs(k, 0, dungeons);
        return max;
    }
    
    public void dfs(int currentFati, int cnt, int[][] dungeons){
        max = Math.max(max, cnt);
        
        for(int i=0; i<dungeons.length; i++){
            int require = dungeons[i][0];
            int cost = dungeons[i][1];
            
            if(require<=currentFati && !vi[i]){
                vi[i] = true;
                dfs(currentFati-cost, cnt+1, dungeons);
                vi[i] = false;
            }
        }
    }
}