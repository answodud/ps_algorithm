import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        while(true){
            if(left > right){
                break;
            }
            int sum = people[left] + people[right];
            if(sum <= limit){
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