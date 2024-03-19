import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import java.io.*;
import java.lang.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> li1 = new ArrayList<>();
        List<String> li2 = new ArrayList<>();
        for(int i=0; i<str1.length()-1; i++){
            String zip = str1.substring(i,i+2);
            zip = zip.toLowerCase();
            if((zip.charAt(0)>='a' && zip.charAt(0)<='z')   && (zip.charAt(1)>='a' && zip.charAt(1)<='z')){
                li1.add(zip);
            }
        }
        for(int i=0; i<str2.length()-1; i++){
            String zip = str2.substring(i,i+2);
            zip = zip.toLowerCase();
            if((zip.charAt(0)>='a' && zip.charAt(0)<='z')   && (zip.charAt(1)>='a' && zip.charAt(1)<='z')){
                li2.add(zip);
            }
        }
        
        List<String> li3 = new ArrayList<>();   //교
        List<String> li4 = new ArrayList<>();   //합
        
        for(int i=0; i<li1.size(); i++){
            if(li2.contains(li1.get(i))){
                li3.add(li1.get(i));
                li2.remove(li1.get(i));
            }
            li4.add(li1.get(i));
        }
        for(int i=0; i<li2.size(); i++){
            li4.add(li2.get(i));
        }
        
        int kyo = li3.size();

        int hap = li4.size();
        
        if(hap == 0){
            return 65536;
        }
        
        int answer = (int)((double)kyo / hap * 65536);
        
        return answer;
    }
}