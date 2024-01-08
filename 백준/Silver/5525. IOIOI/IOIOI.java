import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        sb.append(br.readLine());
        String IO = "IO";
        String resIO = "";

        char[] c = new char[sb.length()];

        sb.getChars(0, sb.length(), c, 0);

        for(int i=0; i<n; i++){
            resIO+=IO;
        }
        resIO+="I";
        int cnt=0;
        while(sb.length()>0) {
            int idx = -1;
            idx = sb.indexOf(resIO);

            if (idx == -1) {
                break;
            }
            else {
                sb.deleteCharAt(idx);
                sb.deleteCharAt(idx);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}