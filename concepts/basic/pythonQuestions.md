# Python Questions

## Basic

1. Python Fundamentals

    - Python Key Features: Python is dynamically typed, interpreted, and known for its simplicity and readability. It’s object-oriented, supports multiple paradigms, and has extensive libraries for a wide range of applications.
    - Python 2 vs. Python 3: Python 3 introduced many improvements over Python 2, such as better Unicode support, print function changes (`print()`), and different handling of integer division.
    - Dynamic Typing: Python does not require variable types to be declared explicitly; types are inferred at runtime, making code more flexible but sometimes harder to debug.

2. Data Types and Data Structures

    - Data Types: Basic types include `int`, `float`, `str`, `bool`, and container types like `list`, `tuple`, `set`, and `dict`.
    - List vs. Tuple: Lists are mutable, meaning their contents can be modified after creation, while tuples are immutable. Lists are better for sequences that change, and tuples are faster and used for fixed data.
    - Dictionaries and Sets: Dictionaries store key-value pairs and are optimized for fast lookups. Sets store unique elements and support operations like unions and intersections.

3. String Manipulation

    - String Operations: Concatenation can be done with `+`, splitting with `split()`, and formatting with `f-strings`, `str.format()`, or `%`.
    - f-strings: Introduced in Python 3.6, f-strings are the most efficient for embedding expressions in strings (e.g., `f"My name is {name}"`).
    - Reversing a String: Use slicing: `string[::-1]`.

4. Control Flow and Loops

    - If-elif-else: Python’s conditional statements control the flow of execution based on conditions.
    - For vs. While Loops: `for` loops iterate over sequences (like lists), while `while` loops continue until a condition is met.
    - List Comprehensions: A concise way to create lists (e.g., `[x**2 for x in range(5)]` creates `[0, 1, 4, 9, 16]`).

5. Functions and Scope

    - Functions: Defined with `def`, functions encapsulate reusable code blocks. They take arguments and can return values.
    - Global vs. Local Scope: Variables defined inside a function are local, while variables outside are global. Use `global` keyword to modify global variables within a function.
    - Default Parameters: Allow setting default values for function parameters (e.g., `def greet(name="Guest")`).

6. Lambda Functions and Map, Filter, Reduce

    - Lambda Functions: Anonymous functions created with `lambda` keyword, useful for short functions (e.g., `lambda x: x**2`).
    - map(): Applies a function to all items in an iterable (e.g., `map(lambda x: x**2, [1, 2, 3])`).
    - filter(): Filters items in an iterable based on a condition (e.g., `filter(lambda x: x > 0, [-1, 0, 1])`).
    - reduce(): Reduces an iterable to a single value, used with `functools.reduce`.

7. Error Handling

    - try-except-finally: Used to catch exceptions. `try` runs code that might raise an exception, `except` handles exceptions, and `finally` runs code regardless of exceptions.
    - raise: Explicitly raises an exception (e.g., `raise ValueError("Invalid value")`).
    - Common Exceptions: `TypeError` (wrong type), `ValueError` (invalid value), `IndexError` (invalid index).

8. File I/O

    - Reading/Writing Files: Use `open()` with modes like '`r`' (read), '`w`' (write), and '`a`' (append). `read()`, `readlines()`, `write()`, and `writelines()` help manipulate file content.
    - With Statement: `with open("file.txt") as file:` handles file closing automatically after the block.

9. Modules and Packages

    - Modules: Python files containing functions and classes, imported with `import` (e.g., `import math`).
    - `name == 'main'`: Used to determine if a script is being run directly or imported. Code within this block only runs if the script is executed directly.
    - Packages: Directories containing modules and an `__init__.py` file, allowing hierarchical structuring of modules.

10. Common Built-in Functions

    - len(), sum(), sorted(), range(): `len()` for length, `sum()` for summation, `sorted()` for sorting, `range()` for iterating over sequences.
    - any() and all(): `any()` checks if any element is `True`, `all()` checks if all elements are `True`.
    - zip(): Combines multiple iterables element-wise into tuples (e.g., `list(zip([1, 2], ['a', 'b'])) returns [(1, 'a'), (2, 'b')]`).

## Advanced

1. Object-Oriented Programming (OOP)

    - Classes and Objects: Classes in Python are blueprints for creating objects, with attributes and methods defined within them. An object is an instance of a class, containing data and behavior.

    ```python
    class Car:
        def __init__(self, brand, model):
            self.brand = brand
            self.model = model
    ```

    - OOP Principles:
        - Encapsulation: Restricting access to parts of an object’s data by using private variables (e.g., `_var` or `__var`).
        - Inheritance: Allows a class to inherit attributes and methods from another class, e.g., `class ElectricCar(Car)`:.
        - Polymorphism: Allows using a method in different ways. For instance, methods with the same name in different classes (`Animal.sound()` might be different in `Dog` and `Cat` classes).
        - Abstraction: Hides complex details and only shows the necessary parts, often implemented using abstract classes or interfaces (e.g., `abc.ABC` in Python).

    - self and init: `self` represents the instance of the class, and `__init__` is the constructor method that initializes the object’s attributes.

2. Special (Dunder) Methods

    - Dunder Methods: Also known as magic methods, they allow custom behavior for Python operators and built-in functions.
        - `__str__` and `__repr__`: `__str__` defines the human-readable representation of an object, while `__repr__` provides the official string representation.
        - `__add__`, `__sub_`_, etc.: Allow overloading operators. For example, ``__add__`` can make `a + b` work with custom objects.
        - `__len__`: Allows using `len()` with a class.
        - `__call__`: Makes an instance callable as a function.

    Example:

    ```python
    class Book:
        def __init__(self, title):
            self.title = title
        def __str__(self):
            return f"Book: {self.title}"
    ```

3. Decorators

    - Definition and Use: Decorators are functions that modify the behavior of another function or method. Commonly used for logging, enforcing access control, and instrumentation.

    ```python
    def my_decorator(func):
        def wrapper():
            print("Something is happening before the function.")
            func()
            print("Something is happening after the function.")
        return wrapper
    ```

    - Function vs. Class Decorators: Function decorators modify functions, while class decorators can modify or add functionality to classes.
        - Example: `@staticmethod` and `@classmethod` are function decorators, while `@dataclass` is a class decorator.

4. Generators and Iterators

    - Generators: Functions that use `yield` to produce a sequence of values lazily (one at a time), saving memory.

    ```python
    def count_up_to(n):
        i = 1
        while i <= n:
            yield i
            i += 1
    ```

    - Iterators: Objects that implement the `__iter__()` and `__next__()` methods. Generators are a simple way to create iterators, but custom iterators can be created by implementing these methods in classes.

5. Context Managers

    - Usage of `with` Statement: Context managers handle resource management, ensuring resources like files or network connections are properly closed after usage.
        Example:

    ```python
    with open('file.txt', 'r') as file:
        data = file.read()
    ```

- Custom Context Managers: Created by implementing `__enter__` and `__exit__` methods.

    ```python
    class MyContext:
        def __enter__(self):
            print("Entering context")
        def __exit__(self, exc_type, exc_value, traceback):
            print("Exiting context")
    ```

6. Comprehensions and Expressions

    - List Comprehensions: Concise way to create lists, often replacing `for` loops for a shorter, more readable syntax.

    ```python
    squares = [x**2 for x in range(10)]
    ```

- Dictionary and Set Comprehensions:

    ```python
    square_dict = {x: x**2 for x in range(10)}
    unique_set = {x for x in [1, 1, 2, 3]}
    ```

- Generator Expressions: Similar to list comprehensions but use parentheses `()` instead of square brackets, producing elements lazily.

    ```python
    lazy_squares = (x**2 for x in range(10))
    ```

7. Memory Management and Garbage Collection

    - Memory Management: Python uses automatic memory management and reference counting. When an object’s reference count drops to zero, it is garbage collected.

    - Reference Counting and Garbage Collection: The `gc` module provides control over garbage collection, including functions to enable or disable garbage collection.

    - gc Module: Used for debugging and fine-tuning memory management.

    ```python
    import gc
    gc.collect()
    ```

8. Multithreading and Multiprocessing

    - Global Interpreter Lock (GIL): A mutex that prevents multiple threads from executing Python bytecode simultaneously, limiting multithreading performance for CPU-bound tasks.

    - Multithreading vs. Multiprocessing:
        Multithreading: Ideal for I/O-bound tasks due to the GIL.
        Multiprocessing: Uses separate memory space for processes, avoiding GIL and being more suitable for CPU-bound tasks.

    ```python
    from multiprocessing import Process
    ```

- concurrent.futures: Provides high-level APIs for threading and multiprocessing.

    ```python
    from concurrent.futures import ThreadPoolExecutor
    ```

9. Asyncio and Asynchronous Programming

    - Asyncio: Provides a way to write asynchronous programs using async and await.

    ```python
    import asyncio

    async def main():
        print("Hello")
        await asyncio.sleep(1)
        print("World")
    ```

    - async and await: `async` marks a function as asynchronous, and `await` is used to pause the function until a result is returned.

    - Comparison with Threading/Multiprocessing: Asyncio is better for I/O-bound tasks requiring high concurrency, while threading and multiprocessing are better for CPU-bound tasks.

10. Type Hints and Annotations

    - Type Hints: Improve code readability and allow for static type checking.

    ```python
    def greet(name: str) -> str:
        return f"Hello, {name}"
    ```

- Typing Module: Provides types like `List`, `Dict`, `Tuple`, and `Callable`.

    ```python
    from typing import List, Dict, Callable
    ```

11. Regular Expressions

    - Regular Expressions: Powerful tool for string matching, defined with `re` module.

    ```python
    import re
    match = re.search(r'\d+', 'Sample123')
    ```

    - Regex Functions:
        - `match()`: Checks for a match at the beginning of a string.
        - `search()`: Searches for a pattern in the string.
        - `findall()`: Returns all occurrences of a pattern.
        - `sub()`: Replaces parts of a string.

12. Python Data Science Libraries

    - NumPy: Used for numerical computing with multidimensional arrays and mathematical functions.
    - Pandas: Data manipulation and analysis library.
    - Matplotlib: Visualization library for creating static, animated, and interactive plots.

13. Database Access and ORM

    - Database Connection: Use `sqlite3` for SQLite databases or libraries like `SQLAlchemy` for ORM.

    ```python
    import sqlite3
    conn = sqlite3.connect('example.db')
    ```

- ORM: `SQLAlchemy` maps database tables to Python classes, allowing object-oriented access.

    ```python
    from sqlalchemy import create_engine
    ```

14. Testing in Python

    - unittest and pytest: `unittest` is built into Python, while `pytest` provides more flexibility.

    - Mocking: Use `unittest.mock` to replace parts of code for testing.

    ```python
    from unittest.mock import Mock
    ```

    - Test Fixtures, Assertions, and Parameterized Tests: Fixtures set up state, assertions check expected outcomes, and parameterized tests test multiple inputs.

15. Networking and Web Development

    - HTTP Requests: Use requests library for making requests.

    ```python
    import requests
    response = requests.get("http://example.com")
    ```

    - Flask and Django: Popular frameworks for web development in Python, Flask for small projects, Django for larger applications.

    - WebSockets: Enables real-time communication using libraries like `websockets`.

16. Advanced Data Structures

    - Binary Tree, Linked List, Hash Table: Implement custom data structures in Python as needed, though most are available in libraries.
    - heapq Module: Provides heap functions in Python.
    - collections Module: `deque`, `Counter`, `defaultdict` provide advanced data structures.

17. Metaclasses and Dynamic Class Creation

    - Metaclasses: Define the behavior of classes themselves. Used to modify class creation.

    ```python
    class Meta(type):
        pass
    ```

    - Dynamic Class Creation: Use `type()` to create classes at runtime.

18. Python Memory Optimization Techniques

    - Generators: Use generators instead of lists for memory efficiency.
    - Optimizing Code: Use efficient data structures and algorithms.
    - Memory Inspection: Use `sys.getsizeof()` to measure object size.
