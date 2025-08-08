class Solution {
    
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        
        boolean[] mycards = new boolean[n];
        boolean[] newcards = new boolean[n];
        
        for (int i=0; i<n/3; i++) {
            mycards[cards[i]-1] = true;
        }
        int life = 0;
        int templife = 0;
        
        for (int i=0; i<n/2; i++) {
            if (mycards[i] && mycards[n-i-1]) life++;
        }
        
        for (int i=1; i<=n/3+1; i++) {
            if (i==n/3+1) return i;
            
            int card1 = cards[n/3+2*(i-1)];
            int card2 = cards[n/3+2*(i-1)+1];
            
            if (mycards[n-card1] && coin>0) {
                coin--;
                life++;
            }
            if (mycards[n-card2] && coin>0) {
                coin--;
                life++;
            }
            
            if (newcards[n-card1]) templife++;
            else newcards[card1-1] = true;
            
            if (newcards[n-card2]) templife++;
            else newcards[card2-1] = true;
            
            if (life==0 && coin>=2 && templife>0) {
                templife--;
                coin -= 2;
                life++;
            }
            
            if (life==0) return i;
            life--;
        }
        return -1;
    }
    
}