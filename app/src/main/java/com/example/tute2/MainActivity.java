package com.example.tute2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText pt_input;
    RadioButton radio_celcius;
    RadioButton radio_farenhite;
    Button btn_calculation;
    TextView textview_displayanswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pt_input = findViewById(R.id.pt_input);
        radio_celcius = findViewById(R.id.radio_celcius);
        radio_farenhite = findViewById(R.id.radio_farenhite);
        btn_calculation = findViewById(R.id.btn_Calculation);
        textview_displayanswer = findViewById(R.id.textview_displayanswer);
    }


    @Override
    protected void onResume() {
        super.onResume();
        btn_calculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }


    private void calculateAnswer() {
        Calculation calculation = new Calculation();//create an object
        String temp_value = pt_input.getText().toString();

        if (TextUtils.isEmpty(temp_value)) {

            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show(); //to display notification
            temp_value = "0.0";

            textview_displayanswer.setText(temp_value);
        } else {
            Float temp = Float.parseFloat(temp_value);
            if (radio_celcius.isChecked()) {
                // convert it into Fahrenheit and display the answer
                temp = calculation.convertCelciusToFahrenheit(temp);

            } else if (radio_farenhite.isChecked()) {
                // convert it into Celcius and display the answer//
                temp = calculation.convertFahrenheitToCelcius(temp);
            } else {
                Toast.makeText(this, "please Select the radio", Toast.LENGTH_LONG).show();
                temp = 0.0f;

            }
            textview_displayanswer.setText(new Float(temp).toString());
        }

    }
}













