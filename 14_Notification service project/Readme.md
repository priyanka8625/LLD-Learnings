# 🚀 Notification Service System

A robust and flexible notification service system built using Java, demonstrating various design patterns and SOLID principles. This system provides a scalable way to send notifications through multiple channels while maintaining clean code architecture.

## 🌟 Features

- **Multiple Notification Channels**
  - Email notifications
  - SMS notifications
  - Pop-up notifications
  - Extensible for new notification types

- **Rich Notification Content**
  - Basic text notifications
  - Timestamped notifications
  - Signed notifications
  - Decorated notifications with multiple attributes

- **Real-time Notification Logging**
  - Automatic logging of all notifications
  - Timestamp tracking
  - Content persistence

- **Plug-and-Play Architecture**
  - Easy integration with any Java application
  - Simple to add new notification types and channels
  - No modification needed to existing code when adding new features
  - Hot-swappable notification strategies (change notification delivery methods at runtime)
  - Minimal setup required to start using the service

## 🎯 Design Patterns Implemented

### 1. Singleton Pattern
- `NotificationService` is implemented as a singleton to ensure a single point of control for notification management
- Guarantees consistent notification handling across the application

### 2. Observer Pattern
- Implements a publisher-subscriber model for notification distribution
- Components:
  - `IObserver` interface
  - `IObservable` interface
  - `NotificationObservable` concrete implementation
  - Concrete observers: `Logger` and `NotificationEngine`

### 3. Decorator Pattern
- Used for enhancing notification content
- Components:
  - `INotification` interface
  - `SimpleNotification` concrete implementation
  - `INotificationDecorator` abstract decorator
  - Concrete decorators: `TimestampDecorator` and `SignatureDecorator`

### 4. Strategy Pattern
- Implements different notification delivery strategies
- Components:
  - `INotificationStrategy` interface
  - Concrete strategies: `EmailStrategy`, `SMSStrategy`, and `PopUpStrategy`
  - Allows easy addition of new notification delivery methods

## 📋 System Architecture

```
NotificationService (Singleton)
├── NotificationObservable
│   ├── Logger (Observer)
│   └── NotificationEngine (Observer)
│       ├── EmailStrategy
│       ├── SMSStrategy
│       └── PopUpStrategy
└── Notifications
    ├── SimpleNotification
    ├── TimestampDecorator
    └── SignatureDecorator
```

## 💡 Key Benefits

1. **Extensibility**: Easy to add new notification types and delivery channels
2. **Maintainability**: Clean separation of concerns through design patterns
3. **Flexibility**: Multiple ways to enhance and deliver notifications
4. **Reliability**: Centralized notification management
5. **Scalability**: Easy to add new features without modifying existing code

## 🛠️ Usage Example

```java
// Get notification service instance
NotificationService service = NotificationService.getInstance();

// Create and send a decorated notification
INotification notification = new SignatureDecorator(
    new TimestampDecorator(
        new SimpleNotification("Hello, World!")
    ),
    "System Admin"
);
service.sendNotification(notification);
```

## 📝 Note

This implementation is part of a Low Level Design (LLD) course project, demonstrating practical application of design patterns and SOLID principles in a real-world scenario.
