import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        Queue<Integer> qu = new LinkedList<>();
        int n=0;
        int befor_num = 0;
        for(int i=0; i<dartResult.length(); i++){
            boolean isCheck = true;
            int num=0;
            char c = dartResult.charAt(i);
            if(c-'0'<=9 && c-'0'>=0){
                n=c-'0';
                qu.add(n);
                isCheck = false;
            }
            if(qu.size() == 2){
                qu.clear();
                n=10;
            }
            if(isCheck) {
                int num2=0;
                if (c == 'S') num = (int) Math.pow(n, 1);
                else if (c == 'D') num = (int) Math.pow(n, 2);
                else if (c == 'T') num = (int) Math.pow(n, 3);

                char second = '0';

                if(i!=dartResult.length()-1){
                    second = dartResult.charAt(i+1);
                }

                if (second == '#') {
                    num *= -1;
                    i++;
                }
                num2 = befor_num;
                befor_num = num;
                if (second == '*') {
                    num = num*2+num2;
                    i++;
                    befor_num *= 2;
                }
                answer += num;
                qu.clear();
            }
        }
        return answer;
    }
}