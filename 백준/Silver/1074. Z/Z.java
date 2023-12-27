import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int x=0, y=0, count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N=0,r=0,c=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        double pow = Math.pow(2,N);
        int M = (int) pow;
        int res = Recursion(M, r, c);
        System.out.println(res);
    }

    public static int Recursion(int N, int r, int c){
        N/=2;
        if(r < x+N && c < y+N){
            count += (N*N*0);
        }
        else if(r < x+N && c >= y+N){
            count += (N*N*1);
            y+=N;
        }
        else if(c < y+N) {
            count += (N * N * 2);
            x += N;
        }
        else{
            count+=(N*N*3);
            y+=N;
            x+=N;
        }

        if(N==1) return count;
        return Recursion(N, r, c);
    }
}