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

public class temperatureConverterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_temperature_converter_page);


        //Set Variable to ID
        EditText sourceValue = findViewById(R.id.sourceValue);
        Spinner fromSpinner = (Spinner) findViewById(R.id.sourceSpinner);
        Spinner toSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        Button convertButton = findViewById(R.id.convertButton);
        TextView resultValue = findViewById(R.id.convertedValue);

        //Adapter to convert the String[] into Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperatureUnits, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        fromSpinner.setAdapter(adapter);
        toSpinner.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To test the Button
                //Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();

                Double tot;
                Double amount = Double.parseDouble(sourceValue.getText().toString());
                String fromUnit = fromSpinner.getSelectedItem().toString();
                String toUnit = toSpinner.getSelectedItem().toString();

                switch (fromUnit) {
                    case "Celsius":
                        switch (toUnit) {
                            case "Celsius":
                                tot = amount;
                                break;
                            case "Fahrenheit":
                                tot = (amount * 9 / 5) + 32;
                                break;
                            case "Kelvin":
                                tot = amount + 273.15;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Fahrenheit":
                        switch (toUnit) {
                            case "Celsius":
                                tot = (amount - 32) * 5 / 9;
                                break;
                            case "Fahrenheit":
                                tot = amount;
                                break;
                            case "Kelvin":
                                tot = (amount + 459.67) * 5 / 9;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Kelvin":
                        switch (toUnit) {
                            case "Celsius":
                                tot = amount - 273.15;
                                break;
                            case "Fahrenheit":
                                tot = (amount * 9 / 5) - 459.67;
                                break;
                            case "Kelvin":
                                tot = amount;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    default:
                        tot = 0.0;
                }resultValue.setText(String.valueOf(tot));
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}