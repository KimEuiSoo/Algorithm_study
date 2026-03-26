import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int r = 1;
        int lay = 1;

        while (n > r) {
            r += 6 * lay;
            lay++;
        }

        System.out.println(lay);
    }
}