import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[] fileSplits = FileSplit(files);
        List<File> fileList = init(fileSplits);

        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if(o1.head.compareToIgnoreCase(o2.head)==0){
                    if(Integer.parseInt(o1.number)-Integer.parseInt(o2.number)==0){
                        return 0;
                    }
                    else if(Integer.parseInt(o1.number)-Integer.parseInt(o2.number)<0)
                        return -1;
                    return 1;
                }
                else if(o1.head.compareToIgnoreCase(o2.head)<0)
                    return -1;
                return 1;
            }
        });
        
        for(int i=0; i<fileList.size(); i++){
            answer[i] = fileList.get(i).head+fileList.get(i).number+fileList.get(i).tail;
        }
        
        return answer;
    }
    
    private static List<File> init(String[] fileSplits){
        List<File> init = new ArrayList<>();
        for(int i=0; i<fileSplits.length; i++){
            String fileSplit = fileSplits[i];
            String[] file = fileSplit.split(",");
            if(file.length>2) {
                init.add(new File(file[0], file[1], file[2]));
            }
            else if(file.length>1){
                init.add(new File(file[0], file[1], ""));
            }
        }
        return init;
    }

    private static String[] FileSplit(String[] files){
        String[] fileSplit = new String[files.length];
        for(int t=0; t<files.length; t++){
            int i=0;
            fileSplit[t] = "";
            for(;i<files[t].length(); i++){
                char c = files[t].charAt(i);
                if(c-'0'<=9 && c-'0'>=0){
                    fileSplit[t] += ",";
                    break;
                }
                fileSplit[t] += c;
            }
            for(;i<files[t].length(); i++){
                char c = files[t].charAt(i);
                if(c-'0'<=9 && c-'0'>=0){
                    fileSplit[t] += c;
                }
                else{
                    fileSplit[t] += ",";
                    break;
                }
            }
            for(;i<files[t].length(); i++){
                char c = files[t].charAt(i);
                fileSplit[t] += c;
            }
        }
        return fileSplit;
    }

    private static class File{
        String head;
        String number;
        String tail;

        public File(String head, String number, String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
    }
}