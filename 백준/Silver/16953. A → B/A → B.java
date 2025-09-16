import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int A,B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int res=0;
        while(true){
            res++;
            int last = B%10;
            if(A==B){
                sb.append(res).append("\n");
                break;
            }

            if((B<A) || (last!=1 && B%2!=0)){
                sb.append(-1).append("\n");
                break;
            }

            if(B%2==0){
                B/=2;
            }else{
                B/=10;
            }
        }

        System.out.println(sb);
    }
}