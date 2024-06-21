// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    public int[] getOrder(int[][] tasks) {
        Comparator<int[]> order = (int[] task1, int[] task2) -> ((Integer) task1[0]).compareTo(task2[0]);
        ArrayList<int[]> taskList = new ArrayList<int[]>();
        for(int i = 0; i < tasks.length; i++) {
            int[] currentTask = new int[3];
            currentTask[0] = tasks[i][0];
            currentTask[1] = tasks[i][1];
            currentTask[2] = i;
            taskList.add(currentTask);
        }
        Collections.sort(taskList, order);
        Comparator<int[]> priority = (int[] task1, int[] task2) -> {
            if(task1[1] == task2[1]) {
                return ((Integer) task1[2]).compareTo(task2[2]);
            } else {
                return ((Integer) task1[1]).compareTo(task2[1]);
            }
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(tasks.length, priority);
        int[] processed = new int[tasks.length];
        int time = 0;
        int cnt = 0;
        for(int i = 0; i < processed.length; i++) {

            for(int j = 0; j < taskList.size(); j++) {
                if(taskList.get(j)[0] <= time) {
                    int[] currentTask = taskList.remove(j);
                    pq.offer(currentTask);
                    j--;
                } else break;
            }

            if(pq.isEmpty()) {
                time = taskList.get(0)[0];
                i--;
            } else {
                int[] currentTask = pq.poll();
                processed[cnt] = currentTask[2];
                time += currentTask[1];
                cnt++;
            }
        }
        return processed;
    }
}