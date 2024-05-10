import java.io.*;
import java.util.*;

class Main {

    static int m = 0;
    static int n = 0;
    static List<Integer> trueList = new ArrayList<>();
    static int[] parent;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        st = new StringTokenizer(br.readLine());
        int tP = Integer.parseInt(st.nextToken());

        if(tP == 0) {
            System.out.println(m);
            return;
        }
        else{
            for(int i = 0; i < tP; i++)
                trueList.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer>[] party = new ArrayList[m];

        for(int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
        }
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int pN = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            party[i].add(first);

            for(int j=1; j<pN; j++){
                int next = Integer.parseInt(st.nextToken());
                union(first, next);
                party[i].add(next);
            }
        }

        int cnt=0;
        for(int i=0; i<m; i++){
            boolean check = false;
            for(int num : party[i]){
                if(trueList.contains(find(parent[num]))){
                    check = true;
                }
            }
            if(check) cnt++;
        }

        System.out.println(m-cnt);
    }

    public static int find(int x){
        if(parent[x] == x)
            return x;
        else return find(parent[x]);
    }

    public static void union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(trueList.contains(py)){
            int tmp = px;
            px = py;
            py = tmp;
        }

        parent[py] = px;
    }
}