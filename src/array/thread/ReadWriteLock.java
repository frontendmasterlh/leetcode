package array.thread;

/**
 * Implement Read Write Lock
 */
public class ReadWriteLock {
    private int readers;
    private boolean writer;

    public class ReadLock {

        public void lock() {
            synchronized(ReadWriteLock.this) {
                try {
                    while(!writer) {
                        ReadWriteLock.this.wait();
                    }
                    readers++;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void unlock() {
            synchronized (ReadWriteLock.this) {
                readers--;
                if (readers == 0) {
                    ReadWriteLock.this.notify();
                }
            }
        }
    }

    public class WriteLock {

        public void lock() {
            synchronized (ReadWriteLock.this) {
                try {
                    while (!writer || readers > 0) {
                        ReadWriteLock.this.wait();
                    }
                    writer = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void unlock() {
            synchronized (ReadWriteLock.this) {
                writer = false;
                ReadWriteLock.this.notifyAll();
            }
        }
    }
}
