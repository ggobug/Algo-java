import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        // 멘토 인원을 적절히 배치하여 기다리는 최소 시간 구하기
        int minWaitTime = Integer.MAX_VALUE;
        
        // 인원 분배하기(조합)
        List<int[]> distributions = generateDistributions(k, n);

        // 완탐해서 최소 대기 시간 구하기
        for (int[] distribution : distributions) {
            int waitTime = calculateWaitTime(k, n, reqs, distribution);
            minWaitTime = Math.min(minWaitTime, waitTime);
        }

        return minWaitTime;
    }

    private List<int[]> generateDistributions(int k, int n) {
        List<int[]> distributions = new ArrayList<>();
        int[] distribution = new int[k];
        generateDistributionsHelper(distributions, distribution, k, n, 0);
        return distributions;
    }

    private void generateDistributionsHelper(List<int[]> distributions, int[] distribution, int k, int n, int index) {
        if (index == k - 1) {
            distribution[index] = n;
            distributions.add(distribution.clone());
            return;
        }
        for (int i = 1; i <= n - (k - 1 - index); i++) {
            distribution[index] = i;
            generateDistributionsHelper(distributions, distribution, k, n - i, index + 1);
        }
    }

    private int calculateWaitTime(int k, int n, int[][] reqs, int[] distribution) {
        PriorityQueue<Integer>[] mentors = new PriorityQueue[k];
        for (int i = 0; i < k; i++) {
            mentors[i] = new PriorityQueue<>();
            for (int j = 0; j < distribution[i]; j++) {
                mentors[i].add(0);
            }
        }

        int totalWaitTime = 0;

        for (int[] req : reqs) {
            int requestTime = req[0];
            int duration = req[1];
            int type = req[2] - 1;

            int earliestAvailableTime = mentors[type].poll();
            int waitTime = Math.max(0, earliestAvailableTime - requestTime);
            totalWaitTime += waitTime;

            mentors[type].add(requestTime + waitTime + duration);
        }

        return totalWaitTime;
    }
}