package array.thread;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Implement a Test-Test-And-Set Lock
 */
public class TTASLock {
    AtomicBoolean state = new AtomicBoolean(false);

    public void lock() {
        while (true) {
            while (state.get()) {}
            if (!state.getAndSet(true)) {
                return;
            }
        }
    }

    public void unlock() {
        state.set(false);
    }
}
