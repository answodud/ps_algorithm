import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        int max_n = 0;
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            for(int x : edge){
                max_n = Math.max(x, max_n);
            }
        }
        
        int[] in = new int[max_n + 1];
        int[] out = new int[max_n + 1];
        
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            out[x]++;
            in[y]++;
        }
        
        for(int i = 1; i <= max_n; i++){
            // 정점
            if(in[i] == 0 && out[i] >= 2){
                answer[0] = i;
                break;
            }
        }
        
        for(int i = 1; i <= max_n; i++){
            if(i == answer[0]){
                continue;
            }
            // 막대그래프
            if(in[i] >= 1 && out[i] == 0){
                answer[2]++;
            }
            // 8자 그래프
            if(out[i] >= 2){
                answer[3]++;
            }
        }
        
        answer[1] = out[answer[0]] - answer[2] - answer[3];
        
        return answer;
    }
    
}