class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        dfs(0, target, numbers, 0);
        
        return answer;
    }
    
    public void dfs(int num, int target, int[] numbers, int depth){
        if(depth >= numbers.length){
            if(num == target){
                answer++;
            }
            return;
        }
        
        dfs(num + numbers[depth], target, numbers, depth + 1);
        dfs(num - numbers[depth], target, numbers, depth + 1);
        
    }
}