import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int total_count = citations.length;
        for(int i = 0; i < citations.length; i++){
            if(citations[i] == total_count - i){
                answer = citations[i];
                break;
            } else if(citations[i] < total_count - i){
                continue;
            } else {
                answer = total_count - i;
                break;
            }
        }
        
        return answer;
    }
}