import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] arr, res;
    private static boolean[][] vi;
    private static int[] x = {1, 0, -1, 0};
    private static int[] y = {0, -1, 0, 1};
    private static int N=0, M=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        vi = new boolean[N][M];
        res = new int[N][M];
        int r=0,c=0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j]==2){
                    r=i; c=j;
                }
                else if(arr[i][j]==0){
                    vi[i][j]=true;
                }
            }
        }

        res[r][c] = 0;
        bfs(r,c);
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!vi[i][j])
                    res[i][j]=-1;
                sb.append(res[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int r, int c){
        Queue<int[]>qu=new LinkedList<>();
        qu.add(new int[] {r,c});
        vi[r][c]=true;

        while(!qu.isEmpty()) {
            int[] node = qu.poll();
            for(int i=0; i<4; i++) {
                int nr = node[0]+x[i];
                int nc = node[1]+y[i];
                if(nr>=0 && nr< N && nc>=0 && nc<M) {
                    if(!vi[nr][nc] && arr[nr][nc]==1) {
                        vi[nr][nc]=true;
                        res[nr][nc]=res[node[0]][node[1]]+1;
                        qu.add(new int[] {nr,nc});
                    }
                }
            }
        }
    }
}

