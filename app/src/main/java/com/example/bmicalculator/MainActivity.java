package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Part 2 + 3 + 4 + 5 + 6 work together here
    private EditText edtWeight, edtHeight;   // P2: Prudence (XML IDs) / P4: Kerry (wiring)
    private TextView txtResult;              // P2 + P3: layout / P4: wiring
    private Button btnCompute;               // P2: button in XML / P4: wiring

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Auto-generated insets handling (leave as is)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // =========================
        // Part 2, 3, 4: UI wiring
        // =========================

        // (Prudence: defines these IDs in activity_main.xml)
        // (Mercy: styles them)
        // (Kerry: connects them to code)

        edtWeight = findViewById(R.id.edtWeight);
        edtHeight = findViewById(R.id.edtHeight);
        txtResult = findViewById(R.id.txtResult);
        btnCompute = findViewById(R.id.btnCompute);

        // =========================

        // Part 4 + 5 + 6: Logic

        // =========================

        // Kerry: sets click listener and basic BMI calculation

        // Victor: defines BMI ranges and labels (Underweight, Normal, Overweight, Obese)

        //  input validation + crash prevention inside this listener
        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // ===== Part 6: Input Validation & Crash Prevention =====
                String wStr = edtWeight.getText().toString().trim();
                String hStr = edtHeight.getText().toString().trim();

                // Empty input check
                if (wStr.isEmpty() || hStr.isEmpty()) {
                    txtResult.setText("Please enter both weight and height.");
                    return;
                }

                try {
                    double weight = Double.parseDouble(wStr);
                    double height = Double.parseDouble(hStr);

                    // Non-positive values check
                    if (weight <= 0 || height <= 0) {
                        txtResult.setText("Weight and height must be positive numbers.");
                        return;
                    }

                    // ===== Part 4 + 5: BMI computation + classification =====
                    double bmi = weight / (height * height);

                    String category;
                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi < 25) {
                        category = "Normal";
                    } else if (bmi < 30) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    String resultText = String.format("BMI: %.1f (%s)", bmi, category);
                    txtResult.setText(resultText);

                } catch (NumberFormatException e) {
                    // Non-numeric input handling
                    txtResult.setText("Invalid input. Use numbers like 70 or 1.75.");
                }

            }
        });
    }
}
