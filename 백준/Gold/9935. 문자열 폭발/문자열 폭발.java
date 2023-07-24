import java.util.*;
import java.io.*;


public class Main{
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String boom = br.readLine();
        Queue<Character> data = new LinkedList<>();
        Queue<Character> result = new LinkedList<>();

        int count=0;
        for(int i=0; i<str1.length(); i++){
            boolean isSame = true;
            sb.append(str1.charAt(i));
            if(sb.length()>=boom.length()) {
                for (int j = 0; j < boom.length(); j++) {
                    if (boom.charAt(j) != sb.charAt(sb.length() - boom.length() + j)) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    sb.delete(sb.length() - boom.length(), sb.length());
                }
            }
        }
        System.out.println(sb.length()==0 ? "FRULA" : sb.toString());
    }
}