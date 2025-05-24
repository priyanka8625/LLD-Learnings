/**
 * Basic Singleton Implementation with Lazy Initialization
 * Note: This implementation is not thread-safe
 */
public class Singleton {
    // Private static instance
    private static Singleton instance;
    
    // Private constructor to prevent direct instantiation
    private Singleton() {
        System.out.println("Creating new Singleton instance");
    }
    
    // Public method to get the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    // Main method to test the singleton
    public static void main(String[] args) {
        // Get first instance
        Singleton singleton1 = Singleton.getInstance();
        
        // Try to get second instance
        Singleton singleton2 = Singleton.getInstance();
        
        // Check if both references point to the same instance
        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
} 