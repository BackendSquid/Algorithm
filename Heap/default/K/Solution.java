import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        SortedMap<Integer, List<Job>> steveJobs = new TreeMap<>();
        
        initJobs(steveJobs, jobs);
        
        PriorityQueue<Job> jobQueue = new PriorityQueue<>();
        
        int currentJobEndTime = 0;
        int currentTime = steveJobs.firstKey();
        int lastJobArrivedTime = steveJobs.lastKey();
        
        int sumTurnArroundTime = 0;
        
        while(!jobQueue.isEmpty() || currentTime <= lastJobArrivedTime) {
            List<Job> currentTimeArrivedJobs = steveJobs.remove(currentTime);
            if (currentTimeArrivedJobs != null) {
                jobQueue.addAll(currentTimeArrivedJobs);
            }
            
            if (currentJobEndTime <= currentTime && !jobQueue.isEmpty()) {
                Job currentJob = jobQueue.poll();
                currentJobEndTime = currentTime + currentJob.getTimeCost();
                sumTurnArroundTime += currentJobEndTime - currentJob.getArrivedTime();
            }
            
            int nextArrivedTime = Integer.MAX_VALUE;
            if (!steveJobs.isEmpty()) {
                nextArrivedTime = steveJobs.firstKey();
            }
            
            if (!jobQueue.isEmpty()) {
                currentTime = Integer.min(nextArrivedTime, currentJobEndTime);    
            } else {
                currentTime = nextArrivedTime;
            }
            
        }
        
        return sumTurnArroundTime / jobs.length;
    }
    
    private void initJobs(Map<Integer, List<Job>> steveJobs, int[][] jobs) {
        for (int[] job : jobs) {
            List<Job> jobList = steveJobs.getOrDefault(job[0], new ArrayList<>());
            
            jobList.add(new Job(job[0], job[1]));
            
            steveJobs.put(job[0], jobList);
        }
    }
    
    
    private static class Job implements Comparable<Job> {
        
        private static final Comparator<Job> COMPARATOR = Comparator
            .comparingInt((Job j) -> j.timeCost)
            .thenComparing(j -> j.arrivedTime);
        
        private int arrivedTime;
        private int timeCost;
        
        public Job(int arrivedTime, int timeCost) {
            this.arrivedTime = arrivedTime;
            this.timeCost = timeCost;
        }
        
        public int getArrivedTime() {
            return arrivedTime;
        }
        
        public int getTimeCost() {
            return timeCost;
        }
        
        @Override
        public int compareTo(Job j) {
            return COMPARATOR.compare(this, j);
        }
    }
}