import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int preNum = 10;
        
        for(int num : arr){
            if(num != preNum){
                list.add(num);
                preNum = num;
            } else {
                preNum = num;
                continue;
            }
        }

        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}