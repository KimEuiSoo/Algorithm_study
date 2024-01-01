import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int w=0, b=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        recursion(0,0,n);
        System.out.println(w+"\n"+b);
    }

    public static void recursion(int r, int c, int n){
        if(colorCheck(r, c, n)) {
            if(arr[r][c] == 0) {
                w++;
            }
            else {
                b++;
            }
            return;
        }

        int newN = n / 2;

        recursion(r, c, newN);						// 2사분면
        recursion(r, c + newN, newN);				// 1사분면
        recursion(r + newN, c, newN);				// 3사분면
        recursion(r + newN, c + newN, newN);	// 4사분면
    }

    public static boolean colorCheck(int r, int c, int node) {

        int color = arr[r][c];

        for(int i = r; i < r + node; i++) {
            for(int j = c; j < c + node; j++) {
                if(arr[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}