class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_x = 0;
        int max_y = 0;
        
        for(int[] size : sizes){
            if(size[1] > size[0]){
                if(size[1] > max_x){
                    max_x = size[1];
                }
                if(size[0] > max_y){
                    max_y = size[0];
                }
            } else {
                 if(size[0] > max_x){
                    max_x = size[0];
                }
                if(size[1] > max_y){
                    max_y = size[1];
                }
            }
        }
        
        answer = max_x * max_y;
        
        return answer;
    }
}