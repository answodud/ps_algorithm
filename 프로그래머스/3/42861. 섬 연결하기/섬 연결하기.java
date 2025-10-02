import java.util.*;

class Solution {
    
    boolean[] visited;
    int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        visited = new boolean[n];
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        // 배열을 비용 기준 오름차순으로 정렬
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for(int i = 0; i < costs.length; i++){
            if(find(costs[i][0]) != find(costs[i][1])){
                answer += costs[i][2];
                union(costs[i][0], costs[i][1]);
            }
        }
        
        return answer;
    }
    
    public int find(int x){
        // x의 부모가 x면 x를 그냥 return
        if(parent[x] == x){
            return x;
        } else {
            // 아니라면 x를 
            return x = find(parent[x]);
        }
    }
    
    // 합치기
    public void union(int x, int y){
        x = find(x); // x의 가장 부모 찾기
        y = find(y); // y의 가장 부모 찾기
        if(x != y){ // 같은 집합이 아니라면 합쳐주기
            parent[y] = x;
        }
    }
}