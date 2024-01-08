import java.util.*;
import java.io.*;

class Graph{
    int x=0;
    int y=0;
    int z=0;
    Graph(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main{
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int[][][] map;
    static boolean[][][] vi;

    static Queue<Graph> qu = new LinkedList<>();
    static int n=0,m=0,h=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        //가로
        m = Integer.parseInt(st.nextToken());
        //세로
        n = Integer.parseInt(st.nextToken());
        //높이
        h = Integer.parseInt(st.nextToken());

        map=new int[h][n][m];
        vi=new boolean[h][n][m];

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++){
                    map[i][j][k]=Integer.parseInt(st.nextToken());
                    if(map[i][j][k]==0) vi[i][j][k]=false;
                    else if(map[i][j][k]==1){
                        vi[i][j][k]=true;
                        qu.add(new Graph(k,j,i));
                    }
                    else vi[i][j][k]=true;
                }
            }
        }
        int res = bfs();
        System.out.println(res);
    }

    public static int bfs(){
        int x,y,z;
        while(!qu.isEmpty()){
            Graph xyz = qu.poll();
            x = xyz.x;
            y = xyz.y;
            z = xyz.z;

            for(int i=0; i<6; i++){
                if(x+dx[i]<m && x+dx[i]>=0 && y+dy[i]<n && y+dy[i]>=0 && z+dz[i]<h && z+dz[i]>=0
                && !vi[z+dz[i]][y+dy[i]][x+dx[i]] && map[z+dz[i]][y+dy[i]][x+dx[i]]==0){
                    vi[z+dz[i]][y+dy[i]][x+dx[i]]=true;
                    map[z+dz[i]][y+dy[i]][x+dx[i]] = map[z][y][x]+1;
                    qu.add(new Graph(x+dx[i], y+dy[i],z+dz[i]));
                }
            }
        }
        int res = Integer.MIN_VALUE;

        for(int i=0; i<h; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(map[i][j][k]==0) return -1;
                    if(res<map[i][j][k]) res = map[i][j][k];
                }
            }
        }

        if(res==1) return 0;
        return res-1;
    }
}