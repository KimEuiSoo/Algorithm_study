import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(br.readLine());

        char[] c = new char[sb.length()];
        int cnt=0, res=0;

        sb.getChars(0, sb.length(), c, 0);

        for(int i=1; i<c.length-1; i++){
            if(c[i-1]=='I' && c[i]=='O' && c[i+1]=='I'){
                cnt++;
                if(cnt==n){
                    res++;
                    cnt--;
                }
                i++;
            }
            else cnt=0;
        }
        System.out.println(res);
    }
}