import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<size; i++){
            if(set.size()>=size/2) break;
            set.add(nums[i]);
        }
        
        return set.size();
    }
}