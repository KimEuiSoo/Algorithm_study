import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N];
        long[] cnt = new long[M];
        long res = 0;
        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<N; i++)
            sum[i] = sum[i-1]+Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            int compair = (int)(sum[i]%M);
            if(compair==0)
                res++;
            cnt[compair]++;
        }
        for(int i=0; i<M; i++){
            if(cnt[i]>1){
                res = res+(cnt[i]*(cnt[i]-1)/2);
            }
        }
        System.out.println(res);
    }
}