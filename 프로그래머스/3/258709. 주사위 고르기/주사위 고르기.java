import java.util.*;

class Solution {
    int n;
    int[][] dice;
    double bestWinRate = -1;
    List<Integer> bestPick;

    public int[] solution(int[][] dice) {
        this.n = dice.length;
        this.dice = dice;
        bestPick = new ArrayList<>();

        // 주사위 선택 조합 만들기
        dfs(0, 0, new ArrayList<>());

        // 결과 반환 (1-based index)
        int[] answer = new int[bestPick.size()];
        for (int i = 0; i < bestPick.size(); i++) {
            answer[i] = bestPick.get(i) + 1;
        }
        return answer;
    }

    // 주사위 선택 DFS
    void dfs(int start, int cnt, List<Integer> picked) {
        if (cnt == n / 2) {
            // 나머지 주사위 인덱스 구하기
            List<Integer> others = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!picked.contains(i)) others.add(i);
            }

            // 합 분포 계산
            Map<Integer, Integer> myDist = getSumDist(picked);
            Map<Integer, Integer> enemyDist = getSumDist(others);

            // 승률 계산
            double winRate = calcWinRate(myDist, enemyDist);

            // 최적 갱신
            if (winRate > bestWinRate) {
                bestWinRate = winRate;
                bestPick = new ArrayList<>(picked);
            }
            return;
        }

        for (int i = start; i < n; i++) {
            picked.add(i);
            dfs(i + 1, cnt + 1, picked);
            picked.remove(picked.size() - 1);
        }
    }

    // 선택된 주사위 세트의 합 분포 구하기
    Map<Integer, Integer> getSumDist(List<Integer> diceSet) {
        Map<Integer, Integer> dist = new HashMap<>();
        dist.put(0, 1); // 시작합 0, 경우 수 1

        for (int idx : diceSet) {
            Map<Integer, Integer> next = new HashMap<>();
            for (var e : dist.entrySet()) {
                for (int face : dice[idx]) {
                    int sum = e.getKey() + face;
                    next.put(sum, next.getOrDefault(sum, 0) + e.getValue());
                }
            }
            dist = next;
        }
        return dist;
    }

    // 승률 계산
    double calcWinRate(Map<Integer, Integer> my, Map<Integer, Integer> enemy) {
        long total = 0, win = 0;
        for (var me : my.entrySet()) {
            for (var en : enemy.entrySet()) {
                long cases = (long) me.getValue() * en.getValue();
                total += cases;
                if (me.getKey() > en.getKey()) win += cases;
            }
        }
        return (double) win / total;
    }
}
