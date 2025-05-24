/**
 * Singleton Implementation using Early Initialization
 * This is the simplest and most thread-safe implementation
 * as the instance is created when the class is loaded
 */
public class EarlyInitialization {
    // Private static final instance created at class loading time
    private static final EarlyInitialization instance = new EarlyInitialization();
    
    // Private constructor
    private EarlyInitialization() {
        System.out.println("Creating new Early Initialization Singleton instance");
    }
    
    // Public method to get the instance
    public static EarlyInitialization getInstance() {
        return instance;
    }
    
    // Main method to test the singleton
    public static void main(String[] args) {
        // Get first instance
        EarlyInitialization singleton1 = EarlyInitialization.getInstance();
        
        // Try to get second instance
        EarlyInitialization singleton2 = EarlyInitialization.getInstance();
        
        // Check if both references point to the same instance
        System.out.println("Are both instances same? " + (singleton1 == singleton2));
        
        // Note: Even though we don't use the instance, it's already created
        // when the class is loaded, which might be a waste of resources
        // if the instance is never used
    }
} 