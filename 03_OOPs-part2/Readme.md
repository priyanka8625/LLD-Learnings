# Object-Oriented Programming (OOP) - Part 2

## Key Topics

### 1. What is Inheritance in OOP
- Mechanism to derive new classes from existing ones
- Child classes inherit properties and behaviors from parent classes
- Promotes code reusability and logical hierarchy
- Example: Vehicle (parent) → Car, Truck, Motorcycle (children)

### 2. Static Polymorphism (Function Overloading)
- Same function name, different parameters
- Resolved at compile time
- Example: print(int) vs print(String) vs print(Object)
- Implementation: Multiple methods with same name but different signatures

### 3. Dynamic Polymorphism (Method Overriding)
- Same method signature in parent and child classes
- Resolved at runtime
- Enables flexibility and extensibility
- Implementation: Override methods in child classes
- Abstract functions force implementation in child classes

### 4. Real-World Implementation
- Inheritance: Use when "is-a" relationship exists
- Static Polymorphism: Use for operation flexibility
- Dynamic Polymorphism: Use for extensible frameworks
- Abstract classes: For partial implementation with contracts
- Interfaces: For multiple inheritance and full abstraction

### 5. Importance in LLD and Interviews
- Essential for designing flexible, extensible systems
- Core to many design patterns (Template, Strategy, Factory)
- Frequently tested in interviews with real-world scenarios
- Critical for writing clean, maintainable code

## Quick Notes
- Inheritance = "is-a" relationships
- Static Polymorphism = Same name, different parameters
- Dynamic Polymorphism = Same signature, different behavior
- Use abstract classes when partial implementation needed
- Use interfaces for multiple inheritance

---
*Remember: These OOP concepts are tools - use the right one for the right job, not just because you can.* 