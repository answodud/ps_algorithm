class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        int maxTime = 0;
        for(int time : times){
            maxTime = Math.max(time, maxTime);
        }
        long left = 1;
        long right = (long) maxTime * n;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long total = 0;
            
            for(int time : times){
                total += mid / time;
            }
            
            if(total >= n){
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
            
        return answer;
    }
}