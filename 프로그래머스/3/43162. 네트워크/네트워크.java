import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    graph[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start){
        visited[start] = true;
            for(int next : graph[start]){
                if(!visited[next]){
                    visited[next] = true;
                    dfs(next);
                }
            }
    }
}