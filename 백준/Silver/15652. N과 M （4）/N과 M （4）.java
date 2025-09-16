import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N,M;
    static int[] seq;
    static boolean[] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[M];
        vi = new boolean[N];

        back(0, 0);

        System.out.println(sb.toString());
    }

    public static void back(int dep, int s){
        if(dep == M){
            for(int val : seq){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=s; i<N; i++){
            seq[dep] = i+1;
            back(dep+1, i);      // 시작 값을 i+1 위치에서 재귀
        }
    }
}