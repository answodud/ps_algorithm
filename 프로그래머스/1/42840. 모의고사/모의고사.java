import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};
        
        int[] score = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            if(a[i % 5] == answers[i]){
                score[0]++;
            }
              if(b[i % 8] == answers[i]){
                score[1]++;
            }
              if(c[i % 10] == answers[i]){
                score[2]++;
            }
        }
        System.out.println(score[0]);
          System.out.println(score[1]);
          System.out.println(score[2]);
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        for(int i = 0; i < 3; i++){
            if(max == score[i]){
                list.add(i + 1);
            }
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}