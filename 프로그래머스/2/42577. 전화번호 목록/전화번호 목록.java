import java.util.*;
import java.lang.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int size = phone_book.length;
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<size-1; i++){
            String phone = phone_book[i];
            String phone2 = phone_book[i+1];
            if(phone2.startsWith(phone)) return false;
        }
        
        return answer;
    }
}