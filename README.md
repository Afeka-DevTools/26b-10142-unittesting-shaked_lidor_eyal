# Java Unit Testing with Gradle

A Java utility library with comprehensive JUnit 5 unit tests, built and run with Gradle.

---

## Team Members

- Shaked Gabay
- Lidor Even
- Eyal Goldstein

---

## Prerequisites

- **Java 21** — [Download](https://www.oracle.com/java/technologies/downloads/#java21) or install via Homebrew:
  ```bash
  brew install openjdk@21
  ```
- **Gradle** — included via the Gradle wrapper (`./gradlew`), no separate installation needed.

---

## Getting Started

### 1. Clone the repository

```bash
git clone <repository-url>
cd <repository-folder>
```

### 2. Set JAVA_HOME to Java 21

```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
```

### 3. Run the tests

```bash
./gradlew test
```

### 4. View the test report

```bash
open app/build/reports/tests/test/index.html
```

---

## Project Structure

```
.
├── app/
│   └── src/
│       ├── main/java/org/example/App.java       # Utility functions
│       └── test/java/org/example/AppTest.java   # Unit tests
├── gradle/
├── gradlew
└── README.md
```
