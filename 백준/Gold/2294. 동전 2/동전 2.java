import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] li = new int[n+1];
        for (int i = 1; i <= n; i++) {
            li[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];

        for (int i = 1; i <= k; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = li[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j-li[i]]+1);
            }
        }

        if(dp[k]==Integer.MAX_VALUE-1) System.out.println(-1);
        else System.out.println(dp[k]);
    }
}