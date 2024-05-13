import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int attacksTime = attacks[attacks.length-1][0];
        int maxHealth = health;
        int attackCnt = 0;
        int cnt = 0;
        for(int i=1; i<=attacksTime; i++){
            if(i==attacks[attackCnt][0]){
                cnt=0;
                health-=attacks[attackCnt][1];
                attackCnt++;
                if(health<=0){
                    return -1;
                }
                continue;
            }
            cnt++;
            health += bandage[1];
            if(cnt>=bandage[0]){
                health += bandage[2];
                cnt=0;
            }
            if(maxHealth<health){
                health=maxHealth;
            }
        }
        answer = health;
        return answer;
    }
}