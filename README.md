# BMI Calculator (Android)

Documentation report focused 2–3 page technical and product report that explains what this project is, why it exists, and how it works. This README combines a polished executive summary, a developer-focused design/implementation overview, user-facing usage notes, and answers to common technical questions.


---

## Executive summary

The BMI Calculator is a small, single-activity Android application implemented in Java. Its purpose is to compute a user's Body Mass Index (BMI) from metric inputs (weight in kilograms and height in meters), validate the inputs to prevent crashes, and present a concise, human-readable result accompanied by a WHO-style classification (Underweight, Normal, Overweight, Obese). The project is suitable as a learning exercise in Android UI wiring, input validation, and basic application flow.

---

## What — Project overview and features

- Single-activity Android application (package: `com.example.bmicalculator`).
- Inputs:
  - Weight in kilograms (e.g., `70`)
  - Height in meters (e.g., `1.75`)
- Behavior:
  - Validates that both fields are present and parseable as positive numbers.
  - Computes BMI using the formula BMI = weight / (height * height).
  - Classifies BMI into categories:
    - BMI < 18.5 → Underweight
    - 18.5 ≤ BMI < 25 → Normal
    - 25 ≤ BMI < 30 → Overweight
    - BMI ≥ 30 → Obese
  - Displays result formatted to one decimal place (e.g., `BMI: 22.9 (Normal)`).
- Error handling messages:
  - "Please enter both weight and height."
  - "Weight and height must be positive numbers."
  - "Invalid input. Use numbers like 70 or 1.75."
- Tests:
  - Example local unit test and instrumented test are present (basic templates).

---

## Why — Purpose, audience, and value

- Learning: The codebase is an ideal starter project for developers learning Android fundamentals: layouts, activity lifecycle, event handling, input parsing, and defensive programming.
- Utility: Provides a quick, offline calculation of BMI and a reference classification; useful for personal health awareness and demonstrations.
- Teaching & Demonstration: Good for classroom demonstrations or GitHub portfolio pieces illustrating input validation and UI feedback.
- Low friction: Minimal external dependencies; runs in Android Studio or via Gradle.

---

## How — Design and implementation details

High-level architecture
- UI layer: A simple layout (single activity) exposing two text inputs, a calculate button, and a text view for results.
- Controller: `MainActivity` wires UI controls and contains the full application logic: validation, parsing, calculation, classification, and user messaging.
- Tests: Basic sample unit and instrumentation tests—suitable as scaffolding to add more meaningful tests.

Key implementation points (from `MainActivity.java`)
- Edge-to-edge UI support is enabled via `EdgeToEdge.enable(this)` and `ViewCompat.setOnApplyWindowInsetsListener(...)` to apply system bar insets as padding.
- Input retrieval:
  - `String wStr = edtWeight.getText().toString().trim();`
  - `String hStr = edtHeight.getText().toString().trim();`
- Validation sequence:
  1. Check for empty inputs.
  2. Parse inputs using `Double.parseDouble(...)` inside a try/catch to guard against `NumberFormatException`.
  3. Reject non-positive numbers (<= 0).
- Computation:
  - `double bmi = weight / (height * height);`
  - Category determined via a standard if/else ladder.
  - Result formatted: `String.format("BMI: %.1f (%s)", bmi, category);`
- Error handling:
  - All user-facing errors are set into the `TextView` (no Toasts or dialogs), keeping the UI simple and immediate.

Edge cases handled
- Empty input fields -> explicit message.
- Non-numeric input -> handled by `NumberFormatException`.
- Zero or negative values -> explicit validation message to avoid divide-by-zero and nonsensical results.

Files of interest
- `app/src/main/java/com/example/bmicalculator/MainActivity.java` — main logic and UI wiring.
- `app/src/main/AndroidManifest.xml` — declares launcher activity and application metadata.
- `app/src/test/ExampleUnitTest.java` and `app/src/androidTest/ExampleInstrumentedTest.java` — test templates.

---

## Questions & Answers (concise, professional)

Q: What does the app do?
A: Computes BMI from weight (kg) and height (m), validates inputs, and displays BMI with a WHO-like category.

Q: Who is the target audience?
A: Beginners learning Android, instructors demonstrating basic app flow, or anyone needing an offline BMI calculator.

Q: Which technologies are used?
A: Java, Android SDK, AndroidX core libraries, Gradle build system.

Q: How is BMI computed and classified?
A: BMI = weight / (height * height). The classification follows standard WHO boundaries (Underweight, Normal, Overweight, Obese).

Q: How does the app prevent crashes?
A: Input checks for emptiness, try/catch for non-numeric parsing, and validation of positive, non-zero height to avoid division-by-zero.

Q: Is there data persistence or user history?
A: No — the current version does not persist data or keep a history. Results are displayed only in the UI.

Q: What are the main limitations?
A: Metric-only units, single-screen UI without accessibility labels and history, no tests for core calculation logic, no CI configuration, and no license file.

Q: How can the app be extended?
A: Add imperial unit support, use Room/SharedPreferences for history storage, add color-coded results, screenshots, accessibility improvements, additional tests, and CI workflows.

---

## Installation & quick start

Prerequisites
- Android Studio (recommended) or Android SDK + Gradle.
- JDK (as required by Android Gradle Plugin).

Run
1. Clone: git clone https://github.com/KelvinAbidha/Mobile-application-and-development-Group-____.git
2. Open in Android Studio → let Gradle sync.
3. Run on emulator/device or build via:
   - ./gradlew assembleDebug
   - ./gradlew installDebug

Run tests
- Unit tests: ./gradlew test
- Instrumented tests (device/emulator): ./gradlew connectedAndroidTest

---



## Contributing

Fork → create a feature branch → implement changes → open a pull request. Include tests for new logic and update README where relevant.

---

## Contact

Maintainers and contributors: see the repository contributors on GitHub.

---
