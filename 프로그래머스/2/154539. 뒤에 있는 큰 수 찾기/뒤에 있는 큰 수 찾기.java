import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        
        int[] answer = new int[len];
        
        Stack<Integer> st = new Stack<>();
        st.push(numbers[len-1]);
        answer[len-1] = -1;
        
        for(int i=len-2; i>=0; i--){
            int num=numbers[i];
            
            while(!st.isEmpty()){
                if(st.peek()>num){
                    answer[i]=st.peek();
                    break;
                }else{
                    st.pop();
                }
            }
            if(st.isEmpty()){
                answer[i]=-1;
            }
            st.push(num);
        }
        
        return answer;
    }
}