import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str = Integer.toString(n,k);
        String[] data = str.split("0");
        for(int i=0; i<data.length; i++){
            if(!data[i].equals("")){
                boolean isPrime = isPrimeFun(Long.parseLong(data[i]));
                if(isPrime)
                    answer++;
            }
        }
        return answer;
    }
    
    boolean isPrimeFun(long num){
        boolean isPrime = true;
        if(num==1) return false;
        long sqrt = (long)Math.sqrt(num)+1;
        for(int i = 2; i < sqrt; i++) {
            if(num%i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }
}