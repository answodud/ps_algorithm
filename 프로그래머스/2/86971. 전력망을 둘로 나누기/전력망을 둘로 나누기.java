import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int min = n;
        graph = new ArrayList[n+1];
        
        
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        // 처신을 잘하자!
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            visited = new boolean[n+1];
            
            int cnt = dfs(1);
            min = Math.min(Math.abs(cnt - (n - cnt)), min);
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return min;
    }
    
    public int dfs(int v){
        visited[v] = true;
        int cnt = 1;
        for(int next : graph[v]){
                if(!visited[next]){
                    cnt += dfs(next);
                }
            }
        
        return cnt;
    }
}