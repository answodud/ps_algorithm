class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
    
        dfs(numbers, target, 0, 0);    
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int cur, int depth){
        if(depth >= numbers.length){
            if(target == cur){
                answer++;
            }
            return;
        }
        dfs(numbers, target, cur + numbers[depth], depth + 1);
        dfs(numbers, target, cur - numbers[depth], depth + 1);
    }
}