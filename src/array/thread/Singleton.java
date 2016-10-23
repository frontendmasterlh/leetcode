package array.thread;

/**
 * Implement a singleton
 */
public class Singleton {
    private volatile static Singleton instance;

    private Singleton() {
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(); // Lazy initialization
                }
            }
        }
        return instance;
    }

//    private static final Singleton instance = new Singleton(); // Eager initialization
//    public Singleton getInstance() {
//        return instance;
//    }
}
