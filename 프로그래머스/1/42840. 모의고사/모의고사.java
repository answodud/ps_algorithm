import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        
        int[] answer_cnt = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == first[i % 5]){
                answer_cnt[0]++;
            }
            if(answers[i] == second[i % 8]){
                answer_cnt[1]++;
            }
            if(answers[i] == third[i % 10]){
                answer_cnt[2]++;
            }
        }
        
        int max_cnt = 0;
        List<Integer> answer = new ArrayList<>();
        for(int x : answer_cnt){
            max_cnt = Math.max(max_cnt, x);
        }
        for(int i = 0; i < 3; i++){
            if(answer_cnt[i] == max_cnt){
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}