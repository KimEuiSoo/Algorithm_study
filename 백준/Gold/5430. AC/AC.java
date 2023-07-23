import java.util.*;
import java.io.*;

public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        ArrayDeque<Integer> ad = new ArrayDeque<>();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), "[],");

            ad = new ArrayDeque<Integer>();
            for(int j=0; j<n; j++) {
                ad.add(Integer.parseInt(st.nextToken()));
            }

            print_AC(ad, p);
        }

        System.out.println(sb.toString());
    }

    public static void print_AC(ArrayDeque<Integer> ad, String p){
        int r_check=0;
        for(char ch : p.toCharArray()){
            if(ch=='R'){
                r_check++;
                continue;
            }
            else if(ch=='D'){
                if(r_check%2==0){//그대로일때
                    if(ad.pollFirst()==null){
                        sb.append("error\n");
                        return;
                    }
                }
                else{//리버스일때
                    if(ad.pollLast()==null) {
                        sb.append("error\n");
                        return;
                    }
                }
            }
        }

        sb.append("[");
        if(!ad.isEmpty()){
            if(r_check%2==0){
                sb.append(ad.pollFirst());
                while(!ad.isEmpty()) {
                    sb.append(",");
                    sb.append(ad.pollFirst());
                }
            }
            else{
                sb.append(ad.pollLast());
                while(!ad.isEmpty()) {
                    sb.append(",");
                    sb.append(ad.pollLast());
                }
            }
        }
        sb.append("]\n");
    }
}