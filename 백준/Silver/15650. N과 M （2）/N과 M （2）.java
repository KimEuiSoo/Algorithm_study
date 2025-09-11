import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    static int N,M = 0;
    static int[] seq;
    static boolean[] vi;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        vi = new boolean[N];

        dfs(0,0);

        System.out.println(sb.toString());
    }

    public static void dfs(int depth, int s){
        // depth가 마지막 출력 위치에 도달하면 sb에 seq 배열의 값들을 append한다.
        if(depth == M){
            for(int val : seq){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=s; i<N; i++){     // 중복되지 않는 숫자에서 오름차순으로 정렬하게끔 정해준 시작 숫자서 부터 N개의 수를 선택
            if(!vi[i]){
                vi[i] = true;
                seq[depth] = i+1;
                dfs(depth+1, i+1);      // 시작 값을 i+1 위치에서 재귀

                vi[i] = false;
            }
        }
    }
}