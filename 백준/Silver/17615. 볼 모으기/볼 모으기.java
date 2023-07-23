import java.util.*;
import java.io.*;


public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int red=0, blue=0;
        String ball = br.readLine();
        for(int i=0; i<N; i++){
            if(ball.charAt(i)=='R')
                red++;
            else blue++;
        }

        int count=0;
        int min=Integer.MAX_VALUE;
        for(int i=N-1; i>=0; i--){
            if(ball.charAt(i)=='R')
                count++;
            else break;
        }
        min = Math.min(red-count, min);

        count=0;
        for(int i=N-1; i>=0; i--){
            if(ball.charAt(i)=='B')
                count++;
            else break;
        }
        min = Math.min(blue-count, min);

        System.out.println(min);
    }
}