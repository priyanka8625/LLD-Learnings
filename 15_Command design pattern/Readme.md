# 🎮 Command Design Pattern

## 🎯 Introduction
The Command Design Pattern is a behavioral design pattern that turns a request into a stand-alone object containing all information about the request. This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.

## 💡 What is Command Pattern?
### Definition
- A behavioral design pattern that encapsulates a request as an object
- Converts a request into a stand-alone object containing all information about the request
- Allows parameterization of clients with different requests
- Enables queuing, logging, and undo operations

### Key Characteristics
1. **Encapsulation**: Each command is a separate object
2. **Decoupling**: Separates the requester from the receiver
3. **Extensibility**: Easy to add new commands without changing existing code
4. **Reusability**: Commands can be reused across different parts of the application

## 🎯 Why Use Command Pattern?
### Problems it Solves
1. **Tight Coupling**: When the requester directly calls the receiver's methods
2. **Inflexible Code**: When adding new operations requires changing existing code
3. **Complex Operations**: When operations need to be queued, logged, or undone
4. **Parameterization**: When you need to parameterize objects with operations

### Benefits
1. **Single Responsibility Principle**: Each command class handles one specific operation
2. **Open/Closed Principle**: New commands can be added without modifying existing code
3. **Undo/Redo Operations**: Easy to implement command history
4. **Command Queuing**: Operations can be queued and executed in order
5. **Logging and Auditing**: Commands can be logged for debugging or auditing

## 🏗️ Core Concepts

### 1. Command Interface
```java
interface Command {
    void execute();
    void undo();
}
```
- **Purpose**: Defines the contract for all concrete commands
- **Key Methods**:
  - `execute()`: Performs the command's action
  - `undo()`: Reverses the command's action
- **Why Interface?**: Allows different commands to be treated uniformly

### 2. Concrete Commands
```java
class LightCommand implements Command {
    private Light light;  // Receiver

    public LightCommand(Light l) {
        this.light = l;
    }

    public void execute() {
        light.on();
    }

    public void undo() {
        light.off();
    }
}
```
- **Purpose**: Implements specific commands
- **Components**:
  - Receiver reference
  - Constructor to set receiver
  - Implementation of execute() and undo()
- **Key Point**: Each command knows how to perform its specific operation

### 3. Receiver (Smart Devices)
```java
class Light {
    public void on()  { System.out.println("Light is ON"); }
    public void off() { System.out.println("Light is OFF"); }
}
```
- **Purpose**: Knows how to perform the actual work
- **Characteristics**:
  - Contains the actual business logic
  - Independent of command implementation
  - Can be any class that performs actions

### 4. Invoker (Remote Controller)
```java
class RemoteController {
    private Command[] buttons;
    private boolean[] buttonPressed;

    public void setCommand(int idx, Command cmd) {
        buttons[idx] = cmd;
    }

    public void pressButton(int idx) {
        if (!buttonPressed[idx]) {
            buttons[idx].execute();
        } else {
            buttons[idx].undo();
        }
        buttonPressed[idx] = !buttonPressed[idx];
    }
}
```
- **Purpose**: Asks the command to execute the request
- **Responsibilities**:
  - Stores commands
  - Executes commands
  - Manages command history
  - Handles undo/redo operations

## 📐 Pattern Structure
```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   Client    │     │  Invoker    │     │  Command    │
│             │────▶│  (Remote)   │────▶│  Interface  │
└─────────────┘     └─────────────┘     └─────────────┘
                           │                   ▲
                           │                   │
                           │                   │
                    ┌─────────────┐     ┌─────────────┐
                    │  Concrete   │     │  Receiver   │
                    │  Commands   │────▶│  (Devices)  │
                    └─────────────┘     └─────────────┘
```

### Component Relationships
1. **Client** → **Invoker**: Client configures the invoker with commands
2. **Invoker** → **Command**: Invoker calls command's execute() method
3. **Command** → **Receiver**: Command knows which receiver to use
4. **Concrete Command** → **Command Interface**: Implements the command contract

## ⚡ Advanced Concepts

### 1. Macro Commands
```java
class MacroCommand implements Command {
    private List<Command> commands;
    
    public void execute() {
        for(Command cmd : commands) {
            cmd.execute();
        }
    }
    
    public void undo() {
        for(Command cmd : commands) {
            cmd.undo();
        }
    }
}
```
- Combines multiple commands into one
- Useful for complex operations
- Supports both execute and undo

### 2. Command History
- Store executed commands in a stack
- Implement undo/redo functionality
- Useful for implementing undo/redo in applications

### 3. Command Queuing
- Store commands in a queue
- Execute commands in order
- Useful for batch processing

## ❓ Common Interview Questions

### 1. What is the Command Pattern?
- A behavioral design pattern that encapsulates a request as an object
- Allows parameterization of clients with different requests
- Supports undoable operations

### 2. When to Use Command Pattern?
- When you need to parameterize objects with operations
- When you need to queue operations
- When you need to support undo/redo
- When you need to log operations

### 3. What are the Components of Command Pattern?
- Command Interface
- Concrete Commands
- Receiver
- Invoker
- Client

### 4. What are the Advantages?
- Decouples requester from receiver
- Supports undo/redo operations
- Easy to extend with new commands
- Supports command queuing and logging

## 📋 Quick Reference
- **Pattern Type**: Behavioral
- **Use Case**: When you need to parameterize objects with operations
- **Key Components**: Command, ConcreteCommand, Receiver, Invoker
- **Main Benefits**: Decoupling, Extensibility, Undo/Redo support
- **Complexity**: Medium
- **Popularity**: High
