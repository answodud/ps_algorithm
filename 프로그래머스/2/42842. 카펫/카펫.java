class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int yellow_x = 0;
        int yellow_y = 0;
        
        while(true){
            yellow_x++;
            if(yellow % yellow_x == 0){
                yellow_y = yellow / yellow_x;
            }
            if(((yellow_x + 2) * (yellow_y + 2) - yellow) == brown){
                System.out.println(yellow_x + " " + yellow_y);
                if(yellow_x >= yellow_y){
                    answer[0] = yellow_x + 2;
                    answer[1] = yellow_y + 2;
                } else {
                    answer[0] = yellow_y + 2;
                    answer[1] = yellow_x + 2;
                }
                
                break;
            }
        }
        
        return answer;
    }
}