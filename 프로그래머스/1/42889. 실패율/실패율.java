import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int total = stages.length;
        List<Fail> fail = new ArrayList<>();
        for(int i=1; i<=N; i++){
            int cnt = countOccurrences(stages, i);
            if(total>0) {
                fail.add(new Fail(i, (double) cnt / total));
            }
            else{
                fail.add(new Fail(i, 0.0));
            }
            total = total-cnt;
        }

        Collections.sort(fail);

        for(int i=0; i<fail.size(); i++){
            answer[i] = fail.get(i).key;
        }
        return answer;
    }

    public static int countOccurrences(int[] nums, int target) {
        int count = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
        }
        return count;
    }
    
    private static class Fail implements Comparable<Fail>{
        int key;
        double fail;
        
        public Fail(int key, double fail){
            this.key = key;
            this.fail = fail;
        }        
        
        @Override
        public int compareTo(Fail o){
            double compare = this.fail - o.fail;
            if(compare>0) return -1;
            else if(compare==0.0) return 0;
            else return 1;
        }
    }
}