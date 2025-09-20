import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<String> st = new Stack<>();
        
        for(int i=1; i<=s.length(); i++){
            char text = s.charAt(i-1);
            if(i==1){
                st.push(String.valueOf(text));
            }
            else if(text == (')')){
                if(st.isEmpty()){
                    return false;
                }
                st.pop();
            }else{
                st.push(String.valueOf(text));
            }
        }
        
        if(!st.isEmpty()){
            answer = false;
        }
        

        return answer;
    }
}