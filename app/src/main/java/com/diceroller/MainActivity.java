package com.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Random rand = new Random();

    int rollResult;
    int max;

    RadioButton d6RadioButton;
    RadioButton d20RadioButton;
    RadioButton d100RadioButton;

    Button rollButton;

    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        d6RadioButton = (RadioButton) findViewById(R.id.d6_radiobutton);
        d20RadioButton = (RadioButton) findViewById(R.id.d20_radiobutton);
        d100RadioButton = (RadioButton) findViewById(R.id.d100_radiobutton);

        rollButton = (Button) findViewById(R.id.roll_button);

        resultTextView = (TextView) findViewById(R.id.result_text_view);

        rollButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.roll_button:
                if (d6RadioButton.isChecked()) {
                    max = 6;
                    rollResult = rand.nextInt(max) + 1;
                } else if (d20RadioButton.isChecked()) {
                    max = 20;
                    rollResult = rand.nextInt(max) + 1;
                } else if (d100RadioButton.isChecked()) {
                    max = 100;
                    rollResult = rand.nextInt(max) + 1;
                } else rollResult = 0;
                resultTextView.setText(""+ rollResult);
                break;
        }

    }
}