import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int size = numbers.length;
        Arrays.sort(numbers);
        int[] num = new int[10];
        for(int i=0; i<size; i++){
            num[numbers[i]]++;
        }
        for(int i=0; i<10; i++){
            if(num[i]==0) answer+=i; 
        }
        return answer;
    }
}