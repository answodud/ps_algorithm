class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int max_x = 0;
        int max_y = 0;
        
        for(int[] size : sizes){
            int x = size[0];
            int y = size[1];
            
            if(x > y){
                max_x = Math.max(max_x, x);
                max_y = Math.max(max_y, y);
            } else {
                max_x = Math.max(max_x, y);
                max_y = Math.max(max_y, x);
            }
            
        }
        
        return max_x * max_y;
    }
}