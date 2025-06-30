# Bridge Design Pattern - LLD Revision Notes

## 1. Introduction
The **Bridge Design Pattern** is a structural pattern that decouples an abstraction from its implementation, allowing both to vary independently. It is especially useful in scenarios where you want to avoid a combinatorial explosion of classes due to multiple dimensions of change.

---

## 2. What Problem Does the Bridge Pattern Solve?
When a class has multiple orthogonal (independent) dimensions of variation, subclassing for every combination leads to a large, unmanageable number of classes. For example, if you have different types of cars (Sedan, SUV) and different types of engines (Petrol, Diesel, Electric), subclassing for every combination (SedanPetrol, SedanDiesel, SUVElectric, etc.) is not scalable.

**Bridge Pattern** solves this by splitting the abstraction (Car) and its implementation (Engine) into separate class hierarchies, connecting them via composition rather than inheritance. This allows you to mix and match implementations at runtime, reducing code duplication and increasing flexibility.

---

## 3. Standard Definition
> "Bridge Pattern decouples an abstraction from its implementation so that the two can vary independently."

- Promotes composition over inheritance.
- Useful when both abstractions and their implementations may change frequently.

---

## 4. Bridge vs Strategy: Impact, Intent, and Use Cases

### Intent
- **Bridge Pattern:**
  - Its intent is to decouple an abstraction from its implementation, so both can evolve independently. It addresses the problem of class explosion when you have multiple dimensions of change (e.g., types of devices and types of communication protocols).
- **Strategy Pattern:**
  - Its intent is to define a family of algorithms, encapsulate each one, and make them interchangeable. It lets the algorithm vary independently from clients that use it, focusing on changing behavior at runtime.

### Impact
- **Bridge Pattern:**
  - Reduces code duplication and increases flexibility by separating abstraction and implementation hierarchies. Changes in one dimension (e.g., adding a new engine type) do not affect the other (e.g., car types).
  - Makes the system more scalable and easier to maintain, especially as the number of combinations grows.
- **Strategy Pattern:**
  - Promotes the Open/Closed Principle by allowing new algorithms to be introduced without modifying existing code.
  - Makes it easy to switch behaviors at runtime, leading to more dynamic and flexible systems.

### Use Cases
- **Bridge Pattern:**
  - Use when you have orthogonal dimensions that can change independently, such as UI controls (Button, Window) that need to work across multiple platforms (Windows, Mac, Linux).
  - Example: In a graphics library, shapes (Circle, Rectangle) can be drawn using different rendering APIs (OpenGL, DirectX) without creating a subclass for every combination.
- **Strategy Pattern:**
  - Use when you need to swap algorithms or behaviors dynamically, such as different sorting strategies (QuickSort, MergeSort) or payment methods (Credit Card, UPI, PayPal) in a checkout process.
  - Example: In a navigation app, the route calculation can use different strategies (fastest, shortest, scenic) based on user preference, without changing the navigation logic itself.

**Summary:**
- Bridge is about separating structure (what you do vs. how you do it) to avoid class explosion and enable independent evolution.
- Strategy is about encapsulating interchangeable behaviors to allow dynamic selection and easy extension of algorithms.

---

## 5. Real World Use Case
**Example:**
- **Car and Engine**: Different car types (Sedan, SUV) can work with different engines (Petrol, Diesel, Electric) without creating a subclass for every combination.
- **UI Toolkits**: Abstract UI elements (like Button, Window) can work with different OS-specific implementations (Windows, Mac, Linux).

---

## 6. Code Example (Java)
```java
// Implementation Hierarchy
interface Engine { void start(); }
class PetrolEngine implements Engine { ... }
class DieselEngine implements Engine { ... }
class ElectricEngine implements Engine { ... }

// Abstraction Hierarchy
abstract class Car {
    protected Engine engine;
    public Car(Engine e) { this.engine = e; }
    public abstract void drive();
}
class Sedan extends Car { ... }
class SUV extends Car { ... }

// Usage
Car mySedan = new Sedan(new PetrolEngine());
Car mySUV = new SUV(new ElectricEngine());
mySedan.drive();
mySUV.drive();
```
**Key Takeaway:**
- You can add new types of Cars or Engines independently, without modifying existing code.

---

## 7. Summary for Interviews
- Bridge Pattern is about **decoupling abstraction from implementation**.
- Use when you have multiple dimensions of change.
- Promotes flexibility, scalability, and clean code.
- Common in frameworks, UI libraries, and systems with pluggable components.
