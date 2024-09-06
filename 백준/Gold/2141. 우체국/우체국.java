import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<City> cities = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            long x = Long.parseLong(st.nextToken());
            long cnt = Long.parseLong(st.nextToken());
            cities.add(new City(x, cnt));
            sum += cnt;
        }
        Collections.sort(cities);
        long result = 0;
        for (int i = 0; i < n; i++) {
            result += cities.get(i).cnt;
            if ((sum + 1) / 2 <= result) {
                System.out.println(cities.get(i).x);
                break;
            }
        }
    }
}

class City implements Comparable<City> {
    long x;
    long cnt;

    public City(long x, long cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(City o) {
        return (int) (this.x - o.x);
    }
}