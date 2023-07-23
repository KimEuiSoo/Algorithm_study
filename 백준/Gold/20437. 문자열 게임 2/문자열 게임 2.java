import java.util.*;
import java.io.*;


public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int p=0; p<T; p++){
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            if(K==1) {
                sb.append("1 1\n");
                continue;
            }
            int ap[] = new int[26];
            for(int i=0; i<W.length(); i++){
                char ch = W.charAt(i);
                ap[ch-97]++;
            }

            int check=0;
            for(int i=0; i<26; i++) {
                if (ap[i] >= K) {
                    check++;
                    break;
                }
            }
            if(check==0) {
                sb.append("-1\n");
                continue;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for(int i=0; i<W.length()-1; i++){
                int start=i, last=0;
                char ch = W.charAt(i);
                int count=1;
                if(ap[ch-97]<K)
                    continue;
                for(int j=i+1; j<W.length(); j++){
                    last=j;
                    char sub_ch = W.charAt(j);
                    if(sub_ch==ch) count++;
                    if(count==K){
                        break;
                    }
                }
                if(count==K) {
                    min = Math.min(min, last - start+1);
                    max = Math.max(max, last - start+1);
                }
            }

            sb.append(min+" "+max+"\n");
        }
        System.out.println(sb.toString());
    }
}