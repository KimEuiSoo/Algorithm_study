import java.util.*;
import java.lang.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {        
        HashMap<String, Record> map = new HashMap<>();

        for(int i=0; i<records.length; i++){
            String[] record = records[i].split(" ");
            String[] time = record[0].split(":");
            int hour = Integer.parseInt(time[0]);
            int minute = Integer.parseInt(time[1]);
            int total = hour*60+minute;
            if(record[2].equals("IN")){
                Record res = map.get(record[1]);
                if(res == null){
                    res = new Record(record[1], total, record[2]);
                }
                else{
                    res.update(total, record[2]);
                }
                map.put(record[1], res);
            }
            else{
                Record res = map.get(record[1]);
                res.change(total);
                map.put(record[1], res);
            }

            if(i==records.length-1){
                for(Map.Entry<String, Record> entrySet : map.entrySet() ){
                    Record res = entrySet.getValue();
                    String status = res.status;
                    if(status.equals("IN")){
                        hour = 23;
                        minute = 59;
                        total = hour*60+minute;
                        res.change(total);
                        map.put(entrySet.getKey(), res);
                    }
                }
            }
        }
        
        int[] answer = new int[map.size()];

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        for(int i=0; i<keySet.size(); i++){
            Record entry = map.get(keySet.get(i));
            if(entry.totalTime < fees[0]){
                answer[i] = fees[1];
                continue;
            }
            double data = ((double)(entry.totalTime-fees[0])/fees[2]);
            answer[i] = fees[1]+(int)Math.ceil(data)*fees[3];
        }
        return answer;
    }
}
class Record{
    String num;
    int start;
    int end;
    String status;
    int totalTime=0;

    public Record(String num, int start, String status){
        this.num = num;
        this.start = start;
        this.status = status;
    }

    public void update(int start, String status){
        this.start = start;
        this.status = status;
    }

    public void change(int end){
        this.totalTime += cal(end);
        this.end = end;
        this.status = "OUT";
    }

    private int cal(int end){
        int totalTime=end-this.start;
        return totalTime;
    }
}