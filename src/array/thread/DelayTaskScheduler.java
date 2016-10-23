package array.thread;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Implement a Delay Task Scheduler
 */
public class DelayTaskScheduler {

    public static class Task implements Comparable<Task> {
        private long timeToRun;
        private int id;

        public void setId(int id) {
            this.id = id;
        }

        public void setTimeToRun(long timeToRun) {
            this.timeToRun = timeToRun;
        }

        public long getTimeToRun() {
            return this.timeToRun;
        }

        public void run() {
            System.out.println("Running task " + id);
        }

        @Override
        public int compareTo(Task o) {
            return (int) (timeToRun - o.getTimeToRun());
        }
    }


    private PriorityQueue<Task> tasks;
    private final Thread taskRunnerThread;
    private volatile boolean running;
    private final AtomicInteger taskId;

    public DelayTaskScheduler() {
        tasks = new PriorityQueue<>();
        taskRunnerThread = new Thread(new TaskRunner());
        running = true;
        taskId = new AtomicInteger(0);
        taskRunnerThread.start();
    }

    public void schedule(Task task, long delayMs) {
        long timeToRun = System.currentTimeMillis() + delayMs;
        task.setTimeToRun(timeToRun);
        task.setId(taskId.incrementAndGet());
        synchronized (this) {
            tasks.offer(task);
            this.notify(); // I only have one another thread
        }
    }

    public void stop() throws InterruptedException {
        synchronized (this) {
            running = false;
            this.notify();
        }
        taskRunnerThread.join();
    }

    private class TaskRunner implements Runnable {

        @Override
        public void run() {
            while (running) {
                synchronized (DelayTaskScheduler.this) {
                    try {
                        while (running && tasks.isEmpty()) {
                            DelayTaskScheduler.this.wait();
                        }
                        long now = System.currentTimeMillis();
                        Task t = tasks.peek();
                        if (t.getTimeToRun() < now) {
                            tasks.poll();
                            t.run();
                        } else {
                            DelayTaskScheduler.this.wait(t.getTimeToRun() - now);
                        }
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayTaskScheduler scheduler = new DelayTaskScheduler();
        scheduler.schedule(new Task(), 1000 * 5);
        scheduler.schedule(new Task(), 1000);
        Thread.sleep(1000 * 10);
        scheduler.stop();
    }
}
