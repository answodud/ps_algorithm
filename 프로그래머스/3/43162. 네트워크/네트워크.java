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
                if(i == j){
                    continue;
                }
                if(computers[i][j] == 1){
                    graph[i].add(j);
                    System.out.println(i + "와 " + j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                System.out.println(i + "에서 출발");
                answer++;
                dfs(i);
            }
        }
        
        
        return answer;
    }
    
    public void dfs(int v){
        System.out.println(v + " 방문");
        visited[v] = true;
        for(int next : graph[v]){
            if(!visited[next]){
                System.out.println(next + " 방문");
                visited[next] = true;
                dfs(next);
            }
        }
    }
}