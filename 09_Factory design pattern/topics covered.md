# Factory Design Pattern - Topics Covered

## Real-life Relatable Examples
1. **Simple Factory Pattern**
   - Restaurant ordering system where a single kitchen (factory) prepares different types of burgers
   - Example from code: `BurgerFactory` creating different types of burgers (Basic, Standard, Premium)
   - Similar to a fast-food restaurant's kitchen that can prepare various menu items

2. **Factory Method Pattern**
   - Different restaurant chains (factories) creating their own versions of burgers
   - Example from code: `SinghBurger` and `KingBurger` factories creating their specific burger variants
   - Similar to how McDonald's and Burger King have their own ways of making burgers

3. **Abstract Factory Pattern**
   - Complete meal system where different restaurant chains create their own versions of multiple food items
   - Example from code: `MealFactory` creating both burgers and garlic bread with different variants
   - Similar to how different restaurant chains offer their own complete meal combos

## Standard UML Diagrams
1. **Simple Factory Pattern**
   ```
   Client ---> Factory ---> Product
                    |
                    v
              Concrete Products
   ```

2. **Factory Method Pattern**
   ```
   Factory (Interface) ---> Product (Interface)
         |                      |
         v                      v
   Concrete Factory    Concrete Products
   ```

3. **Abstract Factory Pattern**
   ```
   Abstract Factory ---> Abstract Product A
         |                    |
         |                    v
         |             Concrete Products A
         |
         v
   Abstract Product B
         |
         v
   Concrete Products B
   ```

## Clean Java Code Implementations
1. **Simple Factory Pattern** (`SimpleFactory.java`)
   - Single factory class (`BurgerFactory`) creating different types of burgers
   - Simple if-else logic for object creation
   - Easy to understand and implement for simple scenarios

2. **Factory Method Pattern** (`FactoryMethod.java`)
   - Factory interface (`BurgerFactory`) with concrete implementations
   - Each concrete factory (`SinghBurger`, `KingBurger`) creates its own burger variants
   - Follows Open-Closed Principle for adding new burger types

3. **Abstract Factory Pattern** (`AbstractFactory.java`)
   - Abstract factory interface (`MealFactory`) creating multiple product families
   - Concrete factories (`SinghBurger`, `KingBurger`) creating complete meal sets
   - Handles multiple related product families (burgers and garlic bread)

## Differences Between Each Factory Pattern
1. **Simple Factory vs Factory Method**
   - Simple Factory: Single factory class, no inheritance
   - Factory Method: Factory interface with multiple implementations
   - Factory Method is more flexible and follows OCP better

2. **Factory Method vs Abstract Factory**
   - Factory Method: Creates one type of product
   - Abstract Factory: Creates multiple related products
   - Abstract Factory is more complex but handles product families

3. **Simple Factory vs Abstract Factory**
   - Simple Factory: Single responsibility, one product type
   - Abstract Factory: Multiple responsibilities, multiple product types
   - Abstract Factory is more scalable for complex systems

## When and Where to Use Each Type
1. **Simple Factory Pattern**
   - When object creation logic is simple
   - When there's only one type of product
   - Example: Basic restaurant ordering system
   - Use case from code: Creating different types of burgers in a single kitchen

2. **Factory Method Pattern**
   - When you need different ways to create the same product
   - When you want to delegate object creation to subclasses
   - Example: Different restaurant chains with their own burger recipes
   - Use case from code: Different burger chains creating their own burger variants

3. **Abstract Factory Pattern**
   - When you need to create multiple related products
   - When you want to ensure products are compatible
   - Example: Complete meal systems in different restaurant chains
   - Use case from code: Creating both burgers and garlic bread in different restaurant chains

## Remember Note
> The Factory Design Pattern is like a restaurant's kitchen system. Simple Factory is like a single kitchen making different items, Factory Method is like different restaurant chains with their own kitchens, and Abstract Factory is like complete meal systems where each chain creates their own versions of multiple food items. Choose the pattern based on your system's complexity and the number of product types you need to create.

## Code References
- `SimpleFactory.java`: Demonstrates basic factory pattern with burger creation
- `FactoryMethod.java`: Shows how different burger chains create their own burger variants
- `AbstractFactory.java`: Implements a complete meal system with multiple product families 