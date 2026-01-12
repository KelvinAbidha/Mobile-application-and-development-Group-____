# Documentation Report: BMI Calculator Android Application


**Subject:** Technical Analysis and Functional Documentation

---

## 1. Executive Summary
This report provides a comprehensive overview of the **BMI Calculator**, an Android-based utility designed to compute a user's Body Mass Index (BMI). The application translates raw physical data (weight and height) into actionable health insights by categorizing the result into standard WHO (World Health Organization) classifications.

## 2. The "What": Application Overview
The BMI Calculator is a single-activity mobile application. Its primary function is to accept user input in metric units and output a numerical BMI value alongside a qualitative health category.

### Key Components:
* **User Inputs:** Weight (kg) and Height (m).
* **Logic Engine:** A mathematical processor that handles unit conversion and categorization.
* **Display:** A dynamic text output field that provides real-time feedback and error handling.

## 3. The "Why": Purpose and Utility
In an era of increasing health consciousness, digital tools that provide immediate feedback are essential. This application serves three primary purposes:

1. **Accessibility:** Provides a lightweight, offline method for users to monitor their health metrics.
2. **Accuracy:** Automates the calculation using the formula: $BMI = weight / (height * height)$.
3. **Preventative Health:** Prompts users to reflect on their health status through standard categorization.

## 4. The "How": Technical Implementation
The application is built using **Java** and the **Android SDK**. The code follows a strict validation pipeline to ensure stability.

### 4.1 Input Validation & Safety
The logic includes several safety checks to prevent application crashes:
* **Empty Check:** Ensures the user has entered data before calculating.
* **Division by Zero:** Specifically checks if height is `0` to prevent mathematical errors.
* **Number Format Exception:** Uses `try-catch` blocks to handle non-numeric inputs gracefully.

### 4.2 Categorization Logic
The result is mapped using the following standard ranges:

| BMI Range | Category |
| :--- | :--- |
| < 18.5 | Underweight |
| 18.5 – 24.9 | Normal |
| 25.0 – 29.9 | Overweight |
| > 30.0 | Obese |

## 5. Potential Enhancements
To evolve this application further, the following features are recommended:
* **Imperial Unit Support:** Toggle between Metric (kg/m) and Imperial (lbs/in).
* **Data Persistence:** Using a database to track BMI changes over time.
* **Visual Feedback:** Color-coding results for faster cognitive processing.

---
**Report by Cynthia** *Documentation Specialist*
