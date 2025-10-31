class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int yellow_y = 1;
        int yellow_x;
        while(true){
            if(yellow % yellow_y == 0){
                yellow_x = yellow / yellow_y;
                if((yellow_x + 2) * (yellow_y + 2) == (brown + yellow)){
                    if(yellow_x > yellow_y){
                        answer[0] = yellow_x + 2;
                        answer[1] = yellow_y + 2;
                        
                    } else {
                        answer[1] = yellow_x + 2;
                        answer[0] = yellow_y + 2;
                    }
                    break;
                }
            }
            yellow_y++;
        }
        
        return answer;
    }
}