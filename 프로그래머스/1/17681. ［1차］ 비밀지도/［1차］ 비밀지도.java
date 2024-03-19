import java.util.*;
import java.lang.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] li1 = new String[n];
        String[] li2 = new String[n];
        for(int i=0; i<n; i++){
            String str1 = Integer.toString(arr1[i],2);
            String str2 = Integer.toString(arr2[i],2);
            if(str1.length()<=n-1){
                int size = str1.length();
                for(int j=0; j<n-size; j++){
                    str1 = "0" + str1;
                }
            }
            if(str2.length()<=n-1){
                int size = str2.length();
                for(int j=0; j<n-size; j++){
                    str2 = "0" + str2;
                }
            }
            li1[i] = str1;
            li2[i] = str2;
        }

        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String str = data(li1[i], li2[i]);
            str = str.replace("0", " ");
            answer[i]=str;
        }
        return answer;
    }
    
    String data(String str1, String str2){
        String res = "";
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i)=='1' || str2.charAt(i)=='1'){
                res+="#";
            }
            else res+=" ";
        }
        return res;
    }
}