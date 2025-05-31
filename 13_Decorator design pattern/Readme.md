# 🎮 Decorator Design Pattern - My LLD Notes

## What is the Decorator Pattern? 🤔

Think of the Decorator Pattern like adding toppings to your pizza! 🍕 Instead of creating a new pizza class for every possible combination of toppings, you can dynamically add or remove toppings to your base pizza. 

In technical terms, the Decorator Pattern allows you to attach additional responsibilities to objects dynamically without modifying their existing code. It's like wrapping an object with new behaviors at runtime!

## Why Use Decorator Pattern? 🎯

1. **Open for Extension, Closed for Modification**: Follows the Open-Closed Principle perfectly
2. **Dynamic Behavior Addition**: Add or remove behaviors at runtime
3. **Single Responsibility**: Each decorator class has one specific job
4. **Flexibility**: Combine behaviors in any order you want
5. **No Class Explosion**: Avoid creating too many subclasses

## When to Use It? ⏰

- When you need to add responsibilities to individual objects dynamically
- When you want to add/remove responsibilities without affecting other objects
- When extension by subclassing is impractical (too many combinations)
- When you need to add behavior that can be withdrawn

## Decorator vs Inheritance 🥊

| Inheritance | Decorator |
|------------|-----------|
| Static relationship | Dynamic relationship |
| Determined at compile time | Determined at runtime |
| Can't remove behavior | Can add/remove behavior |
| Creates new classes | Wraps existing objects |
| Can lead to class explosion | More flexible and maintainable |

## Hands-on Example: Super Mario Power-ups! 🍄

Let's implement the Decorator Pattern using everyone's favorite plumber - Mario! We'll show how different power-ups can be added to Mario's base abilities.

```java
// Base Component
public interface Mario {
    String getDescription();
    int getAttackPower();
}

// Concrete Component
public class BasicMario implements Mario {
    @Override
    public String getDescription() {
        return "Basic Mario";
    }
    
    @Override
    public int getAttackPower() {
        return 10;
    }
}

// Base Decorator
public abstract class MarioDecorator implements Mario {
    protected Mario mario;
    
    public MarioDecorator(Mario mario) {
        this.mario = mario;
    }
    
    @Override
    public String getDescription() {
        return mario.getDescription();
    }
    
    @Override
    public int getAttackPower() {
        return mario.getAttackPower();
    }
}

// Concrete Decorators
public class FireFlowerDecorator extends MarioDecorator {
    public FireFlowerDecorator(Mario mario) {
        super(mario);
    }
    
    @Override
    public String getDescription() {
        return mario.getDescription() + " with Fire Flower";
    }
    
    @Override
    public int getAttackPower() {
        return mario.getAttackPower() + 20;
    }
}

public class SuperMushroomDecorator extends MarioDecorator {
    public SuperMushroomDecorator(Mario mario) {
        super(mario);
    }
    
    @Override
    public String getDescription() {
        return mario.getDescription() + " with Super Mushroom";
    }
    
    @Override
    public int getAttackPower() {
        return mario.getAttackPower() + 15;
    }
}

// Usage Example
public class MarioGame {
    public static void main(String[] args) {
        // Start with basic Mario
        Mario mario = new BasicMario();
        System.out.println(mario.getDescription() + " - Attack Power: " + mario.getAttackPower());
        
        // Add Fire Flower power-up
        mario = new FireFlowerDecorator(mario);
        System.out.println(mario.getDescription() + " - Attack Power: " + mario.getAttackPower());
        
        // Add Super Mushroom power-up
        mario = new SuperMushroomDecorator(mario);
        System.out.println(mario.getDescription() + " - Attack Power: " + mario.getAttackPower());
    }
}
```

### Output:
```
Basic Mario - Attack Power: 10
Basic Mario with Fire Flower - Attack Power: 30
Basic Mario with Fire Flower with Super Mushroom - Attack Power: 45
```

## Key Takeaways 📝

1. Decorator Pattern is like a wrapper that adds new behaviors to objects
2. It's more flexible than inheritance
3. Each decorator class has a single responsibility
4. Decorators can be combined in any order
5. The pattern follows the Open-Closed Principle

## Real-world Applications 🌍

- Java I/O streams (InputStream, OutputStream)
- GUI toolkits
- Logging frameworks
- Web servers middleware
- Game development (like our Mario example!)