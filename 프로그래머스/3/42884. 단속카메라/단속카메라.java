import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 진출 지점 기준 오름차순
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        int out = -30001;
        for(int i = 0; i < routes.length; i++){
            // 진입 지점이 카메라보다 작으면 커버된 것
            if(routes[i][0] <= out){
                continue;
            } else {
                // 진입지점이 카메라보다 크거나 같으면 카메라 설치
                // 진출 부분에 카메라 설치
                answer++;
                out = routes[i][1];
            }
        }
            
        return answer;
    }
}