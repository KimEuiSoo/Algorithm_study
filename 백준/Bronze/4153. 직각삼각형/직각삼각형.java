import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if(w==0 && h==0 && s==0) break;

            double dw = Math.pow(w, 2);
            double dh = Math.pow(h, 2);
            double ds = Math.pow(s, 2);
            
            System.out.println(dw+dh==ds || dw+ds==dh || dh+ds==dw ? "right" : "wrong");
        }
    }
}