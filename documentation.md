# ICS 2300 — Group Assignment 1
## Android App for BMI Classification

### Background
Body Mass Index (BMI) is a simple index of weight-for-height that is commonly used to classify underweight, overweight, and obesity in adults.

**BMI Formula:**
$BMI = weight(kg) / height(m)^2$

**Classification Thresholds:**
| BMI Range | Category |
| :--- | :--- |
| < 18.5 | Underweight |
| 18.5 ≤ BMI < 25 | Normal |
| 25 ≤ BMI < 30 | Overweight |
| ≥ 30 | Obese |

---

### i) App Design and Layout

#### Purpose
A single-screen Android application that accepts weight in kilograms and height in meters, computes the BMI, and displays both the numeric value and the health category.

#### Components (Single Activity)
* **Title (TextView):** Displays "BMI Calculator".
* **Weight Input (EditText):** * **ID:** `@+id/weightInput`
    * **Hint:** "Weight (kg)"
    * **Input Type:** `numberDecimal`
* **Height Input (EditText):** * **ID:** `@+id/heightInput`
    * **Hint:** "Height (m)"
    * **Input Type:** `numberDecimal`
* **Compute Button (Button):** * **ID:** `@+id/computeButton`
    * **Text:** "Compute BMI"
* **Result Display (TextView):** * **ID:** `@+id/resultText`
    * **Format:** BMI (2 decimal places) and Category (e.g., "BMI: 22.86\nCategory: Normal").

#### User Experience & Accessibility
* **Layout:** Simple vertical flow using `LinearLayout` or `ConstraintLayout` with 16–24dp padding.
* **Interaction:** Tapping inputs opens the numeric keyboard automatically.
* **Accessibility:** Includes content descriptions for elements and uses high-contrast text sizes.

---

### ii) Logic for BMI Calculation

#### Validation Rules
Before calculation, the app ensures:
1.  Both fields are non-empty.
2.  Values parse correctly as decimal numbers.
3.  **Weight:** Must be $\ge 0$.
4.  **Height:** Must be $> 0$ (prevents division by zero).

#### Computation Steps
1.  Read and trim `weightStr` and `heightStr`.
2.  Parse to numeric values (Double/Float).
3.  Apply formula: `bmi = weight / (height * height)`.
4.  Format result to two decimal places.
5.  Determine category based on thresholds.

#### Error Handling
* **Non-numeric/Empty:** "Enter valid numeric values for weight and height."
* **Zero/Negative Height:** "Height must be greater than zero."
* **Negative Weight:** "Enter a valid positive weight."

---

### iii) Screenshots

The following screenshots demonstrate the app's functionality and are located in the `screenshots/` directory:

1.  **Initial Screen** `screenshots/screen_initial.png`  
    *Shows the UI with empty fields upon launch.*
    ![WhatsApp Image 2026-01-13 at 9 01 52 AM](https://github.com/user-attachments/assets/a1d0f7f1-1c76-4b7e-a066-d918653572e8)


3.  **Successful Calculation** `screenshots/screen_result.png`  
    *Shows populated inputs and the calculated result with category.*
    ![WhatsApp Image 2026-01-13 at 9 03 03 AM](https://github.com/user-attachments/assets/5380c56c-3735-4801-8b57-54cf292ef2d2)


5.  **Validation/Error State** `screenshots/screen_error.png`  
    *Shows an example error message (e.g., height = 0 or empty field).*
    ![WhatsApp Image 2026-01-13 at 9 04 00 AM](https://github.com/user-attachments/assets/61cccf61-f3ff-4b81-86fd-ed2c9a751fae)
    ![WhatsApp Image 2026-01-13 at 9 04 26 AM](https://github.com/user-attachments/assets/9c82c03a-bc45-44ae-8085-274be60cdae4)



---
