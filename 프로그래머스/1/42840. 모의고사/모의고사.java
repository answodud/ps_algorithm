import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(one[i % 5] == answers[i]){
                score[0]++;
            }
            if(two[i % 8] == answers[i]){
                score[1]++;
            }
            if(three[i % 10] == answers[i]){
                score[2]++;
            }
        }
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            if(score[i] == max){
                list.add(i+1);
            }
        }
        
        answer = list.stream().mapToInt(i->i).toArray();
        
        return answer;
    }
}