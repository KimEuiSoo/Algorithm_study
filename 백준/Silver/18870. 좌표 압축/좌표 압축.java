import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Data implements Comparable<Data>{
    int key;
    int value;
    public Data(int key, int value){
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Data o1){
        return this.value - o1.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int pre=0, compress=0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Data> li = new ArrayList<>();
        for(int i=0; i<n; i++)
            li.add(new Data(i, Integer.parseInt(st.nextToken())));

        Collections.sort(li);

        for(Data entry : li) {
            if(pre!=entry.value){
                compress++;
                pre = entry.value;
            }
            arr[entry.key]=compress;
        }

        for(int item: arr){
            sb.append(item-1).append(" ");
        }
        System.out.println(sb);

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for(int i=0; i<n; i++)
//            map.put(i, Integer.parseInt(st.nextToken()));
//
//        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
//        entries.sort(Map.Entry.comparingByValue());
//        for(Map.Entry<Integer, Integer> entry : entries) {
//            if(pre!=entry.getValue()){
//                compress++;
//                pre = entry.getValue();
//            }
//            arr[entry.getKey()]=compress;
//        }
//
//        for(int item: arr){
//            System.out.print((item-1)+" ");
//        }
    }
}

