import java.util.*;
import java.io.*;


public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String S = br.readLine();
        String T = br.readLine();

        while(S.length()<T.length()){
            sb = new StringBuilder();
            if (T.charAt(T.length()-1)=='A') {
                T = T.substring(0, T.length() - 1);
            } else if (T.charAt(T.length()-1)=='B') {
                T = T.substring(0, T.length() - 1);
                T = sb.append(T).reverse().toString();
            }
        }

        System.out.println(S.equals(T) ? "1" : "0");
    }
}