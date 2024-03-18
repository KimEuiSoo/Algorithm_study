import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> qu1 = new LinkedList<>();
        Queue<Integer> qu2 = new LinkedList<>();
        long qu1_num=0, qu2_num=0;
        for(int i=0; i<queue1.length; i++){
            qu1.add(queue1[i]);
            qu2.add(queue2[i]);
            qu1_num+=queue1[i];
            qu2_num+=queue2[i];
        }
        long total=qu1_num+qu2_num;
        int cnt=0;
        if(total%2!=0) return -1;
        while(true){
            if(cnt>((qu1.size()+qu2.size())*2)) return -1;
            if(qu1_num==qu2_num) break;
            else if(qu1_num>qu2_num){
                int qu = qu1.poll();
                qu2.add(qu);
                qu1_num-=qu;
                qu2_num+=qu;
            }
            else if(qu1_num<qu2_num){
                int qu = qu2.poll();
                qu1.add(qu);
                qu2_num-=qu;
                qu1_num+=qu;
            }
            cnt++;
        }
        
        int answer = cnt;
        return answer;
    }
}