import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n = 0, k = 0, res=0;
    static int[] visited = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs(n);
        System.out.println(res);
    }

    public static void bfs(int node){
        Queue<Integer> qu = new LinkedList<Integer>();

        qu.add(node);
        int nodeN = 0;
        visited[node] = 1;
        while(qu.isEmpty()==false){
            nodeN = qu.remove();
            if(nodeN==k){
                res=visited[nodeN]-1;
            }
            if(nodeN-1>=0 && visited[nodeN-1]==0){
                visited[nodeN-1] = visited[nodeN]+1;
                qu.add(nodeN-1);
            }
            if(nodeN+1<=100000 && visited[nodeN+1]==0){
                visited[nodeN+1] = visited[nodeN]+1;
                qu.add(nodeN+1);
            }
            if(nodeN*2<=100000 && visited[nodeN*2]==0){
                visited[nodeN*2] = visited[nodeN]+1;
                qu.add(nodeN*2);
            }
        }
    }
}