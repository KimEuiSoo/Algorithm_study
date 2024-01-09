import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pqu = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1)>Math.abs(o2)) return Math.abs(o1) - Math.abs(o2);
                else if(Math.abs(o1)==Math.abs(o2)) return o1-o2;
                else return -1;
            }
        });
        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num==0){
                int poll=0;
                if(pqu.size() != 0) poll = pqu.poll();
                sb.append(poll).append('\n');
            }
            else pqu.add(num);
        }

        System.out.println(sb.toString());
    }
}