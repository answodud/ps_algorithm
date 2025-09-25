import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        graph = new ArrayList[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        int min = 100001;
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            visited = new boolean[n+1];
            int n1 = dfs(1);
            min = Math.min(Math.abs(n1 - (n - n1)), min);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        
        return min;
    }
    
    public int dfs(int v){
        int cnt = 1;
        visited[v] = true;
        for(int next : graph[v]){
            if(!visited[next]){
                visited[next] = true;
                cnt += dfs(next);
            }
            
        }
        
        return cnt;
    }
}