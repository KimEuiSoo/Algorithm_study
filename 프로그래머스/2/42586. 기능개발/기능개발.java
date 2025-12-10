import java.util.*;
class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> qu = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        int cnt = 1;
        qu.add(completeProcess(progresses[0], speeds[0]));
        for(int i=1; i<progresses.length; i++){
            int day = completeProcess(progresses[i], speeds[i]);
            if(!qu.isEmpty() && qu.peek()<day){
                answer.add(cnt);
                qu.remove();
                qu.add(day);
                cnt=1;
            }else if(!qu.isEmpty() && qu.peek()>=day){
                cnt++;
            }
        }
        if(!qu.isEmpty()){
            answer.add(cnt);
        }
        return answer;
    }
    
    public int completeProcess(int progress, int speed){
        int remain = 100-progress;
        int day = remain/speed + ((remain%speed==0) ? 0 : 1);
        return day;
    }
}