import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int cur = Integer.parseInt(today.replace(".",""));
        
        int[] dates = new int[privacies.length];

        for(String term: terms){
            int cnt = 0;
            StringTokenizer st = new StringTokenizer(term);
            String term_type = st.nextToken();
            int term_month = Integer.parseInt(st.nextToken());
            for(String privacie: privacies){
                st = new StringTokenizer(privacie);
                int date = Integer.parseInt(st.nextToken().replace(".",""));
                String type = st.nextToken();
                if(type.equals(term_type)) {
                    int day = date % 100;
                    int month = date % 10000 - day;
                    int year = date - month - day;
                    int mm = term_month/12;
                    int mm_mm = term_month%12;
                    month += mm_mm*100;
                    if(month>=1300 || mm>0){
                        year+= mm*10000;
                        if(month>=1300) {
                            year+=10000;
                            month -= 1200;
                        }
                    }
                    dates[cnt] = year+month+day-1;
                }
                cnt++;
            }
        }
        
        int res = 0;
        for(int i=0; i<privacies.length; i++){
            if(cur>dates[i]){
                res++;
            }
        }
        int[] answer=new int[res];
        
        res=0;
        for(int i=0; i<privacies.length; i++){
            if(cur>dates[i]){
                answer[res]=i+1;
                res++;
            }
        }
        
        return answer;
    }
}