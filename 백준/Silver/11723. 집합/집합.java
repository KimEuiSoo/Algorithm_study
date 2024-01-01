import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int S = 0;

        while(M --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("all")) S = (1 << 21) - 1;
            else if(s.equals("empty")) S = 0;
            else{
                int num = Integer.parseInt(st.nextToken());
                if(s.equals("add")) S |= (1 << num);
                else if(s.equals("remove")) S &= ~(1 << num);
                else if(s.equals("check")) sb.append((S & (1 << num)) != 0 ? 1:0).append('\n');
                else S ^= (1 << num);
            }
        }

        System.out.println(sb.toString());
    }
}

