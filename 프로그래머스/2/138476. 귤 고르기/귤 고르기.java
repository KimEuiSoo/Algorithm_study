import java.util.*;
import java.lang.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int idx = tangerine.length-1;
        Arrays.sort(tangerine);
        int[] arr = new int[tangerine[idx]+1];
        
        int size = arr.length;
        
        for(int i=0; i<=idx; i++){
            arr[tangerine[i]]++;
        }
        
        Arrays.sort(arr);
        
        for(int i=size-1; i>=0; i--){
            int data = arr[i];
            k -= data;
            answer++;
            if(k<=0){
                break;
            }
        }
        
        return answer;
    }
}