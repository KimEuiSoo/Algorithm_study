import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        List<String> res = new ArrayList<>();
        HashMap<String, String> userList = new HashMap<>();
        for(String userData : record){
            String[] user = userData.split(" ");
            String status = user[0];
            String uid = user[1];
            if(status.equals("Enter") || status.equals("Change")){
                String name = user[2];
                userList.put(uid, name);
            }
        }
        
        for(String userData : record){
            String[] user = userData.split(" ");
            String status = user[0];
            String uid = user[1];
            if(status.equals("Enter")){
                res.add(userList.get(uid)+"님이 들어왔습니다.");
            }
            else if(status.equals("Leave")){
                res.add(userList.get(uid)+"님이 나갔습니다.");
            }
        }
        String[] answer = new String[res.size()];
        for(int i=0; i<res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }
}