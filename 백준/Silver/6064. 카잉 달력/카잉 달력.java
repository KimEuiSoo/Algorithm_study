import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N=0, M=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int resx = Integer.parseInt(st.nextToken())-1;
            int resy = Integer.parseInt(st.nextToken())-1;

            int check = 0;
            for(int j=resx; j<(N*M); j+=N){
                if(j%M==resy){
                    sb.append(j+1).append("\n");
                    check++;
                    break;
                }
            }

            if(check==0)
                sb.append(-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}

