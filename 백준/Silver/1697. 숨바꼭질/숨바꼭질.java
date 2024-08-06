import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class Main {
    static int N = 0, K = 0, res=0;
    static int[] visited= new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N);
        System.out.println(res);
    }

    public static void bfs(int x){
        Queue<Integer> qu = new LinkedList<Integer>();

        qu.add(x);
        int dx = 0;
        visited[x] = 1;
        while(qu.isEmpty()==false){
            dx = qu.remove();
            if(dx==K){
                res=visited[dx]-1;
            }
            if(dx-1>=0 && visited[dx-1]==0){
                visited[dx-1] = visited[dx]+1;
                qu.add(dx-1);
            }
            if(dx+1<=100000 && visited[dx+1]==0){
                visited[dx+1] = visited[dx]+1;
                qu.add(dx+1);
            }
            if(dx*2<=100000 && visited[dx*2]==0){
                visited[dx*2] = visited[dx]+1;
                qu.add(dx*2);
            }
        }
    }
}