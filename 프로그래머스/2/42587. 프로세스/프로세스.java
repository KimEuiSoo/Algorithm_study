import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Process> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new Process(priorities[i], i));
        }

        int count = 0;

        while (!q.isEmpty()) {
            Process now = q.poll();

            boolean hasHigher = false;
            for (Process p : q) {
                if (p.priority > now.priority) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                // 다시 뒤로 보내기
                q.add(now);
            } else {
                // 실행
                count++;
                if (now.index == location) {
                    return count;
                }
            }
        }
        return -1;
    }
}

class Process {
    int priority;
    int index;

    public Process(int priority, int index) {
        this.priority = priority;
        this.index = index;
    }
}