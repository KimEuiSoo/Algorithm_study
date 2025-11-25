import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int left = 0, right = people.length-1;
        
        while(left<=right){
            if(people[right]+people[left]<=limit){
                left++;
            }
            right--;
            answer++;
        }
        
        return answer;
    }
}