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

    private EditText edtWeight, edtHeight;
    private TextView txtResult;
    private Button btnCompute;

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
                String wStr = edtWeight.getText().toString().trim();
                String hStr = edtHeight.getText().toString().trim();

                if (wStr.isEmpty() || hStr.isEmpty()) {
                    txtResult.setText(getString(R.string.err_empty_input));
                    return;
                }

                try {
                    double weight = Double.parseDouble(wStr);
                    double height = Double.parseDouble(hStr);

                    if (weight <= 0 || height <= 0) {
                        txtResult.setText(getString(R.string.err_positive_values));
                        return;
                    }

                    // Use the refactored BMICalculator class
                    double bmi = BMICalculator.calculateBMI(weight, height);
                    String category = BMICalculator.getCategory(bmi);

                    String resultText = String.format(getString(R.string.bmi_result_format), bmi, category);
                    txtResult.setText(resultText);

                } catch (NumberFormatException e) {
                    txtResult.setText(getString(R.string.err_invalid_input));
                }
            }
        });
    }
}
