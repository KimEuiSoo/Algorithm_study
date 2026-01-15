import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        
        int[][] dp = new int[len][len];
        
        for(int i=0; i<len; i++){
            for(int j=0; j<=i; j++){
                dp[i][j] = triangle[i][j];
            }
        }
        
        dp[1][0] = dp[0][0]+dp[1][0];
        dp[1][1] = dp[0][0]+dp[1][1];
        
        for(int i=2; i<len; i++){
            dp[i][0] += dp[i-1][0];
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1]+dp[i][j], dp[i-1][j]+dp[i][j]);
            }
        }
        
        
        
        return Arrays.stream(dp[len-1]).max().getAsInt();
    }
}