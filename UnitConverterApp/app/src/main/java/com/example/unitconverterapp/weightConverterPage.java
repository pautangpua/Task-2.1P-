package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class weightConverterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weight_converter_page);

        EditText sourceValue = findViewById(R.id.sourceValue);
        Spinner fromSpinner = (Spinner) findViewById(R.id.sourceSpinner);
        Spinner toSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        Button convertButton = findViewById(R.id.convertButton);
        TextView resultValue = findViewById(R.id.convertedValue);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.weightUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double tot;
                Double amount = Double.parseDouble(sourceValue.getText().toString());
                String fromUnit = fromSpinner.getSelectedItem().toString();
                String toUnit = toSpinner.getSelectedItem().toString();

                switch (fromUnit) {
                    case "Pound":
                        switch (toUnit) {
                            case "Pound":
                                tot = amount;
                                break;
                            case "Ounce":
                                tot = amount * 16.0;
                                break;
                            case "Ton":
                                tot = amount * 0.0005;
                                break;
                            case "Kilogram":
                                tot = amount * 0.453592;
                                break;
                            case "Gram":
                                tot = amount * 453.592;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Ounce":
                        switch (toUnit) {
                            case "Pound":
                                tot = amount / 16.0;
                                break;
                            case "Ounce":
                                tot = amount;
                                break;
                            case "Ton":
                                tot = amount * 0.00003125;
                                break;
                            case "Kilogram":
                                tot = amount * 0.0283495;
                                break;
                            case "Gram":
                                tot = amount * 28.3495;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Ton":
                        switch (toUnit) {
                            case "Pound":
                                tot = amount * 2000.0;
                                break;
                            case "Ounce":
                                tot = amount * 32000.0;
                                break;
                            case "Ton":
                                tot = amount;
                                break;
                            case "Kilogram":
                                tot = amount * 907.185;
                                break;
                            case "Gram":
                                tot = amount * 907185.0;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Kilogram":
                        switch (toUnit) {
                            case "Pound":
                                tot = amount * 2.20462;
                                break;
                            case "Ounce":
                                tot = amount * 35.274;
                                break;
                            case "Ton":
                                tot = amount * 0.00110231;
                                break;
                            case "Kilogram":
                                tot = amount;
                                break;
                            case "Gram":
                                tot = amount * 1000.0;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Gram":
                        switch (toUnit) {
                            case "Pound":
                                tot = amount * 0.00220462;
                                break;
                            case "Ounce":
                                tot = amount * 0.035274;
                                break;
                            case "Ton":
                                tot = amount * 0.00000110231;
                                break;
                            case "Kilogram":
                                tot = amount * 0.001;
                                break;
                            case "Gram":
                                tot = amount;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    default:
                        tot = 0.0;
                }
                resultValue.setText(String.valueOf(tot));
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}