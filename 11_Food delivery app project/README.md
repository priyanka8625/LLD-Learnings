# 🍅 Tomato - Food Delivery App (LLD Practice Project)

A Java-based food delivery application implementing various design patterns and SOLID principles. This project serves as a practical implementation of Low-Level Design concepts, demonstrating how to structure a real-world application using object-oriented design principles.

## 🚀 Features

### 1. Restaurant & Menu Management
- **Restaurant Registration**
  - Add restaurants with location
  - Manage restaurant details
  - Location-based restaurant search
  - Singleton pattern for restaurant management

- **Menu Management**
  - Add menu items with codes and prices
  - Restaurant-specific menus
  - Easy menu updates
  - Menu item validation

### 2. Cart System
- **Cart Operations**
  - Add items to cart
  - View cart contents
  - Calculate total cost
  - Restaurant-specific cart validation
  - Cart clearing after order

- **Cart Validation**
  - Restaurant selection check
  - Item availability validation
  - Price calculation
  - Cart state management

### 3. Order Management
- **Order Types**
  - Delivery orders
  - Pickup orders
  - Immediate orders
  - Scheduled orders

- **Order Processing**
  - Factory pattern for order creation
  - Order tracking
  - Order history management
  - Singleton pattern for order management

### 4. Payment System
- **Payment Methods**
  - UPI payments
  - Credit Card payments
  - Strategy pattern implementation
  - Easy to add new payment methods

- **Payment Processing**
  - Payment validation
  - Payment confirmation
  - Transaction management
  - Error handling

### 5. Notification Service
- **Order Notifications**
  - Order confirmation
  - Payment confirmation
  - Order status updates
  - Detailed order information

## 📱 Application Flow

### 1. Application Initialization
```java
// Main.java
TomatoApp tomato = new TomatoApp();  // Creates app instance
```
- Application starts by creating `TomatoApp` instance
- `TomatoApp` constructor initializes restaurants with their menus
- Sample restaurants are added:
  - Bikaner (Delhi) - Chole Bhature, Samosa
  - Haldiram (Kolkata) - Raj Kachori, Pav Bhaji, Dhokla
  - Saravana Bhavan (Chennai) - Masala Dosa, Idli Vada, Filter Coffee

### 2. User Flow
```java
// Main.java
User user = new User(101, "Priyanka", "Delhi");
```
1. **User Creation**
   - User is created with ID, name, and location
   - Each user gets a new cart instance

2. **Restaurant Search**
   ```java
   List<Restaurant> restaurantList = tomato.searchRestaurants("Delhi");
   ```
   - User searches restaurants by location
   - System returns matching restaurants
   - Location-based filtering using `RestaurantManager`

3. **Restaurant Selection**
   ```java
   tomato.selectRestaurant(user, restaurantList.get(0));
   ```
   - User selects a restaurant
   - Cart is associated with selected restaurant
   - Restaurant menu becomes available

4. **Cart Management**
   ```java
   tomato.addToCart(user, "P1");  // Adds item to cart
   tomato.printUserCart(user);    // Shows cart contents
   ```
   - User adds items using item codes
   - Cart validates restaurant selection
   - Cart maintains item list and calculates total

5. **Order Placement**
   ```java
   // For immediate order
   Order order = tomato.checkoutNow(user, "Delivery", 
       new UpiPaymentStrategy("1234567890"));

   // For scheduled order
   Order scheduledOrder = tomato.checkoutScheduled(user, "Pickup",
       new CreditCardPaymentStrategy("4111111111111111"), 
       "2024-03-20 19:00:00");
   ```
   - User chooses order type (Delivery/Pickup)
   - Selects payment method
   - Can choose immediate or scheduled order
   - Order is created using appropriate factory

6. **Payment Processing**
   ```java
   tomato.payForOrder(user, order);
   ```
   - Payment is processed using selected strategy
   - On successful payment:
     - Order is confirmed
     - Notification is sent
     - Cart is cleared

7. **Notification**
   ```java
   NotificationService.notify(order);
   ```
   - System sends order confirmation
   - Includes order details:
     - Order ID
     - Customer details
     - Restaurant details
     - Items ordered
     - Total amount
     - Scheduled time
     - Payment status

## 🎯 Design Patterns & Principles Implemented

### 1. SOLID Principles
- **Single Responsibility Principle (SRP)**
  - Each class has a single responsibility
  - `RestaurantManager` - Only manages restaurants
  - `OrderManager` - Only manages orders
  - `NotificationService` - Only handles notifications
  - `Cart` - Only manages cart operations

- **Open/Closed Principle (OCP)**
  - Payment system is open for extension (new payment methods) but closed for modification
  - Order types (Delivery/Pickup) can be extended without modifying existing code
  - New order factories can be added without changing the core order creation logic

- **Liskov Substitution Principle (LSP)**
  - `DeliveryOrder` and `PickupOrder` can be substituted for `Order` without breaking the application
  - Different payment strategies can be substituted without affecting the payment process

- **Interface Segregation Principle (ISP)**
  - `PaymentStrategy` interface is focused and minimal
  - `OrderFactory` interface contains only necessary methods

- **Dependency Inversion Principle (DIP)**
  - High-level modules depend on abstractions
  - `Order` depends on `PaymentStrategy` interface, not concrete implementations
  - `TomatoApp` uses factory interface for order creation

### 2. Design Patterns

#### Singleton Pattern
- Used in `RestaurantManager` and `OrderManager`
- Ensures single instance of managers throughout the application
- Provides global access point to restaurant and order data
- Thread-safe implementation with lazy initialization

#### Strategy Pattern
- Implemented for payment processing
- Allows runtime selection of payment methods
- Easy to add new payment strategies without modifying existing code
- Demonstrates polymorphism and interface-based programming

#### Factory Pattern
- Used for order creation
- Abstracts order creation logic
- Supports different order types (Now/Scheduled)
- Handles both delivery and pickup orders
- Demonstrates abstraction and encapsulation
