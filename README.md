Java GUI Calculator with Gradle

Calculator Screenshot

A simple yet functional calculator with graphical user interface written in Java using Swing and built with Gradle.
Features

    All basic arithmetic operations (+, -, *, /)

    Additional functions:

        Clear (C)

        Backspace (⌫)

        Sign change (±)

        Square root (√)

        Decimal number support

    Modern UI (using FlatLaf)

    Error handling (division by zero, square root of negative numbers)

Requirements

    Java JDK 11 or higher

    Gradle 7.0 or higher

Installation & Running

    Clone the repository:
    bash

git clone https://github.com/your-repository/calculator.git
cd calculator

Build the project:
bash

gradle build

Run the application:
bash

gradle run

Or use the built JAR:
bash

    java -jar build/libs/calculator-1.0-SNAPSHOT.jar

Building Executable JAR

To create a standalone JAR file:
bash

gradle jar

The built JAR will be located at build/libs/calculator-1.0-SNAPSHOT.jar
Project Structure

```
calculator/
├── build.gradle
├── README.md
└── src/
└── main/
├── java/
│   └── com/
│       └── example/
│           └── calculator/
│               └── CalculatorApp.java
└── resources/
```

Technologies Used

    Java Swing - for GUI

    FlatLaf - for modern styling

    Gradle - for project building

Possible Improvements

    Adding scientific functions (powers, trigonometry)

    Support for parentheses and complex expressions

    Calculation history

    Dark theme

    Hotkey support

License

This project is licensed under the MIT License. See the LICENSE file for more information.