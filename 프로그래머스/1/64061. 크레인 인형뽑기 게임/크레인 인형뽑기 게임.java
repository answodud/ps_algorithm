import java.util.*;

class Solution {
    
    public int solution(int[][] board, int[] moves) {
        
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        
        for(int m : moves){
            for(int i = 0; i < board.length; i++){
                if(board[i][m - 1] == 0){
                    continue;
                } else {
                    boolean doPull = false; // 뺐는지 안 뺐는지 여부
                    // 비어있지 않고, 같다면 빼주기
                    while(!dq.isEmpty() && dq.peekFirst() == board[i][m - 1]){
                        // 최초이면 넣었다 뺀거니까 하나 추가
                        if(!doPull){
                            ans++;
                            doPull = true;
                        }
                        ans++;
                        dq.pollFirst();
                    }
                    // 빼지 않았을 경우에만 넣어주기
                    if(!doPull){
                        dq.offerFirst(board[i][m - 1]);
                    }
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        
        
        
        return ans;
    }
    
    
}