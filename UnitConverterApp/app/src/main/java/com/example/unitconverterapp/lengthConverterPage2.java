package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;

public class lengthConverterPage2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_length_converter_page2);
        

        //Set Variable to ID
        EditText sourceValue = findViewById(R.id.sourceValue);
        Spinner fromSpinner = (Spinner) findViewById(R.id.sourceSpinner);
        Spinner toSpinner = (Spinner) findViewById(R.id.destinationSpinner);
        Button convertButton = findViewById(R.id.convertButton);
        TextView resultValue = findViewById(R.id.convertedValue);

        //Adapter to convert the String[] into Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.lengthUnits, android.R.layout.simple_spinner_item);
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

                //Use If condition at start, Switch statement is faster and cleaner
                switch (fromUnit) {
                    case "Inch":
                        switch (toUnit) {
                            case "Inch":
                                tot = amount;
                                break;
                            case "Foot":
                                tot = amount / 12.0;
                                break;
                            case "Yard":
                                tot = amount / 36.0;
                                break;
                            case "Mile":
                                tot = amount / 63360.0;
                                break;
                            case "Centimetres":
                                tot = amount * 2.54;
                                break;
                            case "Kilometres":
                                tot = amount * 0.0000254;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Foot":
                        switch (toUnit) {
                            case "Inch":
                                tot = amount * 12.0;
                                break;
                            case "Foot":
                                tot = amount;
                                break;
                            case "Yard":
                                tot = amount / 3.0;
                                break;
                            case "Mile":
                                tot = amount / 5280.0;
                                break;
                            case "Centimetres":
                                tot = amount * 30.48;
                                break;
                            case "Kilometres":
                                tot = amount * 0.0003048;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Yard":
                        switch (toUnit) {
                            case "Inch":
                                tot = amount * 36.0;
                                break;
                            case "Foot":
                                tot = amount * 3.0;
                                break;
                            case "Yard":
                                tot = amount;
                                break;
                            case "Mile":
                                tot = amount / 1760.0;
                                break;
                            case "Centimetres":
                                tot = amount * 91.44;
                                break;
                            case "Kilometres":
                                tot = amount * 0.0009144;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Mile":
                        switch (toUnit) {
                            case "Inch":
                                tot = amount * 63360.0;
                                break;
                            case "Foot":
                                tot = amount * 5280.0;
                                break;
                            case "Yard":
                                tot = amount * 1760.0;
                                break;
                            case "Mile":
                                tot = amount;
                                break;
                            case "Centimetres":
                                tot = amount * 160934.4;
                                break;
                            case "Kilometres":
                                tot = amount * 1.60934;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Centimetres":
                        switch (toUnit) {
                            case "Inch":
                                tot = amount * 0.393701;
                                break;
                            case "Foot":
                                tot = amount * 0.0328084;
                                break;
                            case "Yard":
                                tot = amount * 0.0109361;
                                break;
                            case "Mile":
                                tot = amount * 0.0000062137;
                                break;
                            case "Centimetres":
                                tot = amount;
                                break;
                            case "Kilometres":
                                tot = amount * 0.00001;
                                break;
                            default:
                                tot = 0.0;
                        }
                        break;
                    case "Kilometres":
                        switch (toUnit) {
                            case "Inch":
                                tot = amount * 39370.1;
                                break;
                            case "Foot":
                                tot = amount * 3280.84;
                                break;
                            case "Yard":
                                tot = amount * 1093.61;
                                break;
                            case "Mile":
                                tot = amount * 0.621371;
                                break;
                            case "Centimetres":
                                tot = amount * 100000.0;
                                break;
                            case "Kilometres":
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
        }
        );


                
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}