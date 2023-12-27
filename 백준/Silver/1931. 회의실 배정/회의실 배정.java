import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] x = new int[n][2];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            x[i][0] = Integer.parseInt(st.nextToken());
            x[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(x, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0]-o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt=0, pre=0;

        for(int i=0; i<n; i++){
            if(pre<=x[i][0]){
                pre=x[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}