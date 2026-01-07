import java.util.*;
import java.lang.*;

class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    boolean[][] vi;
    int n,m;
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;

        vi = new boolean[n][m];

        bfs(0,0, maps);

        answer = (maps[n-1][m-1]==1 ? -1 : maps[n-1][m-1]);
        
        return answer;
    }
    
    public void bfs(int x, int y, int[][] maps){
        vi[y][x] = true;
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{x,y});

        while(!qu.isEmpty()){
            int[] cur = qu.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++){
                int nx = dx[i]+cx;
                int ny = dy[i]+cy;
                if(nx<0 || ny<0 || nx>=m || ny>=n) continue;
                if(!vi[ny][nx] && maps[ny][nx]>=1){
                    qu.add(new int[]{nx,ny});
                    vi[ny][nx] = true;
                    maps[ny][nx] = 1+maps[cy][cx];
                }
            }
        };
    }
}