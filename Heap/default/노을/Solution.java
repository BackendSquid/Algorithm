package com.example.programmers.디스크컨트롤러_42627;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{{0, 3},{3, 9}, {1, 100}}));
    }

    public int solution(int[][] jobs) {
        int totalTime = 0;
        int currentTime = 0;  // 작업 후 시간
        int processedRequestNumber = 0; //수행된 요청 갯수

        // 요청시간을 오름차순 정렬
        //Arrays.sort(jobs, Comparator.comparingInt(job->job[0]));
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 처리 시간 오름차순으로 정렬되는 우선순위 큐(Heap)
        //PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(job->job[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        int jobsIndex = 0; // jobs 배열의 인덱스

        // 요청이 모두 수행될 떄까지 반복
        while (processedRequestNumber < jobs.length) {

            // 하나의 작업이 완료되는 시점까지 들어온 모든 요청을 큐에 넣는다.
            // 무작정 요청시간이 짧은 것으로 정렬하는게 아니라, 하나의 작업이 끝나는 시점까지 들어온 요청에 대해서
            // 가장 짧은 수행시간을 가진 작업을 선택
            while (jobsIndex < jobs.length && jobs[jobsIndex][0] <= currentTime) {
                pq.add(jobs[jobsIndex++]);
            }
            // 큐가 비어있다면 작업완료 이후에 다시 요청이 들어온다는 의미
            if (pq.isEmpty()) {
                currentTime = jobs[jobsIndex][0];
            }
            // 작업이 끝나기 전 들어온 요청 중 가장 수행시간이 짧은 요청부터 수행
            else {
                int[] job = pq.poll();
                // 작업시간 + 대기시간
                totalTime += job[1] + currentTime - job[0];
                currentTime += job[1];
                processedRequestNumber++;
            }
        }
        return totalTime / jobs.length;
    }
}
