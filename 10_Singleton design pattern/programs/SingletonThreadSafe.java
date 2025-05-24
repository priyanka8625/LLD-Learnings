/**
 * Thread-Safe Singleton Implementation using synchronized method
 * Note: This implementation is thread-safe but has performance overhead
 * due to synchronized method
 */
public class SingletonThreadSafe {
    // Private static instance
    private static SingletonThreadSafe instance;
    
    // Private constructor
    private SingletonThreadSafe() {
        System.out.println("Creating new Thread-Safe Singleton instance");
    }
    
    // Synchronized method to get instance
    public static synchronized SingletonThreadSafe getInstance() {
        if (instance == null) {
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
    
    // Main method to test the singleton
    public static void main(String[] args) {
        // Create multiple threads to test thread safety
        Thread thread1 = new Thread(() -> {
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
        });
        
        Thread thread2 = new Thread(() -> {
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
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
        SingletonThreadSafe singleton1 = SingletonThreadSafe.getInstance();
        SingletonThreadSafe singleton2 = SingletonThreadSafe.getInstance();
        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
} 