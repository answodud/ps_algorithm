import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long left = 0; // 최소 시간
        long right = times[times.length - 1] * (long)n; // 최대 시간
       
        while(left <= right){
            long cnt = 0;
            long mid = (left + right) / 2;
            for(int time : times){
                cnt += mid / time;
            }
            // 심사받을 수 있는 사람 수가 이미 n을 넘었거나 같으면
            if(cnt >= n){
                // left ~ mid - 1 부분 탐색 + answer에 일단 mid 넣기
                right = mid - 1;
                answer = mid;
            } else {
                // 심사받을 수 있는 수가 적으면
                // mid + 1 ~ right 탐색
                left = mid + 1;
            }
        }
        
        return answer;
    }
}