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
    private Button btnCompute;             // P2: button in XML / P4: wiring

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        

        edtWeight = findViewById(R.id.weightEditText);
        edtHeight = findViewById(R.id.heightEditText);
        txtResult = findViewById(R.id.resultTextView);
        btnCompute = findViewById(R.id.calculateButton);

        
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

                    //  BMI computation + classification 
                    double bmi = weight / (height * height);

                    String category;
                    if (bmi < 18.5) {
                        category = "Underweight"; // Outputs underweight for all instances where bmi < 18.5
                    } else if (bmi < 25) {
                        category = "Normal"; // Outputs normal for all instances where 18.5 <= bmi < 25
                    } else if (bmi < 30) {
                        category = "Overweight"; // Outputs overweight for all instances where 25 <= bmi < 30
                    } else {
                        category = "Obese"; // Outputs obese for all other instances i.e., where bmi >= 30
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
