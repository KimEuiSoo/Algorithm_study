import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;

    static int N, M;
    static Integer[][] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new Integer[N][N];
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];

        DP();

        int res=dp[N-1][0];
        for(int i=1; i<N; i++){
            res = Math.max(res, dp[N-1][i]);
        }
        System.out.println(res);
    }

    public static void DP(){
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j]+map[i][j];
                }else if(j==i){
                    dp[i][j] = dp[i-1][j-1]+map[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+map[i][j];
                }
            }
        }
    }
}