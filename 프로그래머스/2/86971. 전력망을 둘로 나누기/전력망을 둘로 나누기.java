import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    boolean[] visited;
    public int solution(int n, int[][] wires) {
        int answer = 100001;
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
        
        // 하나씩 끊고
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            // 방문 배열 항상 초기화
            visited = new boolean[n+1];
            
            int n1 = dfs(1);
            answer = Math.min(Math.abs(n1 - (n - n1)), answer);
            
            // 원상복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    public int dfs(int v){
        visited[v] = true;
        int cnt = 1; // 방문한 본인 포함
        for(int next : graph[v]){
            if(!visited[next]){
                cnt += dfs(next);
            }
        }
        return cnt;
    }
}