class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        
        // 숙련도를 기준으로 이분탐색
        int left = 1;
        int right = 100000;
        
        while(left <= right){
            int mid = (left + right) / 2; // 현재 숙련도
            long time = times[0];
            for(int i = 1; i < diffs.length; i++){
                if(diffs[i] <= mid){
                    time += times[i];
                } else {
                    time += (times[i - 1] + times[i]) * (diffs[i] - mid) + times[i]; 
                }
            }
            
            // 걸린 시간이 limit보다 크면
            if(time > limit){
                left = mid + 1;
            } else { // 걸린 시간이 limit보다 작거나 같으면
                right = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}