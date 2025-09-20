import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        String temp = new String();
        int cnt = 0;
        while(true){
            if(s.equals("1")) break;
            cnt += countChar(s);
            temp = s.replace("0","");
            int size = temp.length();
            String binary = Integer.toBinaryString(size);
            s = binary;
            answer[0]++;
        }
        answer[1] = cnt;
        return answer;
    }
    
    public int countChar(String str){
        return str.length() - str.replace("0", "").length();
    }
}