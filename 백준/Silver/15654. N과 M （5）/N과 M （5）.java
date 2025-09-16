import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb;
    static int N,M;
    static int[] seq;
    static List<Integer> data;
    static boolean[] vi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        seq = new int[M];
        data = new ArrayList<>();
        vi = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            data.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(data);

        back(0);

        System.out.println(sb.toString());
    }

    public static void back(int dep){
        if(dep == M){
            for(int val : seq){
                sb.append(val+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++){
            if(!vi[i]){
                vi[i] = true;
                seq[dep] = data.get(i);
                back(dep+1);
                vi[i] = false;
            }
        }
    }
}