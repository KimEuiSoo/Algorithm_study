import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int idx;
    int cost;

    Node(int idx, int cost){
        this.idx = idx;
        this.cost = cost;
    }
}

public class Main {
    private static int N=0, M=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 노드 지점 갯수
        int v = Integer.parseInt(st.nextToken());
        // 연결된 노드 선 갯수
        int e = Integer.parseInt(st.nextToken());

        // 연결된 그래프
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 그래프 생성
        for(int i=0; i<v+1; i++){
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b,1));
            graph.get(b).add(new Node(a, 1));
        }

        int minCnt = Integer.MAX_VALUE;
        int minNode = 0;
        for(int s=1; s<v+1; s++) {
            // 시작 지점
            int start = s;

            boolean[] vi = new boolean[v + 1];
            int[] dst = new int[v + 1];

            for (int i = 0; i < v + 1; i++) {
                dst[i] = Integer.MAX_VALUE;
            }
            dst[start] = 0;

            int cnt = 0;
            for (int i = 0; i < v; i++) {
                int nodeValue = Integer.MAX_VALUE;
                int nodeIdx = 0;
                for (int j = 0; j < v + 1; j++) {
                    if (!vi[j] && dst[j] < nodeValue) {
                        nodeValue = dst[j];
                        nodeIdx = j;
                    }
                }
                vi[nodeIdx] = true;

                for (int j = 0; j < graph.get(nodeIdx).size(); j++) {
                    Node adjNode = graph.get(nodeIdx).get(j);
                    if (dst[adjNode.idx] > dst[nodeIdx] + adjNode.cost) {
                        dst[adjNode.idx] = dst[nodeIdx] + adjNode.cost;
                    }
                }
            }

            for (int i = 1; i < v + 1; i++) {
                cnt+=dst[i];
            }

            if(minCnt > cnt) {
                minCnt = cnt;
                minNode=s;
            }
        }
        sb.append(minNode);
        System.out.println(sb);
    }
}
