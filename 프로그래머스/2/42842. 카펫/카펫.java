class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int whole = brown + yellow;
        int yellow_x = 0;
        int yellow_y = 0;
        
        while(true){
            yellow_y++;
            if(yellow % yellow_y == 0){
                yellow_x = yellow / yellow_y;
                if((yellow_x + 2) * (yellow_y + 2) == whole){
                    answer[0] = yellow_x + 2;
                    answer[1] = yellow_y + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}