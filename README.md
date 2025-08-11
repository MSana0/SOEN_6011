## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


# Gamma Function Calculator

## Overview

A Java application to compute the Gamma function using manual math implementations and a Swing GUI.  
The project follows the Google Java Style Guide, uses semantic versioning, and demonstrates accessibility and software engineering best practices.

---

## Structure

```
SOEN_6011/
├── pom.xml
├── google_checks.xml
├── src/
│   ├── main/java/ca/concordia/gamma/
│   │   ├── GammaCalculatorGUI.java
│   │   └── GammaFunction.java
│   └── test/java/ca/concordia/gamma/
│       └── GammaCalculatorTest.java
```

---

## Quality Assurance Steps

1. **Programming Style**
   - Compared Java styles using a mind map (see `snapshots/Mind map.png`)
   - Used Google Java Style Guide (`google_checks.xml`)

2. **Checkstyle**
   - Verified code style with:
     ```
     mvn checkstyle:check
     ```
   - See `snapshots/checkstyle.png`

3. **Static Analysis (PMD)**
   - Checked code quality with:
     ```
     mvn pmd:check
     ```
   - See `snapshots/PMD.png` and `snapshots/PMD results.png`

4. **Debugging (JDB)**
   - Used JDB to step through code and inspect variables
   - See `snapshots/JDB.png`

5. **Semantic Versioning**
   - Version constant: `public static final String VERSION = "1.0.0";`
   - Displayed in GUI window title

6. **GUI Design**
   - Swing-based, clear layout, error handling, and tooltips

7. **Accessibility**
   - Uses Java Accessibility API:
     ```java
     inputField.getAccessibleContext().setAccessibleName("Input value for x");
     calcButton.getAccessibleContext().setAccessibleDescription("Calculates the Gamma function for the entered value");
     ```

---

## How to Run

1. **Build:**
   ```
   mvn clean install
   ```

2. **Run GUI:**
   ```
   mvn exec:java -Dexec.mainClass="ca.concordia.gamma.GammaCalculatorGUI"
   ```

3. **Run Tests:**
   ```
   mvn test
   ```

---

## Snapshots

See the `snapshots/` folder for evidence of:
- Mind map (style decision)
- Checkstyle and PMD results
- JDB debugging session

---

## Authors

- Marium Sana Mim, Concordia University, SOEN 6011
