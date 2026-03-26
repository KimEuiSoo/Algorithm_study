import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int tSet = 0;
        int pSet = n/p;
        int pRem = n%p;
        for(int size : list){
            tSet += size/t;
            if(size%t>0) tSet++;
        }

        sb.append(tSet+"\n");
        sb.append(pSet+" "+pRem);
        System.out.println(sb.toString());
    }
}