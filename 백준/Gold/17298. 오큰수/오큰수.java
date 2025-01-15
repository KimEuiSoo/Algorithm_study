import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
    static int n=0;
    static Stack<Integer> stack = new Stack<>();
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        functionA();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }

    public static void functionA(){
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }
    }
}