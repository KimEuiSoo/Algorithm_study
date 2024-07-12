import java.util.*;
import java.lang.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int size = friends.length;
        int gift[][] = new int[size][size];
        int jisoo[] = new int[size];
        int dic[] = new int[size];

        for(String gives : gifts){
            String[] giveNTake = gives.split(" ");
            String give = giveNTake[0];
            String take = giveNTake[1];

            int givePerson = 0;
            int takePerson = 0;

            for(givePerson=0; givePerson<size; givePerson++){
                if(give.equals(friends[givePerson])) break;
            }
            for(takePerson=0; takePerson<size; takePerson++){
                if(take.equals(friends[takePerson])) break;
            }

            gift[givePerson][takePerson]++;
        }

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                jisoo[i]+=gift[i][j]-gift[j][i];
            }
        }

        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                if(gift[i][j]-gift[j][i]>0) dic[i]++;
                else if(gift[i][j]==gift[j][i]) {
                    if(jisoo[i]>jisoo[j]) dic[i]++;
                    else if(jisoo[i]==jisoo[j]) continue;
                    else dic[j]++;
                }
                else dic[j]++;
            }
        }
        for(int i=0; i<size; i++){
            answer = Math.max(answer, dic[i]);
        }
        
        return answer;
    }
}