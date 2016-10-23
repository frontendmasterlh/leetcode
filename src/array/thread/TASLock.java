package array.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Implement a Test-And-Set Lock
 */
public class TASLock {
    AtomicBoolean state = new AtomicBoolean(false);

    public void lock() {
        while (state.getAndSet(true)) {}
    }

    public void unlock() {
        state.set(false);
    }
}
