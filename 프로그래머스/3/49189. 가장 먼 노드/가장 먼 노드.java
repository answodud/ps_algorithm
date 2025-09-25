import java.util.*;

class Solution {
    
    ArrayList<Integer>[] graph;
    int[] dist;
    
    public int solution(int n, int[][] edge) {
        int answer = 0;
        graph = new ArrayList[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, -1);
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edge.length; i++){
            int v1 = edge[i][0];
            int v2 = edge[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        bfs(1);
        
        int max_dist = 0;
        for(int x : dist){
            max_dist = Math.max(max_dist, x);
        }
        
        for(int x : dist){
            if(max_dist == x){
                answer++;
            }
        }
    
        return answer;
    }
    
    public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.offer(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : graph[cur]){
                if(dist[next] == -1){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}