import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 컴퓨터 0번 ~ n-1번
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 간선 이어주기
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int v){
        visited[v] = true;
        for(int next : graph[v]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}