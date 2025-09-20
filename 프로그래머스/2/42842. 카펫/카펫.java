class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int yellow_x = 1;
        int yellow_y = 1;
        while(true){
            if(yellow_x != 0){
                if(yellow % yellow_x == 0){
                    yellow_y = yellow / yellow_x;
                    if(((yellow_x + 2) * (yellow_y + 2) - (yellow_x * yellow_y)) == brown){
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
            }
            yellow_x++;
        }
        
        return answer;
    }
}