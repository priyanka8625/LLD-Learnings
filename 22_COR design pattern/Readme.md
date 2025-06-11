# Chain of Responsibility (COR) Design Pattern

## 🎯 Overview
The Chain of Responsibility pattern is a behavioral design pattern that allows you to pass requests along a chain of handlers. Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.

## 📝 Key Concepts

### Standard Definition
- A behavioral design pattern that creates a chain of receiver objects for a request
- Each receiver contains a reference to another receiver
- If one object cannot handle the request, it passes the same to the next receiver
- The request travels along the chain until it's handled or reaches the end

### UML Diagram Components
1. **Handler Interface/Abstract Class**
   - Defines the interface for handling requests
   - Implements the successor link
   - Contains abstract method for handling requests

2. **Concrete Handlers**
   - Implements the handling of requests
   - Can access its successor
   - Can either handle the request or forward it

3. **Client**
   - Initiates the request to a ConcreteHandler object in the chain

## 💡 Real-World Example: Cash Dispensing System

### Flow for Cash Dispensing
1. Request for cash withdrawal comes to the ATM
2. Request passes through different handlers (denominations)
3. Each handler tries to process the request
4. If a handler can't process fully, it passes remaining amount to next handler
5. Process continues until amount is fully dispensed or chain ends

### Code Structure
```java
// Handler Interface
public abstract class CashDispenser {
    protected CashDispenser nextDispenser;
    protected int denomination;
    
    public void setNextDispenser(CashDispenser next) {
        this.nextDispenser = next;
    }
    
    public abstract void dispense(int amount);
}

// Concrete Handlers
public class HundredDispenser extends CashDispenser {
    public HundredDispenser() {
        this.denomination = 100;
    }
    
    @Override
    public void dispense(int amount) {
        int notes = amount / denomination;
        int remaining = amount % denomination;
        
        if (notes > 0) {
            System.out.println("Dispensing " + notes + " notes of " + denomination);
        }
        
        if (remaining > 0 && nextDispenser != null) {
            nextDispenser.dispense(remaining);
        }
    }
}
```

## 🔄 COR vs LinkedList
- **Similarities**:
  - Both use a chain-like structure
  - Both have nodes connected to next nodes
  - Both traverse through elements sequentially

- **Differences**:
  - COR is about handling requests, LinkedList is about data storage
  - COR handlers can process requests, LinkedList nodes just store data
  - COR can have different types of handlers, LinkedList typically has same type nodes
  - COR can break the chain after handling, LinkedList always maintains structure

## 🌟 Real-World Use Cases
1. **Logging Systems**
   - Different log levels (ERROR, WARNING, INFO)
   - Each level can handle or pass to next level

2. **Event Handling in GUI**
   - Events bubble up through components
   - Each component can handle or pass the event

3. **Exception Handling**
   - Different exception handlers in try-catch blocks
   - Each handler can process or propagate exceptions

4. **Middleware in Web Applications**
   - Request processing through multiple middleware
   - Each middleware can process or forward the request

## 📊 Advantages
1. **Loose Coupling**
   - Sender doesn't need to know which object handles the request
   - Handlers can be added or removed without affecting the client

2. **Single Responsibility**
   - Each handler focuses on its specific responsibility
   - Makes the code more maintainable

3. **Flexibility**
   - Easy to add or remove handlers
   - Can change the chain at runtime

## ⚠️ Disadvantages
1. **Performance Impact**
   - Request might not be handled
   - Chain traversal can be inefficient for long chains

2. **Debugging Complexity**
   - Hard to debug when chain is long
   - Difficult to track which handler processed the request

## 💼 Interview Questions
1. **Q: When would you use COR pattern?**
   - When multiple objects can handle a request
   - When you want to decouple sender and receiver
   - When you want to add or remove handlers dynamically

2. **Q: How does COR differ from Command pattern?**
   - COR focuses on who handles the request
   - Command focuses on what the request is
   - COR can have multiple handlers, Command typically has one

3. **Q: What are the key components of COR?**
   - Handler interface/abstract class
   - Concrete handlers
   - Client
   - Request object

4. **Q: How do you implement COR in a thread-safe way?**
   - Use immutable handlers
   - Synchronize the chain traversal
   - Use thread-safe data structures

## 🎓 Best Practices
1. Keep the chain as short as possible
2. Make handlers immutable when possible
3. Consider using a default handler at the end of chain
4. Document the order of handlers clearly
5. Use meaningful names for handlers

## 🔗 Related Design Patterns
- **Command Pattern**: Encapsulates a request as an object
- **Composite Pattern**: Can be used to implement the chain
- **Decorator Pattern**: Similar structure but different intent
- **Observer Pattern**: Alternative for event handling

---

