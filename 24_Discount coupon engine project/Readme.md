# 🏷️ Discount Coupon Engine Project

Welcome to the **Discount Coupon Engine**! This project demonstrates how to design a flexible, extensible, and robust discount system for e-commerce using modern LLD (Low-Level Design) principles. It's packed with patterns and best practices that are interview favorites! 🚀

---

## 📚 Today's Learnings Recap

### 1️⃣ Strategy Pattern for Flexible Discounts
- **Implemented Discount Strategies:**
  - `FlatDiscountStrategy`: Fixed amount off
  - `PercentageDiscountStrategy`: Percentage off
  - `PercentageWithCapStrategy`: Percentage off, but capped at a maximum value
- **How?**
  - All strategies implement the `DiscountStrategy` interface.
  - Easily add new discount types without changing existing code.

### 2️⃣ Chain of Responsibility for Dynamic Coupon Application
- **Coupons as a Chain:**
  - Each `Coupon` can pass the cart to the next coupon in the chain.
  - Supports both combinable and non-combinable offers.
- **Result:**
  - Multiple offers can apply in sequence, or stop when a non-combinable coupon fires.

### 3️⃣ Singleton Pattern for Global Managers
- **Singletons Used:**
  - `DiscountStrategyManager`: Central place to get strategy instances.
  - `CouponManager`: Registers, lists, and applies coupons globally and thread-safely.

### 4️⃣ Step-by-Step System Composition
- **Core Classes:**
  - `Product`, `CartItem`, `Cart`: Represent the shopping cart and its items.
  - `Coupon` (abstract): Base for all coupon types (e.g., `SeasonalOffer`, `LoyaltyDiscount`, `BulkPurchaseDiscount`, `BankingCoupon`).
  - `CouponManager`: Registers coupons and applies them to carts.
- **How to Extend?**
  - Add new coupon types by subclassing `Coupon` and registering with `CouponManager`.

### 5️⃣ Sample Cart Walkthrough
- **See it in Action:**
  - The `main` method in `DiscountCoupon.java` creates a cart, adds products, sets loyalty/bank info, and applies all registered coupons.
  - Prints original vs. final totals and shows which promotions fired.

---

## 🗂️ Code Structure Reference

- **All code is in [`programs/DiscountCoupon.java`](./programs/DiscountCoupon.java):**
  - `DiscountStrategy` interface and its implementations
  - `DiscountStrategyManager` (Singleton)
  - `Product`, `CartItem`, `Cart`
  - `Coupon` (abstract) and concrete coupons:
    - `SeasonalOffer`, `LoyaltyDiscount`, `BulkPurchaseDiscount`, `BankingCoupon`
  - `CouponManager` (Singleton)
  - `DiscountCoupon` (main class with demo)

---

## 🛠️ How It Works (Code Snippets)

### Define a New Discount Strategy
```java
class BuyOneGetOneStrategy implements DiscountStrategy {
    public double calculate(double baseAmount) {
        // Custom logic here
    }
}
```

### Register Coupons in the Chain
```java
CouponManager mgr = CouponManager.getInstance();
mgr.registerCoupon(new SeasonalOffer(10, "Clothing"));
mgr.registerCoupon(new LoyaltyDiscount(5));
// ...
```

### Apply All Coupons to a Cart
```java
Cart cart = new Cart();
// Add products, set loyalty, set payment bank...
double finalTotal = mgr.applyAll(cart);
```

---

## 🧑‍💻 Interview-Ready Design Highlights
- **Open/Closed Principle:** Add new discounts/coupons without modifying existing logic.
- **Thread Safety:** Managers are singletons with locking for safe concurrent use.
- **Extensibility:** New strategies/coupons are plug-and-play.
- **Separation of Concerns:** Each class has a clear, single responsibility.

---

## 🛒 Example Output
```
Original Cart Total: 25000.0 Rs
Applicable Coupons:
 - Seasonal Offer 10% off Clothing
 - Loyalty Discount 5% off
 - Bulk Purchase Rs 100 off over 1000
 - ABC Bank Rs 15 off upto 500
Seasonal Offer 10% off Clothing applied: 300.0
Loyalty Discount 5% off applied: 1235.0
Bulk Purchase Rs 100 off over 1000 applied: 100.0
ABC Bank Rs 15 off upto 500 applied: 500.0
Final Cart Total after discounts: 22965.0 Rs
```

---

## 📝 How to Extend
- Add new strategies by implementing `DiscountStrategy`.
- Add new coupon types by subclassing `Coupon`.
- Register new coupons in `CouponManager`.

---

## 🤩 Why This Project Rocks for Interviews
- Demonstrates real-world use of **Strategy**, **Chain of Responsibility**, and **Singleton** patterns
- Shows how to build extensible, maintainable, and thread-safe systems
- Easy to explain, extend, and adapt to new requirements

---

## 📝 Remember
> **Always explain the design choices and patterns you used—interviewers love to hear your reasoning!**
>
> - Be ready to sketch the class diagram and flow.
> - Mention how you can add new coupons or strategies with zero changes to existing logic (Open/Closed Principle).
> - Talk about thread safety and why singletons are used for managers.
> - Show how the Chain of Responsibility lets you control the order and combination of offers.


---

