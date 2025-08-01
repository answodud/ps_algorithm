import java.util.*;

class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    class Node {
        int num;
        int step;
        
        Node(int num, int step){
            this.num = num;
            this.step = step;
        }
    }
    public int solution(int n, int[][] edge) {

        graph = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return bfs(1);
    }
    
    public int bfs(int start){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, 0));
        visited[start] = true;
        
        int maxStep = 0;
        int count = 0;
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(maxStep < cur.step){
                maxStep = cur.step;
                count = 1;
            } else if(maxStep == cur.step){
                count++;
            }
            
            visited[cur.num] = true;
            for(int next : graph[cur.num]){
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(new Node(next, cur.step + 1));
                }
            }
        }
        
        return count;
    }
}