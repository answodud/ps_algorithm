class Solution {
    
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int total, int depth){
        if(depth == numbers.length){
            if(target == total){
                answer++;
            }
            return;
        }
        
        dfs(numbers, target, total + numbers[depth], depth + 1);
        dfs(numbers, target, total - numbers[depth], depth + 1);
    }
}