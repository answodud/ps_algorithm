import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        int preNum = 10;
        
        for(int num : arr){
            // 이전 숫자와 다를 경우
            if(preNum != num){
                // 숫자 넣어주고 이전 숫자 바꿔주기
                list.add(num);
                preNum = num;
            }    
        }
        
        answer = list.stream().mapToInt(i->i).toArray();

        return answer;
    }
}