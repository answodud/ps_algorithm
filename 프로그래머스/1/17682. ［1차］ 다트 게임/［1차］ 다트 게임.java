import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int total = 0;
        
        // 총 3번, 0~10점
        // S,D,T -> 1,2,3제곱
        // 옵션 : 스타상(*) 해당점수와 이전점수 2배로 , 아차상(#) 해당점수 마이너스
        
        String s = dartResult;
        int prevScore = 0;
        int curScore = 0;
        int i = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                if(Character.isDigit(s.charAt(i+1))){
                    curScore = Integer.valueOf(s.substring(i,i+2));
                    i++;
                } else {
                    curScore = Integer.valueOf(Character.toString(c)); // S이면 1제곱
                }
                if(s.charAt(i+1) == 'D'){ // D면 2제곱
                    curScore = curScore * curScore;    
                } else if(s.charAt(i+1) == 'T') { // T면 3제곱
                    curScore = curScore * curScore * curScore;
                }
            }
            if(i + 2 < s.length()){
                // 옵션 없는 경우
                if(Character.isDigit(s.charAt(i+2))){
                    total += curScore;
                    prevScore = curScore;
                    i += 2;
                } else { // 옵션 있는 경우
                    // 스타상이라면
                    if(s.charAt(i+2) == '*'){
                        if(i == 0){ // 처음이라면 첫번째점수만
                            curScore *= 2;
                            total += curScore;
                            prevScore = curScore;
                        } else { // 아니라면 이전 점수, 현점수 2배
                            curScore *= 2;
                            total = total - prevScore + curScore;
                            prevScore *= 2;
                            total += prevScore;
                            prevScore = curScore;
                        }
                    } else { // 아차상이라면
                        curScore *= -1;
                        total += curScore;
                        prevScore = curScore;
                    }
                    i += 3;
                }
            } else {
                total += curScore;
                prevScore = curScore;
                i += 2;
                break;
            }
        }
        
        return total;
    }
}