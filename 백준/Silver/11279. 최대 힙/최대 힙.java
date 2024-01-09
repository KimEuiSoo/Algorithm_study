import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pqu = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                int poll=0;
                if(pqu.size() != 0) poll=pqu.poll();
                sb.append(poll).append('\n');
            }
            else pqu.add(num);
        }

        System.out.println(sb.toString());
    }
}