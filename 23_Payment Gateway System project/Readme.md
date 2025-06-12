# Payment Gateway System

A robust and extensible payment gateway system that demonstrates the implementation of various design patterns and SOLID principles in Java. This project simulates a real-world payment processing system with support for multiple payment gateways.

## Project Overview

This payment gateway system provides a unified interface for processing payments through different payment gateways (Paytm and Razorpay). It implements a flexible architecture that allows easy addition of new payment gateways while maintaining a consistent interface for clients.

## Key Features

- Support for multiple payment gateways (Paytm and Razorpay)
- Unified payment processing interface
- Automatic retry mechanism for failed payments
- Payment validation and confirmation flow
- Simulated banking system integration
- Currency support (INR, USD)

## Design Patterns Implemented

1. **Template Method Pattern**
   - Abstract `PaymentGateway` class defines the skeleton of the payment processing algorithm
   - Concrete implementations (`PaytmGateway`, `RazorpayGateway`) provide specific implementations for validation, initiation, and confirmation steps

2. **Strategy Pattern**
   - `BankingSystem` interface and its implementations (`PaytmBankingSystem`, `RazorpayBankingSystem`)
   - Allows switching between different banking system implementations at runtime

3. **Proxy Pattern**
   - `PaymentGatewayProxy` adds retry functionality to payment gateways
   - Provides additional behavior (retry logic) without modifying the original gateway classes

4. **Singleton Pattern**
   - Implemented in `GatewayFactory`, `PaymentService`, and `PaymentController`
   - Ensures single instance of critical services throughout the application

5. **Factory Pattern**
   - `GatewayFactory` creates appropriate payment gateway instances
   - Encapsulates gateway creation logic and provides a unified interface

## System Architecture

### Core Components

1. **PaymentRequest**
   - Data structure containing payment details (sender, receiver, amount, currency)

2. **PaymentGateway (Abstract)**
   - Defines the template method for payment processing
   - Abstract methods for validation, initiation, and confirmation

3. **Concrete Gateways**
   - `PaytmGateway`: Implements Paytm-specific payment processing
   - `RazorpayGateway`: Implements Razorpay-specific payment processing

4. **BankingSystem**
   - Interface for different banking system implementations
   - Simulated success rates for payment processing

5. **PaymentService**
   - Singleton service providing a unified interface for payment processing
   - Manages the current payment gateway

6. **PaymentController**
   - Entry point for client applications
   - Handles gateway selection and payment processing

## Usage Example

```java
// Create a payment request
PaymentRequest request = new PaymentRequest("Sender", "Receiver", 1000.0, "INR");

// Process payment through Paytm
boolean result = PaymentController.getInstance()
    .handlePayment(GatewayType.PAYTM, request);

// Process payment through Razorpay
boolean result = PaymentController.getInstance()
    .handlePayment(GatewayType.RAZORPAY, request);
```

## Design Principles

1. **Single Responsibility Principle**
   - Each class has a single, well-defined responsibility
   - Separation of concerns between payment processing, validation, and banking systems

2. **Open/Closed Principle**
   - System is open for extension (new payment gateways) but closed for modification
   - New gateways can be added without modifying existing code

3. **Interface Segregation**
   - Clean interfaces for different components
   - Clients only depend on the interfaces they use

4. **Dependency Inversion**
   - High-level modules depend on abstractions
   - Payment processing depends on `PaymentGateway` interface, not concrete implementations

## Error Handling

- Payment validation before processing
- Automatic retry mechanism for failed payments
- Different retry policies for different gateways
- Detailed logging of payment processing steps

## Future Enhancements

1. Support for more payment gateways
2. Real banking system integration
3. Transaction logging and monitoring
4. Support for more currencies
5. Payment status tracking
6. Refund processing
7. Payment analytics and reporting


## Note

This is a simulation project for learning purposes. The banking system implementations use random success rates to simulate real-world scenarios. In a production environment, these would be replaced with actual banking system integrations.
