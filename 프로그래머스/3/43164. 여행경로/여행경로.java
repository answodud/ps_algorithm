import java.util.*;

class Solution {
    
    String[][] tickets; 
    List<String> path = new ArrayList<>(); // 경로
    boolean[] visited; // 티켓 단위로 방문 여부 저장
    String[] answer;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        Arrays.sort(tickets, (o1, o2) -> o1[1].compareTo(o2[1]));
        visited = new boolean[tickets.length];
        path.add("ICN");
        dfs(1, "ICN");
        
        return answer;
    }
    
    public void dfs(int depth, String cur){
        if(depth > tickets.length){
            answer = path.toArray(new String[0]);
            return;
        }
        for(int i = 0; i < tickets.length; i++){
            // 방문한 적 없고
            // 출발 지점이 같은 경우
            if(!visited[i] && cur.equals(tickets[i][0])){
                // 방문처리 + 경로에 추가
                visited[i] = true;
                path.add(tickets[i][1]);
                
                dfs(depth + 1, tickets[i][1]);
                
                // 이미 정답이 나온 경우 return
                if(answer != null){
                    return;
                }
                // 다시 방문처리 해제 및 경로에서 제외
                path.remove(path.size() - 1);
                visited[i] = false;
            }
        }
    }
}