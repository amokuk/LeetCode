package com.solution;

import java.util.*;

public class S4 {
    public static void main(String[] args) {
        S4 s = new S4();
        Task t1 = new Task(1, 2,20);
        Task t2 = new Task(2, 3,15);
        Task t3 = new Task(3, 5,10);
        Task t4 = new Task(4, 50,10);
        List<Integer> ans = s.getExecOrder(Arrays.asList(t1, t2, t3, t4));
        ans.stream().forEach(n-> System.out.print(n + ", "));
    }

    public List<Integer> getExecOrder(List<Task> tasks) {
        int N = tasks.size();
        List<Integer> ans = new ArrayList<>();
        if(N == 0) return ans;

        Collections.sort(tasks, (t1, t2) -> t1.qtime == t2.qtime ? t1.etime - t2.etime : t1.qtime - t2.qtime);

        Queue<Task> queue = new PriorityQueue<>((t1, t2) -> t1.etime == t2.etime ? t1.qtime - t2.qtime : t1.etime - t2.etime);
        int idx = 0, curTime = tasks.get(0).qtime;

        while(idx < N || !queue.isEmpty()) {
            if(queue.isEmpty() && curTime < tasks.get(idx).qtime) {
                curTime = tasks.get(idx).qtime;
            }

            while(idx < N && tasks.get(idx).qtime <= curTime) {
                queue.offer(tasks.get(idx++));
            }

            if(!queue.isEmpty()) {
                Task curTask = queue.poll();
                curTime += curTask.etime;
                ans.add(curTask.id);
            }
        }

        return ans;
    }
}

class Task {
    int id;
    int qtime;
    int etime;

    public Task(int id, int qtime, int etime) {
        this.id = id;
        this.qtime = qtime;
        this.etime = etime;
    }
}
