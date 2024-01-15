import java.util.*;
import java.io.*;

class RGB{
    int c;
    int r;
    public RGB(int c,int r){
        this.c = c;
        this.r = r;
    }
}

public class Main{
    static char[][] arr;
    static boolean[][] vi;
    static int bCnt=0,rCnt=0,n=0;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new char[n][n];
        vi = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++)
                arr[i][j] = s.charAt(j);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!vi[i][j]){
                    vi[i][j]=true;
                    bfs(i, j,0);
                }
            }
        }

        vi = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!vi[i][j]){
                    vi[i][j]=true;
                    bfs(i, j, 1);
                }
            }
        }

        System.out.println(bCnt + " " + rCnt);
    }

    public static void bfs(int c, int r, int type){
        Queue<RGB> qu = new LinkedList<>();
        qu.add(new RGB(c,r));
        if(type==0) {
            while (!qu.isEmpty()) {
                RGB rgb = qu.poll();

                for (int i = 0; i < 4; i++) {
                    int x = rgb.r + dx[i];
                    int y = rgb.c + dy[i];
                    if (x < n && x >= 0 && y < n && y >= 0 && !vi[y][x]) {
                        if (arr[c][r] == 'R') {
                            if (arr[y][x] == 'R') {
                                qu.add(new RGB(y, x));
                                vi[y][x] = true;
                            }
                        } else if (arr[c][r] == 'B') {
                            if (arr[y][x] == 'B') {
                                qu.add(new RGB(y, x));
                                vi[y][x] = true;
                            }
                        } else if (arr[c][r] == 'G') {
                            if (arr[y][x] == 'G') {
                                qu.add(new RGB(y, x));
                                vi[y][x] = true;
                            }
                        }
                    }
                }
            }
            bCnt++;
        }
        else{
            while (!qu.isEmpty()) {
                RGB rgb = qu.poll();

                for (int i = 0; i < 4; i++) {
                    int x = rgb.r + dx[i];
                    int y = rgb.c + dy[i];
                    if (x < n && x >= 0 && y < n && y >= 0 && !vi[y][x]) {
                        if (arr[c][r] == 'R' || arr[c][r]=='G') {
                            if (arr[y][x] == 'R' || arr[y][x]=='G') {
                                qu.add(new RGB(y, x));
                                vi[y][x] = true;
                            }
                        } else if (arr[c][r] == 'B') {
                            if (arr[y][x] == 'B') {
                                qu.add(new RGB(y, x));
                                vi[y][x] = true;
                            }
                        }
                    }
                }
            }
            rCnt++;
        }
    }
}