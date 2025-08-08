class Solution {
    int[] diffs;
    int[] times;
    
    public long solution(int[] diffs, int[] times, long limit) {
        long answer = 0;
        this.diffs = diffs;
        this.times = times;
        long left = 1;
        long right = 100000;
        while(left <= right){
            long mid = (left + right) / 2;
            long t = game(mid);
            if(t > limit){
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    public long game(long level){
            long t = times[0]; // 현재 시간
            int cur = 1; // 현재 풀고 있는 퍼즐 번호
            while(cur < diffs.length){
                if(diffs[cur] <= level){
                    t += (long)(times[cur]);
                    cur++;
                } else {
                    t += (long)((long)(diffs[cur]) - (long)(level)) * (long)((long)(times[cur - 1]) + (long)(times[cur])) + (long)(times[cur]);
                    cur++;
                }
            }
            return t;
    }
}