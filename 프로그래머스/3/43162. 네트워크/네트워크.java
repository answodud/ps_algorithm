import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    int answer = 0;
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        // 간선 연결
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                System.out.println(i + " 시작");
                dfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int v){
        if(!visited[v]){
            System.out.println(v + " 방문");
            visited[v] = true;
            for(int next : graph[v]){
                dfs(next);
            }
        }
    }
}