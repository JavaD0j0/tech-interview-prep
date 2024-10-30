# Java Questions

## Basic

1. What is object-oriented programming (OOP) in Java, and how are its principles applied?

    - OOP is a programming paradigm based on the concept of "objects" that contain data and methods. Java is an OOP language, and its core principles are:
        - Encapsulation: Bundling data (fields) and methods that operate on the data into a single unit, or class. Example: A class `Car` encapsulates `speed` and `drive()` methods.
        - Inheritance: Allows a class to inherit properties and methods from another class. Example: A class `SportsCar` can inherit from `Car`.
        - Polymorphism: Allows one interface to be used for a general class of actions. Example: A `Car` object can refer to both `SportsCar` and `SUV`.
        - Abstraction: Hiding the implementation details from the user. Abstract classes and interfaces are used for abstraction.

2. Explain the role of the JVM (Java Virtual Machine), JRE (Java Runtime Environment), and JDK (Java Development Kit).

    - JVM: The engine that runs Java bytecode. It is platform-independent, allowing Java to be "write once, run anywhere."
    - JRE: Contains JVM and libraries needed to run Java applications.
    - JDK: The development kit that includes JRE, tools like the compiler (`javac`), and libraries for developing Java applications.

3. What is Garbage Collection in Java, and how does it work?

    - Garbage Collection (GC) automatically manages memory by reclaiming unused objects to prevent memory leaks. The JVM uses algorithms like Mark and Sweep or Generational GC to identify and remove objects that are no longer referenced.

4. How do you handle exceptions in Java? What are the differences between checked and unchecked exceptions?

    - Checked exceptions (like `IOException`) are checked at compile-time and must be either caught or declared to be thrown. Unchecked exceptions (like `NullPointerException`) are checked at runtime, typically arising from logic errors.
    - Use `try`, `catch`, `finally`, and throw to handle exceptions in Java.

5. What is an interface in Java, and how is it different from an abstract class?

    - Interface: A contract that defines methods without implementation. Classes that implement interfaces must provide method bodies.
    - Abstract class: Can have both abstract methods (without implementation) and concrete methods (with implementation). Abstract classes are used when classes share a base behavior, but you want to enforce method implementation in child classes.

6. Explain the concept of inheritance in Java. How does it work, and what are its limitations?

    - Inheritance: One class inherits properties and behaviors (methods) from another class using the `extends` keyword. For example, class `Dog extends Animal`.
        - Limitation: Java only supports single inheritance (a class can inherit from only one superclass), but multiple inheritance is possible with interfaces.

7. What is the difference between method overloading and method overriding in Java?

    - Overloading: Same method name but different parameters (within the same class).
    - Overriding: A method in a child class with the same signature as a method in the parent class. Overriding allows for runtime polymorphism.

8. What are lambda expressions, and how are they used in Java 8 and beyond?

    - Lambda expressions provide a concise way to represent instances of functional interfaces (interfaces with a single abstract method). Syntax: `(parameters) -> expression. Example: Comparator<String> comp = (a, b) -> a.compareTo(b);`

9. Explain the Stream API introduced in Java 8. How do streams help in processing collections of data?

    - Stream API allows for functional-style operations on collections like filtering, mapping, and reducing data. It supports operations like `map()`, `filter()`, `collect()`, and `reduce()` which can be performed sequentially or in parallel.

10. How does synchronization work in Java? How do you use the synchronized keyword?

    - Synchronization ensures that only one thread accesses a block of code at a time. The `synchronized` keyword can be applied to methods or blocks to avoid thread interference. Example: `public synchronized void syncMethod() { /* code */ }`

11. What is the purpose of the volatile keyword in Java? How does it impact memory visibility in multithreading?

    - `volatile` ensures that the value of a variable is always read from and written to the main memory. It guarantees visibility of changes to variables across threads, avoiding caching issues.

12. What is a Thread in Java? How do you create and manage threads?

    - A Thread is a lightweight process in Java. Threads can be created by either:
        1. Extending the `Thread` class and overriding its `run()` method.
        2. Implementing the `Runnable` interface and passing it to a `Thread` object. Example: `Thread t = new Thread(new MyRunnable()); t.start();`

13. Explain the difference between HashMap, LinkedHashMap, and TreeMap in the Java Collections Framework.

    - HashMap: Stores key-value pairs with no ordering.
    - LinkedHashMap: Stores key-value pairs with insertion order preserved.
    - TreeMap: Stores key-value pairs in a sorted (natural or comparator) order.

14. What are generics in Java, and how do they improve code safety and reusability?

    - Generics allow you to create classes, interfaces, and methods with type parameters, enabling code reuse and type safety. Example: `List<String> list = new ArrayList<>();`

15. What is a singleton class, and how do you implement it in Java?

    - Singleton ensures that a class has only one instance and provides global access to that instance. Example:

    ```java
    public class Singleton {
        private static Singleton instance;
        private Singleton() {}
        public static Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    }
    ```

16. How does Java memory management work, especially in relation to the heap and stack memory?

    - Heap memory is used for dynamic allocation of objects. The stack is used for storing local variables and method calls. The Garbage Collector reclaims unused objects in the heap.

17. What are annotations in Java, and how are they used in frameworks such as Spring?

    - Annotations provide metadata about the code. In Spring, annotations like `@Autowired`, `@Controller`, and `@Service` are used to configure beans and wire dependencies.

18. What is the difference between `==` and `equals()` when comparing objects in Java?

    - `==` checks for reference equality (if two references point to the same object).
    - `equals()` checks for content equality (if two objects have the same content).

19. Explain the concept of immutability in Java. Why is the String class immutable?

    - Immutable objects cannot be modified after creation. String is immutable to ensure thread safety, caching, and performance optimization (string pool).

20. How do Inner Classes work in Java? What are the differences between static and non-static inner classes?

    - Non-static inner classes (aka member inner classes) are tied to an instance of the outer class, whereas static inner classes are independent of the outer class instance.

21. What is a Java Reflection API, and when would you use it?

    - Reflection API allows inspection of classes, methods, and fields at runtime. It’s used for frameworks, debugging, and testing, but can bypass normal security checks.

22. Explain the purpose of the transient keyword in Java.

    - transient marks fields that should not be serialized during object serialization.

23. What is Java Serialization, and how does it work? What is the role of the serialVersionUID?

    - Serialization is converting an object into a byte stream. `serialVersionUID` ensures that the object maintains compatibility during deserialization even after class changes.

24. How do functional interfaces work in Java, and what are some common functional interfaces available in the `java.util.function` package?

    - A functional interface has a single abstract method. Common examples are `Predicate<T>`, `Function<T, R>`, `Consumer<T>`, and `Supplier<T>`.

25. What is a ConcurrentHashMap in Java, and how does it differ from HashMap in terms of thread safety?

    - `ConcurrentHashMap` allows concurrent access to its segments without locking the entire map. `HashMap` is not thread-safe and must be externally synchronized in multi-threaded environments.

## Advanced

1. Java Memory Model and Garbage Collection Tuning

    - Java Memory Model (JMM): JMM defines how threads in Java interact through memory, detailing how changes made by one thread become visible to other threads. The model specifies happens-before relationships to ensure visibility and ordering of variables across threads, crucial for correct multithreaded code.

    - Garbage Collectors:
        - Serial GC: Best for single-threaded applications and small heap sizes. It uses a single thread for garbage collection, making it simple but not ideal for high-throughput applications.
        - Parallel GC: Also called "Throughput Collector." It uses multiple threads for GC and is suitable for high-throughput applications with larger heaps.
        - CMS (Concurrent Mark-Sweep) GC: Aims for low-latency applications by performing part of the collection concurrently with application threads. However, CMS has high memory overhead.
        - G1 (Garbage First) GC: Designed for both low-latency and large heap applications, G1 divides the heap into regions and prioritizes garbage collection in regions with the most garbage, balancing both throughput and low-latency needs.

    - Optimizing Garbage Collection:
        - Set GC algorithms based on application requirements: `-XX:+UseG1GC` for G1, for example.
        - Tune heap sizes with `-Xms` and `-Xmx` options.
        - Analyze GC logs with tools like GCViewer or GCeasy to identify bottlenecks and adjust settings.

2. Java 8+ Features

    - Optional Class: Avoids `NullPointerException` by providing a container object that may or may not contain a non-null value. It offers methods like `ifPresent()`, `orElse()`, and `map()` for safe access and transformation of values.

    - Streams and Lazy Evaluation: Java Streams process data in a functional style. Lazy evaluation means intermediate operations (e.g., `filter()`, `map()`) are only executed when a terminal operation (like `collect()` or `forEach()`) is invoked. This improves performance as it processes only necessary data.

    - Default Methods in Interfaces: Introduced to allow adding new methods to interfaces without breaking existing implementations. They provide a method body in the interface and are useful for backward compatibility.

    - Concurrency Enhancements: Java 8 added CompletableFuture for handling asynchronous tasks and improvements to the `java.util.concurrent` package, like `ConcurrentHashMap` enhancements, making concurrency easier to manage and more scalable.

3. Java Design Patterns

    - Singleton: Ensures a class has only one instance, often implemented using private constructors and a static `getInstance()` method.

    - Factory: Creates objects without specifying the exact class to be created, useful for managing and centralizing object creation logic.

    - Builder: Simplifies complex object construction by providing a step-by-step construction approach, especially useful when an object has many attributes.

    - Observer: Allows an object (subject) to notify other objects (observers) when its state changes, often used in event handling.

    - Strategy: Defines a family of algorithms, encapsulates each one, and allows them to be interchangeable. It’s useful for scenarios where multiple algorithms are required for a single task, like sorting.

4. JVM Internals and Optimization

    - Just-In-Time (JIT) Compiler: The JIT compiler translates bytecode into native machine code at runtime. By optimizing frequently executed code (hot spots), JIT improves application performance.

    - Bytecode and Bytecode Verifier: Java code is compiled into bytecode, a platform-independent representation run by the JVM. The bytecode verifier checks bytecode correctness to ensure it adheres to JVM rules, enhancing security and stability.

    - Performance Optimization:
        Profiling tools like VisualVM or YourKit help identify performance bottlenecks.
        JVM options like `-XX:+PrintGCDetails` provide insights into memory usage and garbage collection for fine-tuning performance.
        HotSpot JVM’s adaptive optimization leverages runtime profiling to optimize code execution paths based on actual usage.

5. Data Structures and Collections Framework

    - ArrayList vs. LinkedList: `ArrayList` is faster for random access, but `LinkedList` is more efficient for frequent inserts and deletions as it doesn’t require shifting elements.

    - HashSet, LinkedHashSet, TreeSet:
        HashSet: Unordered, with no guaranteed iteration order.
        LinkedHashSet: Maintains insertion order, useful when order matters.
        TreeSet: Sorted order, implemented as a Red-Black tree, ideal for ordered data.

    - WeakHashMap: Holds keys with weak references, meaning they can be garbage-collected when no longer in use. Useful for caches, as it allows automatic cleanup of unused objects.

    - Best Practices:
        Choose the right collection based on requirements (e.g., `TreeMap` for sorted data).
        Minimize resizing overhead by specifying initial capacities when possible.
        Use unmodifiable wrappers (`Collections.unmodifiableList`) to enforce immutability.

6. Serialization and Externalization

    - Serializable vs. Externalizable:
        Serializable: Marker interface where fields are automatically serialized.
        Externalizable: Provides more control by allowing developers to define custom serialization logic, useful for performance tuning.

    - Preventing Sensitive Data Serialization: Mark fields `transient` or implement custom serialization with `writeObject` and `readObject` methods to control what is serialized.

    - Serialization Pitfalls:
        Large serialized data sizes can degrade performance.
        Versioning issues may arise if classes evolve after serialization (use `serialVersionUID` for consistency).

7. Testing in Java

    - JUnit and Mockito: JUnit provides a framework for writing unit tests, while Mockito allows mocking objects to isolate units being tested.
        - Example: `@Mock` creates mock objects, `@InjectMocks` injects mocks into a test subject.

    - Parameterized Tests: Allow running the same test with different data inputs. This is useful for testing various scenarios efficiently.

    - Integration Testing vs. Unit Testing:
        - Unit Testing focuses on individual methods or classes in isolation.
        - Integration Testing ensures that different components work together as expected, often involving a larger scope, such as database interactions or external services.

8. Functional and Reactive Programming in Java

    - Reactive Programming: Reactive programming focuses on asynchronous data streams and is ideal for handling real-time updates and backpressure. It contrasts with traditional blocking calls by using callbacks and promises for non-blocking execution.

    - Flow API: Introduced in Java 9, the `Flow` API supports reactive programming patterns. It provides four core interfaces — `Publisher`, `Subscriber`, `Subscription`, and `Processor` — to define data flows and backpressure handling.

    - Reactive Streams vs. CompletableFuture:
        Reactive Streams: Focus on processing large, asynchronous streams of data.
        CompletableFuture: Used for handling single asynchronous computations, ideal for scenarios where you need to chain actions or handle potential failures in a pipeline-like way.
