/**
 * Singleton Implementation using Double-Checked Locking Pattern
 * This is a more efficient thread-safe implementation that reduces
 * the overhead of acquiring a lock by first testing the locking criterion
 */
public class DoubleCheckedLocking {
    // Private static volatile instance
    // volatile keyword ensures that multiple threads handle the instance variable correctly
    private static volatile DoubleCheckedLocking instance;
    
    // Private constructor
    private DoubleCheckedLocking() {
        System.out.println("Creating new Double-Checked Locking Singleton instance");
    }
    
    // Double-checked locking implementation
    public static DoubleCheckedLocking getInstance() {
        // First check (without locking)
        if (instance == null) {
            // Synchronized block
            synchronized (DoubleCheckedLocking.class) {
                // Second check (with locking)
                if (instance == null) {
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
    
    // Main method to test the singleton
    public static void main(String[] args) {
        // Create multiple threads to test thread safety
        Thread thread1 = new Thread(() -> {
            DoubleCheckedLocking singleton = DoubleCheckedLocking.getInstance();
        });
        
        Thread thread2 = new Thread(() -> {
            DoubleCheckedLocking singleton = DoubleCheckedLocking.getInstance();
        });
        
        // Start both threads
        thread1.start();
        thread2.start();
        
        // Wait for threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Verify singleton behavior
        DoubleCheckedLocking singleton1 = DoubleCheckedLocking.getInstance();
        DoubleCheckedLocking singleton2 = DoubleCheckedLocking.getInstance();
        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
} 