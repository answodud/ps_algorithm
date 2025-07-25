import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int left = 0;
        int right = people.length - 1;
        
        Arrays.sort(people);
        
        while(true){
            if(left > right){
                break;
            }
            if(people[left] + people[right] <= limit){
                left++;
                right--;
                answer++;
            } else {
                right--;
                answer++;
            }
        }
        
        return answer;
    }
}